package com.djn.web;

import com.djn.pojo.Blog;
import com.djn.service.BlogService;
import com.djn.service.TagService;
import com.djn.service.TypeService;
import com.djn.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 首页
 * @author ChristmasKey
 * @date 2021-12-01-13:42
 */
@Controller
public class IndexController {

    @Resource
    private BlogService blogService;

    @Resource
    private TypeService typeService;

    @Resource
    private TagService tagService;

    @Resource
    private UserService userService;

    /**
     * 跳转到首页
     */
    @GetMapping("/")
    public String toIndex(Model model, HttpSession session) {
        //查询博客总数
        // model.addAttribute("blogNum", blogService.getBlogTotalNum());
        session.setAttribute("blogNum", blogService.getBlogTotalNum());
        //分页查询博客
        PageInfo<Blog> blogsPage = blogService.queryBlogShowList(1, 5);
        model.addAttribute("blogsPage", blogsPage);
        //查询博客数最多的前四个分类
        // model.addAttribute("topFourType", typeService.queryTopFourType());
        session.setAttribute("topFourType", typeService.queryTopFourType());
        //查询博客数最多的前四个标签
        // model.addAttribute("topFourTag", tagService.queryTopFourTag());
        session.setAttribute("topFourTag", tagService.queryTopFourTag());
        //查询最新的四个推荐博客
        // model.addAttribute("latestFourBlog", blogService.queryLatestFourBlog());
        session.setAttribute("latestFourBlog", blogService.queryLatestFourBlog());
        return "bs_index";
    }

    @GetMapping("/{page}")
    public String getNextPageList(@PathVariable("page")int page, Model model) {
        //查询博客总数
        // model.addAttribute("blogNum", blogService.getBlogTotalNum());
        //分页查询博客
        PageInfo<Blog> blogsPage = blogService.queryBlogShowList(page, 5);
        model.addAttribute("blogsPage", blogsPage);
        return "bs_index";
    }
}