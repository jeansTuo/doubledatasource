package com.my;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zengwen
 * @version 1.0
 * @File name: SwaggerConfig
 * @Description:
 * @date 2019/03/13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${spring.mvc.servlet.path}")
    private String pathMapping;

    private ApiInfo initApiInfo() {

        ApiInfo apiInfo = new ApiInfo(
                //大标题
                "XXX项目 Platform API",
                //简单的描述
                initContextInfo(),
                //版本
                "1.0.0",
                "服务条款",
                //作者
                "后台开发团队",
                //链接显示文字
                "The Apache License, Version 2.0",
                //网站链接
                "http://www.baidu.com"
        );

        return apiInfo;
    }

    private String initContextInfo() {
        StringBuffer sb = new StringBuffer();
        sb.append("REST API 设计在细节上有很多自己独特的需要注意的技巧，并且对开发人员在构架设计能力上比传统 API 有着更高的要求。")
                .append("<br/>")
                .append("本文通过翔实的叙述和一系列的范例，从整体结构，到局部细节，分析和解读了为了提高易用性和高效性，REST API 设计应该注意哪些问题以及如何解决这些问题。");

        return sb.toString();
    }

    @Bean
    public Docket restfulApi() {
        System.out.println("http://localhost:8080" + pathMapping + "/swagger-ui.html");

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("RestfulApi")
//                .genericModelSubstitutes(DeferredResult.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .useDefaultResponseMessages(true)
                .forCodeGeneration(false)
                // base，最终调用接口后会和paths拼接在一起
                .pathMapping(pathMapping)
                .select()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(initApiInfo());
    }


}
