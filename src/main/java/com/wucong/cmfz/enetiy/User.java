package com.wucong.cmfz.enetiy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    private Integer id;
    private String phone;
    private String password;
    private String salt;
    private String sign;
    private String headPic;
    private String name;
    private String dharma;
    private String sex;
    private String province;
    private String city;
    private String status;
}
