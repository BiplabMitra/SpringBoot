/*
 * -------------------------------------------------------------------------
 
 * PROPRIETARY INFORMATION.  Not for use or disclosure outside Change
 
 * Healthcare,  and its affiliates except under written agreement.
 
 * This is an unpublished, proprietary work of Change Healthcare,
 
 * that is protected by United States copyright laws.  Disclosure,
 
 * copying, reproduction, merger, translation, modification, enhancement,
 
 * or use by anyone other than authorized employees or licensees of
 
 * Change Healthcare, Inc. without the prior written consent of
 
 * Change Healthcare, Inc. is prohibited.
 
 * Copyright (c) 2016 Change Healthcare, Inc.  All rights reserved.
 
 * -------------------------------------------------------------------------
 
 */
package com.changehealthcare.swagger.config;

import com.google.common.base.Predicates;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@ComponentScan("com.changehealthcare.controller")
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                        .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(apiInfo());
    }
    

    private ApiInfo apiInfo() {
        String description = "swagger example";
        return new ApiInfoBuilder()
                .title("swagger example")
                .description(description)
                .termsOfServiceUrl("github")
                .license("SBP")
                .licenseUrl("")
                .version("1.0")
 //               .contact(new Contact("siamak"))
                .build();
    }

}