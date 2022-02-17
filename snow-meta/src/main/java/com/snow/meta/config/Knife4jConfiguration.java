package com.snow.meta.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @description knife4j 配置
 **/
@Configuration
public class Knife4jConfiguration {

    @Value("${swagger.enable:true}")
    private boolean enableSwagger;

    @Bean(value = "defaultApi2")
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfoBuilder()
                        .title("meta服务")
                        .version("1.0")
                        .build())
                .enable(enableSwagger)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.snow.meta.controller"))
                .paths(PathSelectors.any())
                .build();
    }

}
