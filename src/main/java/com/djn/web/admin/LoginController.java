package com.djn.web.admin;

import com.djn.pojo.User;
import com.djn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 后台登录
 * @author ChristmasKey
 * @date 2021-12-17-18:29
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private UserService userService;

    /**
     * 跳转到后台登录页面
     * @return
     */
    @GetMapping
    public String loginPage() {
        return "admin/bs_login";
    }

    /**
     * 登录处理
     * @param username 用户名
     * @param password 密码
     * @param session 存储用户的Session
     * @param attributes 存储message的重定向attribute
     * @return 后台首页/登录页
     */
    @PostMapping("/login")
    public String login(String username, String password, HttpSession session, RedirectAttributes attributes) {
        User user = userService.queryUserByNameAndPwd(username, password);

        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }
    }

    /**
     * 注销
     * @param session
     * @return
     */
    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes attributes) {
        session.removeAttribute("user");
        attributes.addFlashAttribute("message", "你已退出，请重新登录");
        return "redirect:/admin";
    }

    /**
     * 跳转到后台首页
     * @return
     */
    @GetMapping("/index")
    public String toIndexPage() {
        return "admin/bs_index";
    }
}