package com.codeshare.permission.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by zhaojun on 2018/7/2.
 **/
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SpringfoxConfig {

    @Bean
    public Docket petApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.codeshare.permission"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("ps-web API")
                .description("")
                .termsOfServiceUrl("http://localhost:8085")
                .version("1.0")
                .build();
    }
}
