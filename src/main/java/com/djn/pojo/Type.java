package com.djn.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 博客分类
 * @author ChristmasKey
 * @date 2021-12-16-21:57
 */
@Data
@NoArgsConstructor
public class Type {

    private Integer id;//编号
    @NotBlank(message = "分类名称不能为空")
    private String name;//名称

    private Integer blogNum;//对应的博客数
    private List<Blog> blogs;//博客列表
}