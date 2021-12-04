package com.djn.web.admin;

import com.djn.pojo.Type;
import com.djn.service.TypeService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

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
    public String list(@PageableDefault(size = 10, sort = {"id"}, direction = Sort.Direction.DESC) Pageable pageable,
                       Model model) {
        model.addAttribute("page", typeService.listType(pageable));
        return "admin/types";
    }

    @GetMapping("/types/input")
    public String input() {
        return "admin/addType";
    }

    @PostMapping("/types")
    public String post(Type type) {
        Type t = typeService.saveType(type);

        if (t == null) {
        } else {
        }
        return "redirect:/admin/types";
    }
}