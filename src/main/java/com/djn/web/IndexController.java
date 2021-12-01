package com.djn.web;

import com.djn.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author ChristmasKey
 * @date 2021-12-01-13:42
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String toIndex() {
        // int i = 10 / 0;

        String blog = null;
        if (blog == null) {
            throw new NotFoundException("博客不存在");
        }
        return "index";
    }
}