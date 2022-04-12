package com.snow.commodity.service;

import com.snow.core.dto.demo.ProductDto;
import com.snow.core.dto.demo.ProductParam;

import java.util.List;

public interface ProductService {

    ProductDto findProductById(Integer productId);

    Integer add(ProductParam productParam);

    Integer update(ProductParam productParam);

    Integer delete(Long ProductId);

    List<ProductDto> listProduct();

    List<ProductDto> pageListProduct(Integer pageSize, Integer pageNum);

}
