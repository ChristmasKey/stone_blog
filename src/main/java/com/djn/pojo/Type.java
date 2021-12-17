package com.djn.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String name;//名称

    private List<Blog> blogs;//博客列表
}