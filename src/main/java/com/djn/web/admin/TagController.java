package com.djn.web.admin;

import com.djn.pojo.Tag;
import com.djn.service.TagService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 博客标签管理
 * @author ChristmasKey
 * @date 2021-12-24-18:40
 */
@Controller
@RequestMapping("/admin")
public class TagController {

    @Resource
    private TagService tagService;

    /**
     * 分页显示博客标签列表
     */
    @GetMapping("/tags")
    public String toTagList(@RequestParam(defaultValue = "1", name = "pageNum")Integer pageNum, Model model) {
        PageInfo<Tag> tagsPage = tagService.findAllTagsByPage(pageNum, 5);
        model.addAttribute("tagsPage", tagsPage);
        return "admin/bs_tag_list";
    }

    /**
     * 跳转到新增标签页面
     */
    @GetMapping("/tag")
    public String toTagAdd(Model model) {
        model.addAttribute("tag", new Tag());
        return "admin/bs_tag_add";
    }

    /**
     * 跳转到修改标签页面
     */
    @GetMapping("/tag/{id}")
    public String toTagEdit(@PathVariable("id")Integer id, Model model) {
        model.addAttribute("tag", tagService.getTagById(id));
        return "admin/bs_tag_add";
    }

    /**
     * 新增/更新标签
     */
    @PostMapping("/tag")
    public String tagAdd(@Valid Tag tag, BindingResult result, RedirectAttributes attributes) {
        //标签已存在校验
        Tag existTag = tagService.getTagByName(tag.getName());

        if (existTag != null) {
            result.rejectValue("name", "nameError", "标签名称已存在");
        }

        if (result.hasErrors()) {
            return "admin/bs_tag_add";
        }

        if (tag.getId() == null) {//新增
            int res = tagService.addTag(tag);

            if (res > 0) {
                attributes.addFlashAttribute("message", "添加成功");
            } else {
                attributes.addFlashAttribute("errorMsg", "添加失败");
            }
        } else {//更新
            int res = tagService.updateTag(tag);

            if (res > 0) {
                attributes.addFlashAttribute("message", "更新成功");
            } else {
                attributes.addFlashAttribute("errorMsg", "更新失败");
            }
        }

        return "redirect:/admin/tags";
    }

    /**
     * 删除标签
     */
    @GetMapping("/tag/del/{id}")
    public String tagDelete(@PathVariable("id")Integer id, RedirectAttributes attributes) {
        int res = tagService.deleteTag(id);

        if (res > 0) {
            attributes.addFlashAttribute("message", "删除成功");
        } else {
            attributes.addFlashAttribute("errorMsg", "删除失败");
        }

        return "redirect:/admin/tags";
    }
}