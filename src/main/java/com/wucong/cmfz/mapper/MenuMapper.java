package com.wucong.cmfz.mapper;

import com.wucong.cmfz.enetiy.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu> {
    public List<Menu> getAll();
}
