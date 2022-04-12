package com.snow.commodity.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.snow.commodity.entity.Product;
import com.snow.core.dto.demo.ProductDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {

    List<ProductDto> listProductByPage();
}
