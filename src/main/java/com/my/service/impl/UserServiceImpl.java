package com.my.service.impl;

import com.my.dao.UserMapper;
import com.my.model.User;
import com.my.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zengwen
 * @version 1.0
 * @File name: UserServiceImpl
 * @Description:
 * @date 2019/03/13
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }


    @Override
    public User queryUser(String id) {
        return userMapper.queryUser(id);
    }
}
