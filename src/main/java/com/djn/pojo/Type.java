package com.djn.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 分类 实体类
 * @author ChristmasKey
 * @date 2021-12-03-14:07
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "t_type")
public class Type {

    @Id
    @GeneratedValue
    private Long id; //编号
    private String name; //分类名

    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();
}