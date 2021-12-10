package com.zhy.wisdom.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.zhy.wisdom.entity.UserAll;
import org.springframework.stereotype.Repository;

import java.util.List;

@DS("db1")
@Repository
public interface UserAllMapper {
    int insert(UserAll record);

    int insertSelective(UserAll record);

    List<UserAll> getAll();
}