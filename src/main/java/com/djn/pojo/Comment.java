package com.djn.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 评论 实体类
 * @author ChristmasKey
 * @date 2021-12-03-14:10
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue
    private Long id; //编号
    private String nickName; //昵称
    private String email; //邮箱
    private String content; //评论内容
    private String avatar; //头像
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime; //评论时间

    @ManyToOne
    private Blog blog;

    //设置评论的自关联关系
    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();

    @ManyToOne
    private Comment parentComment;

}