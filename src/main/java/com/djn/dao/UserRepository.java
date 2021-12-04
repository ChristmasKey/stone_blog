package com.djn.dao;

import com.djn.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户持久层
 * @author ChristmasKey
 * @date 2021-12-04-14:20
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名和密码查用户
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    User findByUsernameAndPassword(String username, String password);
}