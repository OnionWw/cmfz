package com.wucong.cmfz.controller;



import com.wucong.cmfz.enetiy.Chapter;
import com.wucong.cmfz.service.ChapterService;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.MultimediaInfo;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.Date;

@Controller
@RequestMapping("/chapter")
public class ChapterController {
    @Autowired
    ChapterService chapterService;


    @RequestMapping("/add")
    @ResponseBody
    public void  addChapter(MultipartFile music, Chapter chapter, HttpSession session)  throws IOException {
        //计算音频大小
        long size = music.getSize();
        DecimalFormat df = new DecimalFormat("#.00");
        String temp = df.format(size/(1024*1024.0))+"mb";
        chapter.setSize(temp);
        //获取音频时长
        Encoder encoder = new Encoder();
        MultimediaInfo m = null;
        try {
            m = encoder.getInfo((File) music);
            long ls = m.getDuration();
            String time = ls / 60000 + "分" + (ls%60000) / 1000 + "秒";
            chapter.setDuration(time);
        } catch (EncoderException e) {
            e.printStackTrace();
        }
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/music");
        String oldName = music.getOriginalFilename();
        long time = new Date().getTime();
        String newName = time + oldName;
        // 目标文件
        File descFile = new File(realPath + "/" + newName);
        // 上传
        music.transferTo(descFile);
        chapter.setUrl("/music/" + newName);
        chapterService.insert(chapter);

    }



    @RequestMapping("/download")
        public void filedownload(String url,HttpSession session,HttpServletResponse response) throws IOException{
            // 获取server端文件的 字节数组

            String realPath = session.getServletContext().getRealPath("/");
            System.out.println(realPath);
            System.out.println(url);
            File srcFile = new File(realPath+"/"+url);
            byte[] bs = FileUtils.readFileToByteArray(srcFile);

            // 设置响应头信息，以附件的形式下载
            response.setHeader("content-disposition", "attchment;filename="+ URLEncoder.encode(url, "utf-8"));

            // 使用响应输出流，往client输出文件内容
            ServletOutputStream sos = response.getOutputStream();
            sos.write(bs);
        }


}
