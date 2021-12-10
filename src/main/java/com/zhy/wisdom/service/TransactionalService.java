package com.zhy.wisdom.service;

import com.zhy.wisdom.dao.UserAllMapper;
import com.zhy.wisdom.entity.UserAll;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class TransactionalService {

    @Resource
    private UserAllMapper userAllMapper;

    @Transactional(rollbackFor = {RuntimeException.class}, propagation = Propagation.REQUIRES_NEW, timeout = 30)
    public void  testTransactional(){
        UserAll userAll = new UserAll();
        userAll.setName("Transactional01");
        userAll.setAge(28);
        userAll.setPhone("150****1819");
        userAllMapper.insert(userAll);
        int i = 1/0;
    }
}
