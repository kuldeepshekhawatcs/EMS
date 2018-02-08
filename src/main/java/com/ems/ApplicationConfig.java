package com.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ApplicationConfig  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ApplicationConfig.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(ApplicationConfig.class);
	}
}
