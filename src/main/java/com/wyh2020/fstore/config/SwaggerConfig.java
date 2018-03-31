package com.wyh2020.fstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created with wyh.
 * Date: 2017/7/3
 * Time: 下午2:23
 */

@EnableSwagger2//启用Swagger2
@Configuration//让Spring来加载该类配置
public class SwaggerConfig {
    @Bean
    public Docket buildDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wyh2020.fstore.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title("SpringMVC中使用Swagger2构建RESTful APIs")
                .description("")
                .contact(new Contact("wyh2020", "https://wyh2020.com/", "wangyonghua@qianmi.com"))
                .version("1.0")
                .build();

    }
}
