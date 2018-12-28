package com.wucong.cmfz.service;

import com.wucong.cmfz.enetiy.ProTemp;

import java.util.List;

public interface UserService {
    public List<ProTemp> getCountByPro();
    public Integer getCountByMonth(Integer mon);
}
