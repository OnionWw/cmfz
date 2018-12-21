package com.wucong.cmfz.enetiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "menu")
public class Menu {
    private Integer id;
    private String title;
    private String iconCls;
    private String url;
    private List<Menu> children;
}
