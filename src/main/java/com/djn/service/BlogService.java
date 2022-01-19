package com.djn.service;

import com.djn.pojo.Blog;
import com.djn.vo.BlogQuery;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 博客业务
 * @author ChristmasKey
 * @date 2021-12-25-19:08
 */
public interface BlogService {

    PageInfo<Blog> queryBlogShowList(int pageNum, int pageSize);

    List<Blog> queryLatestFourBlog();

    int getBlogTotalNum();

    List<Blog> getAllBlogs();

    PageInfo<Blog> getAllBlogsByPage(int pageNum, int pageSize);

    PageInfo<Blog> queryBlogsByPage(BlogQuery blogQuery, int pageSize);

    Blog getBlogById(Integer id);

    int countBlogByTitle(String title);

    int addBlog(Blog blog);

    int updateBlog(Blog blog);

    int deleteBlogById(Integer id);
}