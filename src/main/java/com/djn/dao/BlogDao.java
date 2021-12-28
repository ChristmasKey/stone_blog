package com.djn.dao;

import com.djn.pojo.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 博客持久层
 * @author ChristmasKey
 * @date 2021-12-25-19:08
 */
@Mapper
@Repository
public interface BlogDao {

    //动态查询所有博客
    List<Blog> queryAllBlogs(Blog blog);

    //根据id查询博客
    Blog queryBlogById(Integer id);

    //根据标题查询博客数
    int countBlogByTitle(String title);

    //新增博客
    int addBlog(Blog blog);

    //新增博客标签
    int addBlogTags(List<Integer> tagIds, Integer blogId);

    //更新博客
    int updateBlog(Blog blog);

    //删除博客
    int deleteBlogById(Integer id);

    //删除博客标签
    int deleteBlogTags(Integer id);
}