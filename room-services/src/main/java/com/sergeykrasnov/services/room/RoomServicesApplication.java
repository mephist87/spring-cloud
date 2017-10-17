package com.sergeykrasnov.services.room;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.any;

@SpringBootApplication
@EnableSwagger2
public class RoomServicesApplication {

	@Bean
	public Docket api(){
		return new Docket(DocumentationType.SWAGGER_2).groupName("Room").select()
				.apis(RequestHandlerSelectors.basePackage("com.sergeykrasnov.services.room"))
				.paths(any()).build().apiInfo(new ApiInfo("Room Services",
						"A set of services to provide data access to rooms", "1.0.0", null,
						new Contact("Sergey Krasnov", "https://github.com/mephist87/", null),
						null, null, new ArrayList<>()));
	}


	public static void main(String[] args) {
		SpringApplication.run(RoomServicesApplication.class, args);
	}
}
