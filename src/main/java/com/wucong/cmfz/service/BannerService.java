package com.wucong.cmfz.service;

import com.wucong.cmfz.enetiy.Banner;
import com.wucong.cmfz.dto.BannerDto;

public interface BannerService {
    public BannerDto queryAll(Integer page, Integer rows);
    public void insertOne(Banner banner);
    public void deleteById(Banner banner);
    public void updateOne(Banner banner);
}
