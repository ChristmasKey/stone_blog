package com.djn.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台登录
 * @author ChristmasKey
 * @date 2021-12-17-18:29
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @GetMapping
    public String loginPage() {
        return "admin/bs_login";
    }
}