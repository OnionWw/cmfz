package com.wucong.cmfz;

import com.wucong.cmfz.enetiy.Admin;
import com.wucong.cmfz.enetiy.Banner;
import com.wucong.cmfz.enetiy.Menu;
import com.wucong.cmfz.service.AdminService;
import com.wucong.cmfz.service.BannerService;
import com.wucong.cmfz.service.BannerServiceImpl;
import com.wucong.cmfz.service.MenuService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {
    @Autowired
    private AdminService adminService;
    @Autowired
    private MenuService menuService;
    @Autowired
    private BannerService bannerService;
    @Test
    public void contextLoads() {
        Admin a = adminService.queryByName("root");
        System.out.println(a);
    }
    @Test
    public void test1(){
        List<Menu> list = menuService.queryAll();
        System.out.println(list);
    }
    @Test
    public void test2(){
        //从数据库中查询所有Banner
        Banner banner = new Banner(1,"泥鳅","../banner/1.png","Y",null,"安全着陆");
        bannerService.updateOne(banner);
    }

}

