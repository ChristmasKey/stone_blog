package com.djn.dao;

import com.djn.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 用户持久层
 * @author ChristmasKey
 * @date 2021-12-17-23:13
 */
@Mapper
@Repository
public interface UserDao {

    User queryUserByNameAndPwd(String username, String password);
}