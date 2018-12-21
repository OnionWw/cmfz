package com.wucong.cmfz.controller;

import com.wucong.cmfz.enetiy.Menu;
import com.wucong.cmfz.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @ResponseBody
    @RequestMapping("/getAllMenu")
    public List<Menu> getAll(){
        List<Menu>list = menuService.queryAll();
        return list;
    }
}
