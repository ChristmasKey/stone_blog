package com.djn.dao;

import com.djn.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 标签持久层
 * @author ChristmasKey
 * @date 2021-12-15-15:23
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

    /**
     * 根据name查询标签
     * @param name 标签名称
     * @return 标签对象
     */
    Tag findByName(String name);
}