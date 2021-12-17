package com.djn.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 博客评论
 * @author ChristmasKey
 * @date 2021-12-16-21:58
 */
@Data
@NoArgsConstructor
public class Comment {

    private Integer id;//编号
    private String nickname;//昵称
    private String email;//邮箱
    private String content;//评论内容
    private String avatar;//头像
    private Date createTime;//评论时间

    private Integer parentComment;//父评论
    private Blog blog;//所属博客
    private List<Comment> replyComments;//子评论
}