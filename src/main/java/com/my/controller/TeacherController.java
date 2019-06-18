package com.my.controller;

import com.alibaba.fastjson.JSON;
import com.my.model.Teacher;
import com.my.model.User;
import com.my.service.ITeacherService;
import com.my.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author admin
 * @version 1.0
 * @date 2019/06/18
 */
@RestController
@RequestMapping(value = "/teacher")
public class TeacherController {

    @Resource(name = "userServiceImpl")
    private IUserService userService;
    @Resource(name = "teacherServiceImpl")
    private ITeacherService teacherService;

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public String query(){
        User user = userService.queryUser("5");
        List<Teacher> list = teacherService.queryTearcher();
//        List list = null;
        String userStr = JSON.toJSONString(user);
        String teacherStr = JSON.toJSONString(list);
        String result = "user库查询数据:<br/>"+userStr+"<br/>teacher库查询数据：<br/>"+teacherStr;
        return result;
    }

}
