package com.wucong.cmfz.service;

import com.wucong.cmfz.enetiy.Banner;
import com.wucong.cmfz.mapper.BannerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Override
    public List<Banner> queryAll() {
        List<Banner> list = bannerMapper.selectAll();
        return  list;
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
