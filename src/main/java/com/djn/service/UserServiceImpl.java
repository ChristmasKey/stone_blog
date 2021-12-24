package com.djn.service;

import com.djn.dao.UserDao;
import com.djn.pojo.User;
import com.djn.utils.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户业务实现
 * @author ChristmasKey
 * @date 2021-12-17-23:28
 */
@Service
public class UserServiceImpl implements UserService{

    @Resource
    private UserDao userDao;

    public User queryUserByNameAndPwd(String username, String password) {
        return userDao.queryUserByNameAndPwd(username, MD5Utils.encrypt(password));
    }
}