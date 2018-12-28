package com.wucong.cmfz.dto;



import com.wucong.cmfz.enetiy.Album;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AlbumPageDto implements Serializable {

    private Integer total;
    private List<Album> rows;


}
