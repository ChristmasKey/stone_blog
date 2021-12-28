package com.djn.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ”关于我“信息管理
 * @author ChristmasKey
 * @date 2021-12-28-17:21
 */
@Controller
@RequestMapping("/admin")
public class AboutMeController {

    @GetMapping("/about_me")
    public String toTip() {
        return "admin/bs_tip";
    }
}