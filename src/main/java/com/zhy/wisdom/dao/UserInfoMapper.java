package com.zhy.wisdom.dao;

import com.zhy.wisdom.entity.UserInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper {
    int insert(UserInfo record);

    int insertSelective(UserInfo record);
}