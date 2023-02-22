package com.zhy.wisdom.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhy.wisdom.entity.UserAll;
import org.springframework.stereotype.Repository;

import java.util.List;

@DS("db1")
@Repository
public interface UserAllMapper extends BaseMapper<UserAll> {
    int insert(UserAll record);

    int insertSelective(UserAll record);

    List<UserAll> getAll();
}