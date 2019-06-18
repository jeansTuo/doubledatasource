package com.my.controller;

import com.my.model.User;
import com.my.service.IUserService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zengwen
 * @version 1.0
 * @File name: UserController
 * @Description:
 * @date 2019/03/13
 */
@Api(value = "API - UserController", description = "用户接口")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource(name = "userServiceImpl")
    private IUserService userService;

    @ApiOperation(value = "查询", notes = "此接口描述xxxxxxxxxxxxx<br/>xxxxxxx<br>值得庆幸的是这儿支持html标签<hr/>", response = User.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "1", required = false,
                    dataType = "string", paramType = "query", defaultValue = "1")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @RequestMapping(value = "/queryUser", method = RequestMethod.GET)
    public User queryUser(String id){
        User user = userService.queryUser(id);
        return user;
    }


    @ApiOperation(value = "查询", notes = "此接口描述xxxxxxxxxxxxx<br/>xxxxxxx<br>值得庆幸的是这儿支持html标签<hr/>", response = User.class)
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "张三", required = false,
                    dataType = "string", paramType = "update", defaultValue = "张三"),
            @ApiImplicitParam(name = "userAge", value = "18", required = false,
                    dataType = "string", paramType = "update", defaultValue = "18")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful — 请求已完成"),
            @ApiResponse(code = 400, message = "请求中有语法问题，或不能满足请求"),
            @ApiResponse(code = 401, message = "未授权客户机访问数据"),
            @ApiResponse(code = 404, message = "服务器找不到给定的资源；文档不存在"),
            @ApiResponse(code = 500, message = "服务器不能完成请求")}
    )
    @RequestMapping(value = "/insertUser", method = RequestMethod.GET)
    public String insertUser(User user){
        userService.insertUser(user);
        return "insert ok !";
    }


}
