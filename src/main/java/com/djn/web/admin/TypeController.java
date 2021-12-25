package com.djn.web.admin;

import com.djn.pojo.Type;
import com.djn.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 博客分类管理
 * @author ChristmasKey
 * @date 2021-12-21-0:16
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Resource
    private TypeService typeService;

    /**
     * 分页显示博客分类列表
     */
    @GetMapping("/types")
    public String toTypeList(@RequestParam(defaultValue = "1", name = "pageNum")Integer pageNum, Model model) {
        PageInfo<Type> typesPage = typeService.findAllTypesByPage(pageNum, 5);
        model.addAttribute("typesPage", typesPage);
        return "admin/bs_type_list";
    }

    /**
     * 跳转到新增分类页面
     */
    @GetMapping("/type")
    public String toTypeAdd(Model model) {
        model.addAttribute("type", new Type());
        return "admin/bs_type_add";
    }

    /**
     * 跳转到修改分类页面
     */
    @GetMapping("/type/{id}")
    public String toTypeEdit(@PathVariable("id")Integer id, Model model) {
        model.addAttribute("type", typeService.getTypeById(id));
        return "admin/bs_type_add";
    }

    /**
     * 新增/更新分类
     */
    @PostMapping("/type")
    public String typeInput(@Valid Type type, BindingResult result, RedirectAttributes attributes) {
        //分类已存在校验
        Type existType = typeService.getTypeByName(type.getName());

        if (existType != null) {
            result.rejectValue("name", "nameError", "不能添加重复的分类");
        }

        if (result.hasErrors()) {
            return "admin/bs_type_add";
        }

        if (type.getId() == null) {//新增
            int res = typeService.addType(type);

            if (res > 0) {
                attributes.addFlashAttribute("message", "添加成功");
            } else {
                attributes.addFlashAttribute("errorMsg", "添加失败");
            }
        } else {//更新
            int res = typeService.updateType(type);

            if (res > 0) {
                attributes.addFlashAttribute("message", "更新成功");
            } else {
                attributes.addFlashAttribute("errorMsg", "更新失败");
            }
        }

        return "redirect:/admin/types";
    }

    /**
     * 删除分类
     */
    @GetMapping("/type/del/{id}")
    public String typeDelete(@PathVariable("id")Integer id, RedirectAttributes attributes) {
        int res = typeService.deleteType(id);

        if (res > 0) {
            attributes.addFlashAttribute("message", "删除成功");
        } else {
            attributes.addFlashAttribute("errorMsg", "删除失败");
        }

        return "redirect:/admin/types";
    }
}