package com.ty.springBoot_foodApp.Config;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("Infosys", "www.infosys.com", "infosys@gmail.com");
		List<VendorExtension> extensions = new ArrayList<>();
		ApiInfo apiInfo = new ApiInfo("FoodApp", "foodapp for inhouse order", "1.01", "1 year of free service", contact,
				"www.infosys.com", "www.infosys.com", extensions);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.springBoot_foodApp")).build().apiInfo(apiInfo)
				.useDefaultResponseMessages(false);
	}

}
