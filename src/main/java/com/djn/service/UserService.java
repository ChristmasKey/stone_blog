package com.djn.service;

import com.djn.pojo.User;

/**
 * 用户业务
 * @author ChristmasKey
 * @date 2021-12-04-14:17
 */
public interface UserService {

    /**
     * 用户验证
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User checkUser(String username, String password);
}