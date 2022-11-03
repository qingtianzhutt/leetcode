package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2) //创建docket的bean
//                .apiInfo(apiInfo());           //创建该api的基本信息
//    }
//
//    private ApiInfo apiInfo() {
//        Contact contact = new Contact("123","12312","123123");
//        return new ApiInfoBuilder()
//                .title("Spring Boot中使用Swagger2构建RESTful APIs")
//                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
//                .version("1.0")
//                .termsOfServiceUrl("http://blog.didispace.com/")
//                .contact(contact)
//                .license("Apache 2.0")
//                .licenseUrl("123123123")
//                .build();
//    }

}
