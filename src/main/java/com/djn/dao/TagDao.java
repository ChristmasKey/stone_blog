package com.djn.dao;

import com.djn.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 博客标签持久层
 * @author ChristmasKey
 * @date 2021-12-24-16:29
 */
@Mapper
@Repository
public interface TagDao {

    //查询所有标签
    List<Tag> queryTags();

    //根据名称查询标签
    Tag queryTagByName(String name);

    //根据id查询标签
    Tag queryTagById(Integer id);

    //新增标签
    int addTag(Tag tag);

    //修改标签
    int updateTag(Tag tag);

    //删除标签
    int deleteTagById(Integer id);
}