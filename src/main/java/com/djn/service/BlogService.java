package com.djn.service;

import com.djn.pojo.Blog;
import com.djn.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 博客管理业务
 * @author ChristmasKey
 * @date 2021-12-06-1:21
 */
public interface BlogService {

    //根据id查询博客
    Blog getBlog(Long id);

    //带条件的分页查询
    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    //新增博客
    Blog saveBlog(Blog blog);

    //修改博客
    Blog updateBlog(Long id, Blog blog);

    //删除博客
    void deleteBlog(Long id);
}