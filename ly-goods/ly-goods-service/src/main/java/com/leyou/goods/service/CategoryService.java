package com.leyou.goods.service;


import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.goods.mapper.CategoryMapper;
import com.leyou.goods.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    public List<Category> queryCategoryListByPid(Long pid){
        Category category = new Category();
        category.setParentId(pid);
        List<Category> categoryList = categoryMapper.select(category);
        if (categoryList == null || categoryList.isEmpty()){
            throw new LyException(ExceptionEnum.CATEGORY_LIST_IS_EMPTY);
        }
        return categoryList;
    }

}
