package com.wucong.cmfz.service;

import com.wucong.cmfz.enetiy.Chapter;
import com.wucong.cmfz.mapper.ChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ChapterServiceImpl implements  ChapterService{
    @Autowired
    ChapterMapper chapterMapper;
    public void insert(Chapter chapter){
        chapterMapper.insert(chapter);
    }


}
