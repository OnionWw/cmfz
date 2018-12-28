package com.wucong.cmfz.service;


import com.wucong.cmfz.dto.AlbumPageDto;
import com.wucong.cmfz.enetiy.Album;

import java.util.List;

public interface AlbumService {

    public List<Album> queryAll();

    public AlbumPageDto queryByPage(int curPage, int pageSize);

    void insert(Album album);
}
