package com.codeshare.permission.config;

import com.codeshare.permission.common.Constants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojun on 2018/7/2.
 **/
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SpringfoxConfig {

    @Bean
    public Docket petApi() {

        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        tokenPar.name(Constants.TOKEN_HEADER)
                .description("令牌")
                .modelRef(new ModelRef("string"))
                .defaultValue("eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI5OTk5OTk5OTkiLCJzdWIiOiJ7XCJpZFwiOiA5OTk5OTk5OTksXCJ1c2VySWRcIjogOTk5OTk5OTk5LFwibmFtZVwiOiBcIuW8gOWPkeS6uuWRmOa1i-ivlei0puWPt1wiIH0iLCJpYXQiOjE1Mjk0ODk2NTUsImp0aSI6Ijk5OTk5OTk5OSJ9.ktDwazqyHuk-gjnPuvV5i68S7xc2FVpL68kAAdijeUQ")
                .parameterType("header")
                .required(false)
                .build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.codeshare.permission"))
                .build()
                .globalOperationParameters(pars);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("ps-web API")
                .description("")
                .termsOfServiceUrl("http://localhost:8085")
                .version("1.0")
                .build();
    }
}
