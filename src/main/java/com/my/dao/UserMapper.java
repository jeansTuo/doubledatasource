package com.my.dao;

import com.my.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author zengwen
 * @File name: UserMapper
 * @Description:
 * @date 2019/03/13
 */
@Mapper
@Repository
public interface UserMapper {

    void insertUser(User user);

    User queryUser(String id);
}
