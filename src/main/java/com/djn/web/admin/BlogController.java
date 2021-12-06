package com.djn.web.admin;

import com.djn.pojo.Blog;
import com.djn.pojo.User;
import com.djn.service.BlogService;
import com.djn.service.TypeService;
import com.djn.vo.BlogQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 博客管理控制器
 * @author ChristmasKey
 * @date 2021-12-04-15:28
 */
@Controller
@RequestMapping("/admin")
public class BlogController {

    private static final String INPUT = "admin/publish";
    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";

    @Resource
    private BlogService blogService;
    @Resource
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(
            size = 2,
            sort = {"updateTime"},
            direction = Sort.Direction.DESC) Pageable pageable,
                        BlogQuery blog,
                        Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return LIST;
    }

    @PostMapping("/blogs/search")
    public String search(@PageableDefault(
            size = 2,
            sort = {"updateTime"},
            direction = Sort.Direction.DESC) Pageable pageable,
                         BlogQuery blog,
                         Model model) {
        model.addAttribute("page", blogService.listBlog(pageable, blog));
        return "/admin/blogs::blogList";
    }

    @GetMapping("/blogs/input")
    public String input(Model model) {
        model.addAttribute("types", typeService.listType());
        // model.addAttribute("tags", tagService.listTag());
        model.addAttribute("blog", new Blog());
        return INPUT;
    }

    @PostMapping("/blogs")
    public String post(Blog blog, HttpSession session, RedirectAttributes attributes) {

        blog.setUser((User)session.getAttribute("user"));

        Blog b = blogService.saveBlog(blog);

        if (b == null) {
            attributes.addFlashAttribute("message", "操作失败");
        } else {
            attributes.addFlashAttribute("message", "操作成功");
        }
        return REDIRECT_LIST;
    }
}