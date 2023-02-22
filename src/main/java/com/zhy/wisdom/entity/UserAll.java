package com.zhy.wisdom.entity;

import lombok.Data;

@Data
public class UserAll {
    private Integer id;

    private String name;

    private String gender;

    private Integer age;

    private String phone;

    private String registerMode;

    private String thirdPartyId;
}