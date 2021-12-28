package com.djn.service;

import com.djn.dao.BlogDao;
import com.djn.pojo.Blog;
import com.djn.vo.BlogQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 博客业务实现
 * @author ChristmasKey
 * @date 2021-12-25-19:09
 */
@Service
public class BlogServiceImpl implements BlogService {

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
        return blogDao.countBlogByTitle(title);
    }

    @Override
    @Transactional
    public int addBlog(Blog blog) {
        //设置初始浏览量
        blog.setViews(0);
        //设置博客创建时间
        blog.setCreateTime(new Date());
        //设置博客更新时间
        blog.setUpdateTime(new Date());
        //添加博客
        blogDao.addBlog(blog);
        //根据id添加博客标签
        return blogDao.addBlogTags(blog.getTagIds(), blog.getId());
    }

    /*
    关于博客更新前后的标签
    简单粗暴：删了重插（目前采用）
    优化：比较更新前后的标签list，
         获得待删除标签list和待插入标签list，
         分别根据两个list执行删除和插入操作，其他标签不变
         以此减少数据库“写”操作量
     */
    @Override
    @Transactional
    public int updateBlog(Blog blog) {
        //设置博客更新时间
        blog.setUpdateTime(new Date());
        //更新博客
        blogDao.updateBlog(blog);
        //根据id删除博客标签
        blogDao.deleteBlogTags(blog.getId());
        //重新添加博客标签
        return blogDao.addBlogTags(blog.getTagIds(), blog.getId());
    }

    @Override
    @Transactional
    public int deleteBlogById(Integer id) {
        //删除博客标签
        blogDao.deleteBlogTags(id);
        //删除博客
        return blogDao.deleteBlogById(id);
    }
}