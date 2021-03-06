package com.wucong.cmfz.controller;



import com.wucong.cmfz.dto.AlbumPageDto;
import com.wucong.cmfz.enetiy.Album;
import com.wucong.cmfz.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;


@Controller
@RequestMapping("album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @RequestMapping("queryAll")
    @ResponseBody
    public AlbumPageDto queryAll(int page, int rows)
    {
        return albumService.queryByPage(page, rows);
    }


    @RequestMapping("add")
    @ResponseBody
    public void addAlbum(MultipartFile img, Album album, HttpSession session) throws IOException {
        ServletContext ctx = session.getServletContext();
        String realPath = ctx.getRealPath("/upload");
        System.out.println(realPath);
        String oldName = img.getOriginalFilename();
        long time = new Date().getTime();
        String newName = time + oldName;
        // 目标文件
        File descFile = new File(realPath + "/" + newName);
        // 上传
        img.transferTo(descFile);
        album.setCoverImg("/upload/" + newName);
        albumService.insert(album);
    }

}
