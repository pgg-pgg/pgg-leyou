package com.leyou.goods.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.goods.mapper.BrandMapper;
import com.leyou.goods.pojo.Brand;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

import static com.leyou.common.enums.ExceptionEnum.BRANDS_NOT_FIND;

@Service
public class BrandService {

    @Autowired
    private BrandMapper brandMapper;


    public PageResult<Brand> queryBrandListByPage(String searchKey, Integer page, Integer rows, String sortBy, Boolean desc) {
        //分页(分页助手实现）
        PageHelper.startPage(page, rows);
        //过滤
        Example example = new Example(Brand.class);

        if (StringUtils.isNotBlank(searchKey)) {
            example.createCriteria().orLike("name", "%s" + searchKey + "%s")
                    .orEqualTo("letter", searchKey.toUpperCase());
        }
        //排序
        if (StringUtils.isNotBlank(sortBy)) {
            String orderByClause = sortBy + " " + (desc ? "DESC" : "ASC");
            example.setOrderByClause(orderByClause);
        }
        //查询
        List<Brand> brands = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(brands)) {
            throw new LyException(BRANDS_NOT_FIND);
        }

        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);

        return new PageResult<>(brandPageInfo.getTotal(), brands);
    }
}
