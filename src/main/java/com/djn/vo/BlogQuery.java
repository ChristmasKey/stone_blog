package com.djn.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 博客查询条件
 * @author ChristmasKey
 * @date 2021-12-26-21:14
 */
@Data
@NoArgsConstructor
public class BlogQuery {

    private Integer pageNum;
    private String title;
    private Integer typeId;
    private Boolean recommend;
}