package com.djn.web.admin;

import com.djn.pojo.Blog;
import com.djn.pojo.User;
import com.djn.service.BlogService;
import com.djn.service.TagService;
import com.djn.service.TypeService;
import com.djn.vo.BlogQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
    @Resource
    private TagService tagService;

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
        model.addAttribute("types", typeService.queryTypes());
        model.addAttribute("tags", tagService.queryTags());
        model.addAttribute("blog", new Blog());
        return "admin/bs_blog_add";
    }

    /**
     * 跳转到博客修改页面
     */
    @GetMapping("/blog/{id}")
    public String toBlogEdit(@PathVariable("id")Integer id, Model model) {
        model.addAttribute("types", typeService.queryTypes());
        model.addAttribute("tags", tagService.queryTags());
        Blog blogById = blogService.getBlogById(id);
        blogById.setTagIds(tagService.getTagIdsByBlogId(id));
        model.addAttribute("blog", blogById);
        return "admin/bs_blog_add";
    }

    /**
     * 发布/更新博客
     */
    @PostMapping("/blog")
    public String blogAdd(@Valid Blog blog, BindingResult result,
                          HttpSession session, Model model, RedirectAttributes attributes) {

        //关于”表单对于未选中的checkbox不会提交到后端“这件事
        if (blog.getAppreciation() == null) {
            blog.setAppreciation(false);
        }

        if (blog.getShareStatement() == null) {
            blog.setShareStatement(false);
        }

        if (blog.getCommentable() == null) {
            blog.setCommentable(false);
        }

        if (blog.getPublished() == null) {
            blog.setPublished(false);
        }

        if (blog.getRecommend() == null) {
            blog.setRecommend(false);
        }

        if (result.hasErrors()) {
            model.addAttribute("types", typeService.queryTypes());
            model.addAttribute("tags", tagService.queryTags());
            return "admin/bs_blog_add";
        }

        if (blog.getId() == null) {//新增
            User user = (User)session.getAttribute("user");
            blog.setUserId(user.getId());
            int res = blogService.addBlog(blog);

            if (res > 0) {
                attributes.addFlashAttribute("message", "添加成功");
            } else {
                attributes.addFlashAttribute("errorMsg", "添加失败");
            }
        } else {//更新
            int res = blogService.updateBlog(blog);

            if (res > 0) {
                attributes.addFlashAttribute("message", "更新成功");
            } else {
                attributes.addFlashAttribute("errorMsg", "更新失败");
            }
        }

        return "redirect:/admin/blogs";
    }

    /**
     * 删除博客
     */
    @GetMapping("/blog/del/{id}")
    public String blogDelete(@PathVariable("id")Integer id, RedirectAttributes attributes) {
        int res = blogService.deleteBlogById(id);

        if (res > 0) {
            attributes.addFlashAttribute("message", "删除成功");
        } else {
            attributes.addFlashAttribute("errorMsg", "删除失败");
        }

        return "redirect:/admin/blogs";
    }
}