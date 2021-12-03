package com.djn.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 标签 实体类
 * @author ChristmasKey
 * @date 2021-12-03-14:09
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "t_tag")
public class Tag {

    @Id
    @GeneratedValue
    private Long id; //编号
    private String name; //标签名

    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();
}