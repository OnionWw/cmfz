package com.wucong.cmfz.service;

import com.wucong.cmfz.enetiy.ProTemp;
import com.wucong.cmfz.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<ProTemp> getCountByPro() {
        List<ProTemp> list = userMapper.selectCountByProvince();
        return list;
    }

    @Override
    public Integer getCountByMonth(Integer mon) {
        return userMapper.selectCountByMonth(mon);
    }
}
