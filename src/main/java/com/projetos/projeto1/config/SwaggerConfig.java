package com.projetos.projeto1.config;

import java.util.ArrayList;


import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	
	@Bean
	public Docket produtoApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.projetos.projeto1"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(metaInfo());
				
	}



	@SuppressWarnings("rawtypes")
	private ApiInfo metaInfo() {

		ApiInfo apiInfo = new ApiInfo(
				"Projeto 1 : API Rest (Produtos)",
				"Cadastrar Produtos - Com API Rests",
				"1.0",
				"Terms of Service",
				new Contact("Tarcisio Moreira da Silva", "www.tamosilva.com.br", "tarcisioms23@hotmail.com"),
				"Apache License Version 2.0",
				"https://www.apache.org/licesen.html", 
				new ArrayList<VendorExtension>()
				);
		
		return apiInfo;
	} 

		
}
