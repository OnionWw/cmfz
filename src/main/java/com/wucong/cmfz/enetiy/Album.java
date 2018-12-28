package com.wucong.cmfz.enetiy;


import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelIgnore;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "album")
@ExcelTarget("album")
public class Album implements Serializable {
    private Integer id;
    @Excel(name = "专辑名称",orderNum = "1",needMerge = true)
    private String title;
    private int count;
    @Excel(name = "专辑封面",type = 2,width = 50,height = 50,needMerge = true)
    private String coverImg;
    private String score;
    private String author;
    private String broadcast;
    private String brief;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date pubDate;
    @ExcelCollection(name = "章节",orderNum = "4")
    private List<Chapter> children;


}
