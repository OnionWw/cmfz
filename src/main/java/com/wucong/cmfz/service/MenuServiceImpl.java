package com.wucong.cmfz.service;

import com.wucong.cmfz.enetiy.Menu;
import com.wucong.cmfz.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class MenuServiceImpl implements  MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> queryAll() {
        List<Menu> list = menuMapper.getAll();
        return list;
    }
}
