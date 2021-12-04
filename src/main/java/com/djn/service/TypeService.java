package com.djn.service;

import com.djn.pojo.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 分类管理业务
 * @author ChristmasKey
 * @date 2021-12-04-22:47
 */
public interface TypeService {

    /**
     * 新增分类
     * @param type 分类对象
     * @return 分类对象
     */
    Type saveType(Type type);

    /**
     * 根据id查询分类
     * @param id 分类编号
     * @return 分类对象
     */
    Type getType(Long id);

    /**
     * 分页查询 分类
     * @param pageable 分页参数
     * @return 分类的分页
     */
    Page<Type> listType(Pageable pageable);

    /**
     * 更新分类
     * @param id 编号
     * @param type 分类对象
     * @return 分类对象
     */
    Type updateType(Long id, Type type);

    /**
     * 根据id删除分类
     * @param id 分类id
     */
    void deleteType(Long id);
}