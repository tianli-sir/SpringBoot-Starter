package com.tianlisir.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * Swagger配置
 *
 * @author Another
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {


    /**
     * 设置多个：
     *
     * @Bean
     *     public Docket appApi() {
     *
     *         List<Parameter> pars = new ArrayList<>();
     *         ParameterBuilder token = new ParameterBuilder();
     *         token.name("token").description("用户令牌").modelRef(new ModelRef("string")).parameterType("header").required(false)
     *                 .build();
     *         pars.add(token.build());
     *
     *         return new Docket(DocumentationType.SWAGGER_2).select().paths(regex("/app/.*")).build()
     *                 .globalOperationParameters(pars).apiInfo(pdaApiInfo()).useDefaultResponseMessages(false)
     *                 .enable(enableSwagger)
     *                 .groupName("appApi");
     *
     *     }
     *
     *     @Bean
     *     public Docket adminApi() {
     *
     *         List<Parameter> pars = new ArrayList<>();
     *         ParameterBuilder token = new ParameterBuilder();
     *         token.name("token").description("用户令牌").modelRef(new ModelRef("string")).parameterType("header").required(false)
     *                 .build();
     *         pars.add(token.build());
     *         return new Docket(DocumentationType.SWAGGER_2).select().paths(regex("/admin/.*")).build()
     *                 .globalOperationParameters(pars).apiInfo(pdaApiInfo()).useDefaultResponseMessages(false)
     *                 .enable(enableSwagger)
     *                 .groupName("adminApi");
     *
     *     }
     *
     *
     * @return
     */
    //swagger2.x
//    @Bean
//    public Docket createRestApi() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
//                .apis(RequestHandlerSelectors.basePackage("com.tianlisir.controller")).paths(PathSelectors.any())
//                .build().globalOperationParameters(setHeaderToken());
//
//    }

    //swagger3.x
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.tianlisir.controller")).paths(PathSelectors.any())
                .build().globalRequestParameters(setHeaderToken());

//                .globalOperationParameters(setHeaderToken());

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Another-swagger-API").description("开发文档").termsOfServiceUrl("")
                .version("1.0").build();
    }

    /**
     * @Description: 设置swagger文档中全局参数
     * @param
     * @Date: 2020/9/11 10:15
     * @return: java.util.List<springfox.documentation.service.Parameter>
     */

    private List<RequestParameter> setHeaderToken() {
        List<RequestParameter> pars = new ArrayList<>();
        RequestParameterBuilder userId = new RequestParameterBuilder();
//        userId.name("token").description("用户TOKEN").modelRef(new ModelRef("string")).parameterType("header")
        userId.name("token").description("用户TOKEN").in(ParameterType.HEADER).query(q->q.model(m->m.scalarModel(ScalarType.STRING))).required(false).build();
        pars.add(userId.build());
        return pars;
    }


    /**
     *         List<RequestParameter> pars = new ArrayList<>();
     *         RequestParameterBuilder userId = new RequestParameterBuilder();
     *         userId.name("token").description("用户TOKEN").contentModel(new ModelSpecification("String")).parameterType("header")
     *                 .required(true).build();
     *         pars.add(userId.build());
     *         return pars;
     */
}
