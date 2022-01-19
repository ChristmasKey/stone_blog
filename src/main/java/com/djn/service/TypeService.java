package com.djn.service;

import com.djn.pojo.Type;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 博客分类业务
 * @author ChristmasKey
 * @date 2021-12-21-1:01
 */
public interface TypeService {

    List<Type> queryTopFourType();

    List<Type> queryTypes();

    PageInfo<Type> findAllTypesByPage(int pageNum, int pageSize);

    Type getTypeByName(String name);

    Type getTypeById(Integer id);

    int addType(Type type);

    int updateType(Type type);

    int deleteType(Integer id);
}