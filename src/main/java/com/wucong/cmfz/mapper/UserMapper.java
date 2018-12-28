package com.wucong.cmfz.mapper;

import com.wucong.cmfz.enetiy.ProTemp;
import com.wucong.cmfz.enetiy.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    public List<ProTemp> selectCountByProvince();
    public Integer selectCountByMonth(@Param("mon") Integer month);
}
