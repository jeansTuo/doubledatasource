package com.my.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author zengwen
 * @version 1.0
 * @File name: User
 * @Description:
 * @date 2019/03/13
 */
public class User implements Serializable {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "年龄")
    private int userAge;

    /**
     * Gets the value of id.
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * <p>You can use getId() to get the value of id</p>
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the value of userName.
     *
     * @return the value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the userName.
     *
     * <p>You can use getUserName() to get the value of userName</p>
     *
     * @param userName userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the value of userAge.
     *
     * @return the value of userAge
     */
    public int getUserAge() {
        return userAge;
    }

    /**
     * Sets the userAge.
     *
     * <p>You can use getUserAge() to get the value of userAge</p>
     *
     * @param userAge userAge
     */
    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
}
