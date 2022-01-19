package com.djn.service;

import com.djn.dao.TypeDao;
import com.djn.pojo.Type;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 博客分类业务实现
 * @author ChristmasKey
 * @date 2021-12-21-1:02
 */
@Service
public class TypeServiceImpl implements TypeService{

    @Resource
    private TypeDao typeDao;

    @Override
    public List<Type> queryTopFourType() {
        return typeDao.queryTopFourType();
    }

    @Override
    public List<Type> queryTypes() {
        return typeDao.queryTypes();
    }

    @Override
    public PageInfo<Type> findAllTypesByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Type> types = typeDao.queryTypes();
        return new PageInfo<>(types);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.queryTypeByName(name);
    }

    @Override
    public Type getTypeById(Integer id) {
        return typeDao.queryTypeById(id);
    }

    @Override
    @Transactional
    public int addType(Type type) {
        return typeDao.addType(type);
    }

    @Override
    @Transactional
    public int updateType(Type type) {
        return typeDao.updateType(type);
    }

    @Override
    @Transactional
    public int deleteType(Integer id) {
        return typeDao.deleteTypeById(id);
    }
}