package com.wucong.cmfz.controller;

import com.wucong.cmfz.enetiy.Admin;
import com.wucong.cmfz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("/getByName")
    public Admin getByName(String name){
        System.out.println(name);
        Admin admin = adminService.queryByName(name);
        System.out.println(admin);
        return admin;
    }
}
