package com.djn.web.admin;

import com.djn.pojo.Blog;
import com.djn.service.BlogService;
import com.djn.service.TypeService;
import com.djn.vo.BlogQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客管理
 * @author ChristmasKey
 * @date 2021-12-25-19:10
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    @Resource
    private BlogService blogService;
    @Resource
    private TypeService typeService;

    /**
     * 分页显示博客列表
     */
    @GetMapping("/blogs")
    public String toBlogList(@RequestParam(defaultValue = "1", name = "pageNum")Integer pageNum, Model model) {
        PageInfo<Blog> blogsPage = blogService.getAllBlogsByPage(pageNum, 5);
        List<Blog> blogs = blogsPage.getList();
        for (Blog blog : blogs) {
            blog.setType(typeService.getTypeById(blog.getTypeId()));
        }
        model.addAttribute("blogsPage", blogsPage);
        model.addAttribute("types", typeService.queryTypes());
        return "admin/bs_blog_list";
    }

    /**
     * 分页显示条件搜索博客列表
     */
    @PostMapping("/blogs")
    public String searchBlogList(BlogQuery blogQuery, Model model) {
        if (blogQuery.getPageNum() == null) {
            blogQuery.setPageNum(1);
        }
        PageInfo<Blog> blogsPage = blogService.queryBlogsByPage(blogQuery, 5);
        List<Blog> blogs = blogsPage.getList();
        for (Blog blog : blogs) {
            blog.setType(typeService.getTypeById(blog.getTypeId()));
        }
        model.addAttribute("blogsPage", blogsPage);
        return "admin/bs_blog_list::blogList";
    }

    /**
     * 跳转到博客发布页面
     */
    @GetMapping("/blog")
    public String toBlogAdd(Model model) {
        model.addAttribute("blog", new Blog());
        return "admin/bs_blog_add";
    }
}