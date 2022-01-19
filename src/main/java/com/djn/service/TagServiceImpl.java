package com.djn.service;

import com.djn.dao.TagDao;
import com.djn.pojo.Tag;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客标签业务实现
 * @author ChristmasKey
 * @date 2021-12-24-17:51
 */
@Service
public class TagServiceImpl implements TagService{

    @Resource
    private TagDao tagDao;

    @Override
    public List<Tag> queryTopFourTag() {
        return tagDao.queryTopFourTag();
    }

    @Override
    public List<Tag> queryTags() {
        return tagDao.queryTags();
    }

    @Override
    public PageInfo<Tag> findAllTagsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Tag> tags = tagDao.queryTags();
        return new PageInfo<>(tags);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagDao.queryTagByName(name);
    }

    @Override
    public Tag getTagById(Integer id) {
        return tagDao.queryTagById(id);
    }

    @Override
    public List<Integer> getTagIdsByBlogId(Integer blogId) {
        return tagDao.queryTagIdWithBlog(blogId);
    }

    @Override
    @Transactional
    public int addTag(Tag tag) {
        return tagDao.addTag(tag);
    }

    @Override
    @Transactional
    public int updateTag(Tag tag) {
        return tagDao.updateTag(tag);
    }

    @Override
    @Transactional
    public int deleteTag(Integer id) {
        return tagDao.deleteTagById(id);
    }
}