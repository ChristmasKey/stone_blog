package com.djn.service;

import com.djn.dao.UserRepository;
import com.djn.pojo.User;
import com.djn.utils.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户业务实现
 * @author ChristmasKey
 * @date 2021-12-04-14:19
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, MD5Utils.encrypt(password));
    }
}