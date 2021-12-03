package com.djn.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 用户 实体类
 * @author ChristmasKey
 * @date 2021-12-03-14:17
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue
    private Long id; //编号
    private String nickName; //昵称
    private String username; //用户名
    private String password; //密码
    private String email; //邮箱
    private String avatar; //头像
    private Integer type; //用户类型
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime; //用户创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime; //用户修改时间

    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();
}