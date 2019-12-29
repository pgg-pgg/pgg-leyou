package com.leyou.goods.web;

import com.leyou.common.vo.PageResult;
import com.leyou.goods.pojo.Brand;
import com.leyou.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 分页查询品牌
     *
     * @param searchKey 搜索过滤条件
     * @param page      当前页
     * @param rows      一页几条数据
     * @param sortBy    排序字段
     * @param desc      是否降序
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandListByPage(
            @RequestParam(value = "key", required = false) String searchKey,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "desc", defaultValue = "false") Boolean desc) {

        return ResponseEntity.ok(brandService.queryBrandListByPage(searchKey, page, rows, sortBy, desc));
    }

}
