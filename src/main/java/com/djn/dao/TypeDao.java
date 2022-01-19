package com.djn.dao;

import com.djn.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 博客分类持久层
 * @author ChristmasKey
 * @date 2021-12-21-0:59
 */
@Mapper
@Repository
public interface TypeDao {

    //查询博客数最多的四个分类
    List<Type> queryTopFourType();

    //查询所有分类
    List<Type> queryTypes();

    //根据名称查询分类
    Type queryTypeByName(String name);

    //根据id查询分类
    Type queryTypeById(Integer id);

    //新增分类
    int addType(Type type);

    //修改分类
    int updateType(Type type);

    //删除分类
    int deleteTypeById(Integer id);
}