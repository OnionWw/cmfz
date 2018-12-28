package com.wucong.cmfz.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.wucong.cmfz.enetiy.Album;
import com.wucong.cmfz.service.AlbumService;
import com.wucong.cmfz.service.ChapterService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/POI")
public class POIController {
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private AlbumService albumService;

    public void exportExcel(){
        List<Album> list = albumService.queryAll();
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("2412312", "测试", "测试"),
                Album.class, list);
        try {
            workbook.write(new FileOutputStream(new File("D:/Exc.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
