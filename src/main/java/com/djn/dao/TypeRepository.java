package com.djn.dao;

import com.djn.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 分类持久层
 * @author ChristmasKey
 * @date 2021-12-04-22:54
 */
public interface TypeRepository extends JpaRepository<Type, Long> {
}