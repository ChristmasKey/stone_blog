package com.djn.service;

import com.djn.pojo.User;

/**
 * 用户业务
 * @author ChristmasKey
 * @date 2021-12-17-23:27
 */
public interface UserService {

    User queryUserByNameAndPwd(String name, String password);
}