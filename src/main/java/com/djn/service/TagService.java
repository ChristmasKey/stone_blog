package com.djn.service;

import com.djn.pojo.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 标签管理业务
 * @author ChristmasKey
 * @date 2021-12-15-15:25
 */
public interface TagService {

    /**
     * 查询所有标签
     * @return 标签list
     */
    List<Tag> listTag();

    /**
     * 新增标签
     * @param tag 标签对象
     * @return 标签对象
     */
    Tag saveTag(Tag tag);

    /**
     * 根据id查询标签
     * @param id 标签编号
     * @return 标签对象
     */
    Tag getTag(Long id);

    /**
     * 分页查询 标签
     * @param pageable 分页参数
     * @return 标签的分页
     */
    Page<Tag> listTag(Pageable pageable);

    /**
     * 更新标签
     * @param id 编号
     * @param tag 标签对象
     * @return 标签对象
     */
    Tag updateTag(Long id, Tag tag);

    /**
     * 根据id删除标签
     * @param id 标签id
     */
    void deleteTag(Long id);

    /**
     * 根据name查询标签
     * @param name 标签名称
     * @return 标签对象
     */
    Tag getTagByName(String name);
}