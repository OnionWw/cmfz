package com.wucong.cmfz.service;

import com.wucong.cmfz.enetiy.Admin;
import com.wucong.cmfz.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
@Transactional
public class AdminServiceImpl implements  AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin queryByName(String name) {
        Example example = new Example(Admin.class);
        example.createCriteria().andEqualTo("name",name);
        Admin a = adminMapper.selectOneByExample(example);
        return a;
    }
}
