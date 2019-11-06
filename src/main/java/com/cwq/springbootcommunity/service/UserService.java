package com.cwq.springbootcommunity.service;

import com.cwq.springbootcommunity.mapper.UserMapper;
import com.cwq.springbootcommunity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cwq
 * @date 2019/11/6 - 17:21
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {

       User dbuser =  userMapper.findByAccountId(user.getAccountId());
        if(dbuser == null){
            //插入
            user.setGmtCreate(String.valueOf(System.currentTimeMillis()));
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }else{
            //更新
            dbuser.setGmtModified(String.valueOf(System.currentTimeMillis()));
            dbuser.setAvatarUrl(user.getAvatarUrl());
            dbuser.setName(user.getName());
            dbuser.setToken(user.getToken());
            userMapper.update(dbuser);
        }
    }
}
