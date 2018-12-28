package com.wucong.cmfz.controller;

import com.wucong.cmfz.enetiy.Banner;
import com.wucong.cmfz.dto.BannerDto;
import com.wucong.cmfz.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @ResponseBody
    @RequestMapping("/getAll")
    public BannerDto getAll(Integer page,Integer rows){
        return  bannerService.queryAll(page,rows);
    }
    @ResponseBody
    @RequestMapping("/update")
    public String updateStatus(Banner banner){
        bannerService.updateOne(banner);
        return "";
    }
    @ResponseBody
    @RequestMapping("/delete")
    public String deleteSelected(Banner banner){
        bannerService.deleteById(banner);
        return "";
    }

    @RequestMapping("/insert")
    @ResponseBody
    public String insertOne(Banner banner,HttpSession session, MultipartFile file1){
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/upload");
        // 目标文件
        File descFile = new File(realPath+"/"+file1.getOriginalFilename());
        // 上传
        try {
            file1.transferTo(descFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        banner.setImgPath("/upload/"+file1.getOriginalFilename());
        System.out.println(banner.getImgPath());
        bannerService.insertOne(banner);
        return  "";
    }
}
