package com.snow.commodity.controller;

import com.snow.commodity.service.ProductService;
import com.snow.core.dto.demo.ProductDto;
import com.snow.core.dto.demo.ProductParam;
import com.snow.mybatis.CommonResult;
import com.snow.page.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "商品API")
@RestController
@RequestMapping(value = "product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("根据商品ID获取商品信息")
    @GetMapping(value = "findProductById")
    public CommonResult<ProductDto> findProductById(@RequestParam(value = "productId") Integer productId) {
        return CommonResult.success(productService.findProductById(productId));
    }

    @ApiOperation("新增商品")
    @PostMapping(value = "add")
    public CommonResult<Integer> add(@RequestBody ProductParam productParam) {
        return CommonResult.success(productService.add(productParam));
    }

    @ApiOperation("修改商品")
    @PostMapping(value = "update")
    public CommonResult<Integer> update(@RequestBody ProductParam productParam) {
        return CommonResult.success(productService.update(productParam));
    }

    @ApiOperation("删除商品")
    @PostMapping(value = "delete")
    public CommonResult<Integer> delete(@RequestParam(value = "productId") Long productId) {
        return CommonResult.success(productService.delete(productId));
    }

    @ApiOperation("商品列表")
    @GetMapping(value = "listProduct")
    public CommonResult<List<ProductDto>> listProduct() {
        return CommonResult.success(productService.listProduct());
    }

    @ApiOperation("分页商品列表")
    @PostMapping(value = "pageListProduct")
    public CommonResult<CommonPage<ProductDto>> pageListProduct(
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<ProductDto> ProductList = productService.pageListProduct(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(ProductList));
    }


}
