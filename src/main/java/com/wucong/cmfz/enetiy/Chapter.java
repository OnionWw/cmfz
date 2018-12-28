package com.wucong.cmfz.enetiy;

import cn.afterturn.easypoi.excel.annotation.Excel;
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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chapter")
@ExcelTarget("chapter")
public class Chapter implements Serializable {
    @Id
    @Excel(name = "序号",height = 20,width = 30)
    private Integer id;
    @Excel(name = "标题",height = 20,width = 30)
    private String title;
    @Excel(name = "大小",suffix = "MB",height = 20,width = 30)
    private String size;
    @Excel(name = "时长",height = 20,width = 30)
    private String duration;
    @Excel(name = "路径",height = 20,width = 30)
    private String url;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "上传日期",databaseFormat = "yyyy-MM-dd HH:mm:ss",format = "yyyy-MM-dd HH:mm:ss",height = 20,width = 50)
    private Date uploadDate;
    private Integer albumId;
}
