package com.djn.service;

import com.djn.dao.BlogDao;
import com.djn.pojo.Blog;
import com.djn.vo.BlogQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客业务实现
 * @author ChristmasKey
 * @date 2021-12-25-19:09
 */
@Service
public class BlogServiceImpl implements BlogService{

    @Resource
    private BlogDao blogDao;

    @Override
    public List<Blog> getAllBlogs() {
        return blogDao.queryAllBlogs(new Blog());
    }

    @Override
    public PageInfo<Blog> getAllBlogsByPage(int pageNum, int pageSize) {
        Blog blog = new Blog();
        blog.setRecommend(true);
        PageHelper.startPage(pageNum, pageSize);
        List<Blog> blogs = blogDao.queryAllBlogs(blog);
        return new PageInfo<>(blogs);
    }

    @Override
    public PageInfo<Blog> queryBlogsByPage(BlogQuery blogQuery, int pageSize) {
        Blog blog = new Blog();
        if (blogQuery.getTitle() != null && !"".equals(blogQuery.getTitle())) {
            blog.setTitle(blogQuery.getTitle());
        }

        if (blogQuery.getTypeId() != null && blogQuery.getTypeId() != 0) {
            blog.setTypeId(blogQuery.getTypeId());
        }

        if (blogQuery.getRecommend() != null) {
            blog.setRecommend(blogQuery.getRecommend());
        }
        PageHelper.startPage(blogQuery.getPageNum(), pageSize);
        List<Blog> blogs = blogDao.queryAllBlogs(blog);
        return new PageInfo<>(blogs);
    }

    @Override
    public Blog getBlogById(Integer id) {
        return blogDao.queryBlogById(id);
    }

    @Override
    public int countBlogByTitle(String title) {
        return blogDao.queryBlogByTitle(title);
    }

    @Override
    @Transactional
    public int addBlog(Blog blog) {
        return blogDao.addBlog(blog);
    }

    @Override
    @Transactional
    public int updateBlog(Blog blog) {
        return blogDao.updateBlog(blog);
    }

    @Override
    @Transactional
    public int deleteBlogById(Integer id) {
        return blogDao.deleteBlogById(id);
    }
}