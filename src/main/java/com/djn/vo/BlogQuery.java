package com.djn.vo;

/**
 * 博客查询条件
 * @author ChristmasKey
 * @date 2021-12-26-21:14
 */
public class BlogQuery {

    private Integer pageNum;
    private String title;
    private Integer typeId;
    private Boolean recommend;

    public BlogQuery() {
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "BlogQuery{" +
                "typeId=" + typeId +
                ", title='" + title + '\'' +
                ", recommend=" + recommend +
                ", pageNum=" + pageNum +
                '}';
    }
}