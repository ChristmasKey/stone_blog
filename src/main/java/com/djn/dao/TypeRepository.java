package com.djn.dao;

import com.djn.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 分类持久层
 * @author ChristmasKey
 * @date 2021-12-04-22:54
 */
public interface TypeRepository extends JpaRepository<Type, Long> {

    /**
     * 根据name查询分类
     * @param name 分类名称
     * @return 分类对象
     */
    Type findByName(String name);
}