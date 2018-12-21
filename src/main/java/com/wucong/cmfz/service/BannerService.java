package com.wucong.cmfz.service;

import com.wucong.cmfz.enetiy.Banner;

import java.util.List;

public interface BannerService {
    public List<Banner> queryAll();
    public void insertOne(Banner banner);
    public void deleteById(Banner banner);
    public void updateOne(Banner banner);
}
