package com.wucong.cmfz.dto;

import com.wucong.cmfz.enetiy.Banner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerDto {
    private List<Banner> rows;
    private Integer total;
}
