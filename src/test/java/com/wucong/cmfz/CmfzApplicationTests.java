package com.wucong.cmfz;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.wucong.cmfz.dto.AlbumPageDto;
import com.wucong.cmfz.enetiy.Admin;
import com.wucong.cmfz.enetiy.Album;
import com.wucong.cmfz.enetiy.Banner;
import com.wucong.cmfz.enetiy.Menu;
import com.wucong.cmfz.service.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    @Autowired
    private AlbumService albumService;
    @Autowired
    private UserService userService;
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
    @Test
    public void test3(){
        AlbumPageDto dto = albumService.queryByPage(1,3);
        System.out.println(dto);
    }
    @Test
    public void exportExcel(){
        List<Album> list = albumService.queryAll();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("专辑详情", "章节", "表1"),
                Album.class, list);
        try {
            workbook.write(new FileOutputStream(new File("D:/Exc.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test4(){
        Integer i = userService.getCountByMonth(2);
        System.out.println(i);
    }


}

