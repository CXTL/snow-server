package com.snow.commodity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.github.pagehelper.PageHelper;
import com.snow.commodity.entity.Product;
import com.snow.commodity.mapper.ProductMapper;
import com.snow.commodity.service.ProductService;
import com.snow.core.dto.demo.ProductDto;
import com.snow.core.dto.demo.ProductParam;
import com.snow.core.exception.Asserts;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;


    /**
     * 新增商品
     *
     * @param productParam
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer add(ProductParam productParam) {
        Product product = Product.builder().build();
        BeanUtils.copyProperties(productParam, product);
        checkProductNameUnique(product);
        product.setCreateTime(LocalDateTime.now());
        product.setUpdateTime(product.getCreateTime());
        return productMapper.insert(product);
    }

    /**
     * 修改商品
     *
     * @param productParam
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update(ProductParam productParam) {
        getProductById(productParam.getId());
        Product product = Product.builder().build();
        BeanUtils.copyProperties(productParam, product);
        checkProductNameUnique(product);
        product.setUpdateTime(LocalDateTime.now());
        return productMapper.updateById(product);
    }


    /**
     * 删除商品
     *
     * @param ProductId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer delete(Long ProductId) {
        return productMapper.deleteById(ProductId);
    }

    /**
     * 根据ID查询商品信息
     *
     * @param productId
     * @return
     */
    @Override
    public ProductDto findProductById(Integer productId) {
        Product product = getProductById(productId);
        ProductDto productDto = ProductDto.builder().build();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }

    /**
     * 商品信息列表
     *
     * @return
     */
    @Override
    public List<ProductDto> listProduct() {
        List<Product> products = productMapper.selectList(new LambdaQueryWrapper<>());
        return products.stream().map(a -> {
            ProductDto productDto = ProductDto.builder().build();
            BeanUtils.copyProperties(a, productDto);
            return productDto;
        }).collect(Collectors.toList());
    }

    /**
     * 分页查询商品信息
     *
     * @param pageSize
     * @param pageNum
     * @return
     */
    @Override
    public List<ProductDto> pageListProduct(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return productMapper.listProductByPage();
    }

    /**
     * 检查商品名称重复
     *
     * @param productInfo
     */
    private void checkProductNameUnique(Product productInfo) {
        Product product = productMapper.selectOne(
                new LambdaQueryWrapper<Product>()
                        .eq(Product::getName, productInfo.getName()));
        if (Objects.nonNull(product)) {
            Asserts.fail("商品名称重复");
        }
    }

    /**
     * 获取商品信息
     *
     * @param productId
     * @return
     */
    private Product getProductById(Integer productId) {
        Product product = productMapper.selectById(productId);
        if (Objects.isNull(product)) {
            Asserts.fail("商品信息不存在");
        }
        return product;
    }


}
