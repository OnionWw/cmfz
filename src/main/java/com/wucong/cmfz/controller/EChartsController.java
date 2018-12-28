package com.wucong.cmfz.controller;

import com.wucong.cmfz.enetiy.ProTemp;
import com.wucong.cmfz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/echarts")
public class EChartsController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getProCount")
    public Map<String,List<ProTemp>> getProCount() {
        List<ProTemp> list = userService.getCountByPro();
        Map<String,List<ProTemp>>map = new HashMap<String,List<ProTemp>>();
        map.put("data",list);
        return map;
    }
    @RequestMapping("/getMonCount")
    public Map<String,Object> getMonCount(){
        Map<String,Object> map = new HashMap<String,Object>();
        int[] temp = new int[3];
        for (int i = 0; i <= 2; i++) {
            temp[i] = userService.getCountByMonth(i+1);
        }
        map.put("data",temp);
        return  map;
    }
}
