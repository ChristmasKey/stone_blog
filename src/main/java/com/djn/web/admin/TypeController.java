package com.djn.web.admin;

import com.djn.pojo.Type;
import com.djn.service.TypeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 分类控制器
 * @author ChristmasKey
 * @date 2021-12-04-23:10
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Resource
    private TypeService typeService;

    @GetMapping("/types")
    public String list(@PageableDefault(size = 3, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                       Model model) {
        model.addAttribute("page", typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input(Model model) {
        model.addAttribute("type", new Type());
        return "admin/addType";
    }

    @GetMapping("/types/{id}/input")
    public String editType(@PathVariable Long id, Model model) {
        model.addAttribute("type", typeService.getType(id));
        return "admin/addType";
    }

    @PostMapping("/types")
    public String post(@Valid Type type, BindingResult result, RedirectAttributes attributes) {

        //业务校验：分类是否已存在
        Type existType = typeService.getTypeByName(type.getName());

        if (existType != null) { //分类已存在
            result.rejectValue("name", "nameError", "不能添加重复的分类");
        }

        if (result.hasErrors()) {
            return "admin/addType";
        }

        Type t = typeService.saveType(type);

        if (t == null) {
            attributes.addFlashAttribute("message", "添加失败");
        } else {
            attributes.addFlashAttribute("message", "添加成功");
        }
        return "redirect:/admin/types";
    }

    @PostMapping("/types/{id}")
    public String editPost(@Valid Type type, BindingResult result, @PathVariable Long id, RedirectAttributes attributes) {
        Type existType = typeService.getTypeByName(type.getName());
        if (existType != null) {
            result.rejectValue("name", "nameError", "不能添加重复的分类");
        }

        if (result.hasErrors()) {
            return "admin/addType";
        }

        Type t = typeService.updateType(id, type);
        if (t == null) {
            attributes.addFlashAttribute("message", "更新失败");
        } else {
            attributes.addFlashAttribute("message", "更新成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }
}