package com.wucong.cmfz.service;

import com.github.pagehelper.PageHelper;
import com.wucong.cmfz.enetiy.Banner;
import com.wucong.cmfz.dto.BannerDto;
import com.wucong.cmfz.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public BannerDto queryAll(Integer page,Integer rows) {
        List<Banner> list1 = bannerMapper.selectAll();
        PageHelper.startPage(page,rows);
        List<Banner> list2 = bannerMapper.selectAll();
        BannerDto dto = new BannerDto(list2,list1.size());
        return  dto;
    }

    @Override
    public void insertOne(Banner banner) {
        bannerMapper.insert(banner);
    }

    @Override
    public void deleteById(Banner banner) {
        bannerMapper.delete(banner);
    }

    @Override
    public void updateOne(Banner banner) {
        bannerMapper.updateByPrimaryKey(banner);
    }
}
