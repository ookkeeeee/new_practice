package com.InventoryFriends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.InventoryFriends"})
@EnableSwagger2
public class InventoryFriendsApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(InventoryFriendsApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InventoryFriendsApplication.class);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.OAS_30)
					.apiInfo(apiInfo())
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.InventoryFriends.controller"))
					.paths(PathSelectors.any())
					.build(); 
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("InventoryFriends REST API").version("1.0.0").build();
	}
}
