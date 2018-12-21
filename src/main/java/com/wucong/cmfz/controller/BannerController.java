package com.wucong.cmfz.controller;

import com.wucong.cmfz.enetiy.Banner;
import com.wucong.cmfz.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @ResponseBody
    @RequestMapping("/getAll")
    public List<Banner> getAll(){
        List<Banner> list = bannerService.queryAll();
        return list;
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
    public void insertOne(){

    }
}
