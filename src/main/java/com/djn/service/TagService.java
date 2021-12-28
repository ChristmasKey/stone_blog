package com.djn.service;

import com.djn.pojo.Tag;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 博客标签业务
 * @author ChristmasKey
 * @date 2021-12-24-17:50
 */
public interface TagService {

    List<Tag> queryTags();

    PageInfo<Tag> findAllTagsByPage(int pageNum, int pageSize);

    Tag getTagByName(String name);

    Tag getTagById(Integer id);

    List<Integer> getTagIdsByBlogId(Integer blogId);

    int addTag(Tag tag);

    int updateTag(Tag tag);

    int deleteTag(Integer id);
}