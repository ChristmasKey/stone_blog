package com.djn.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 博客标签
 * @author ChristmasKey
 * @date 2021-12-16-21:58
 */
@Data
@NoArgsConstructor
public class Tag {

    private Integer id;//编号
    @NotBlank(message = "标签名称不能为空")
    private String name;//名称

    private List<Blog> blogs;//博客列表
    private List<User> users;//用户列表
}