package com.dsunsoft.core.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SwaggerConfig
 * 
 * @author yangm  <br/>
 * http://localhost:8080/api/swagger-ui.html <br/>
 * 
 * 1.获取授权码 http://localhost:8081/api/oauth/token <br/>
 *  headers参数 ： <br/>
 *   Content-Type:application/x-www-form-urlencoded <br/>
 *   Authorization:Basic ZHN1bnNvZnQ6ZHN1bnNvZnQ= <br/>
 *  Body参数: <br/>
 *   username:admin <br/>
 *   password:admin <br/>
 *   grant_type:password <br/>
 *   
 * 2.授权时加上 Bearer+空格+token <br/>
 */
@Configuration
@EnableSwagger2
@Profile({ "dev", "test" })
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				// 使用注解显示
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any())
				.build().securitySchemes(securitySchemes()).securityContexts(securityContexts());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				// 页面标题
				.title("video-ai api docs")
				// 版本号
				.version("1.0")
				// 描述
				.description("video-ai 接口文档").build();
	}

	private List<ApiKey> securitySchemes() {
		List<ApiKey> list = new ArrayList<>();
		list.add(new ApiKey("Authorization", "Authorization", "header"));
		return list;
	}

	/**
	 * 所有包含”auth”的接口不需要使用securitySchemes
	 * 
	 * @return
	 */
	private List<SecurityContext> securityContexts() {
		List<SecurityContext> list = new ArrayList<>();
		list.add(SecurityContext.builder().securityReferences(defaultAuth())
				.forPaths(PathSelectors.regex("^(?!auth).*$")).build());
		return list;
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		List<SecurityReference> list = new ArrayList<>();
		list.add(new SecurityReference("Authorization", authorizationScopes));
		return list;
	}
}
