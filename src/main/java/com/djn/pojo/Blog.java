package com.djn.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * 博客
 * @author ChristmasKey
 * @date 2021-12-16-21:58
 */
@Data
@NoArgsConstructor
public class Blog {

    private Integer id;//编号
    private String title;//博客标题
    private String content;//博客内容
    private String firstImg;//博客首图
    private String flag;//博客标记
    private Integer views;//浏览量
    private boolean appreciation;//赞赏开启
    private boolean shareStatement;//转载开启
    private boolean commentable;//评论开启
    private boolean published;//博客状态：true(发布),false(草稿)
    private boolean recommend;//推荐开启
    private Date createTime;//发布时间
    private Date updateTime;//更新时间

    private Type type;//博客分类
    private User user;//作者
    private List<Tag> tags;//博客标签
    private List<Comment> comments;//博客评论
}