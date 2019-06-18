package com.my.service;

import com.my.model.User;

/**
 * @author zengwen
 * @version 1.0
 * @File name: IUserService
 * @Description:
 * @date 2019/03/13
 */
public interface IUserService {

    public void insertUser(User user);


    public User queryUser(String id);
}
