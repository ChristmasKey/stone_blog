package com.djn.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 博客 实体类
 * @author ChristmasKey
 * @date 2021-12-03-13:40
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "t_blog")
public class Blog {

    @Id
    @GeneratedValue
    private Long id; //编号
    private String title; //标题
    private String content; //内容
    private String firstPicture; //首图
    private String flag; //标记
    private Integer views; //浏览次数
    private boolean appreciation; //赞赏开启
    private boolean shareStatement; //版权开启
    private boolean commentabled; //评论开启
    private boolean published; //发布开启
    private boolean recommend; //是否推荐
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime; //创建时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime; //修改时间

    //***************设置实体类关系******************

    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST}) //设置Tag和Blog为级联新增
    private List<Tag> tags = new ArrayList<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();
}