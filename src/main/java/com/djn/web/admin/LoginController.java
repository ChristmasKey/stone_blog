package com.djn.web.admin;

import com.djn.pojo.User;
import com.djn.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 登录控制器
 * @author ChristmasKey
 * @date 2021-12-04-14:27
 */
@Controller
@RequestMapping("/admin")
public class LoginController {

    @Resource
    private UserService userService;

    /**
     * @return 跳转到后台登录页
     */
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    /**
     * 登录处理
     * @param username 用户名
     * @param password 密码
     * @param session 用户存储session
     * @param attributes 错误信息存储attribute
     * @return 后台首页/登录页
     */
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);

        if (user != null) { //用户存在
            user.setPassword(null);
            session.setAttribute("user", user);
            return "admin/index";
        } else { //用户不存在
            attributes.addFlashAttribute("message", "用户名或密码错误");
            return "redirect:/admin";
        }
    }


    /**
     * 注销
     * @param session 用户存储session
     * @return 登录页
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}