package com.djn.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 后台用户
 * @author ChristmasKey
 * @date 2021-12-16-21:20
 */
@Data
@NoArgsConstructor
public class User {

    private Integer id;//编号
    private String username;//用户名
    private String password;//密码
    private String nickname;//昵称
    private String email;//邮箱
    private String avatar;//头像
    private Integer type;//用户类型：0(root),1(admin),2(publisher)
    private Date createTime;//创建时间
    private Date updateTime;//修改时间
    private String introduce;//自我介绍
    //四个兴趣爱好
    private String hobby1;
    private String hobby2;
    private String hobby3;
    private String hobby4;
    private String personalTags;//个人标签

    private List<Blog> blogs;//博客列表
    private List<Tag> tags;//标签列表
}