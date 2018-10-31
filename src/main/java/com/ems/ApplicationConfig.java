package com.ems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.JobRepository;
import com.ems.service.VehicleService;

@SpringBootApplication
@EnableJpaRepositories("com.ems.dao")
@EnableCaching
public class ApplicationConfig  extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	JobRepository jobRepository;
	
	@Autowired
	VehicleService vehicleService;
	
	public static void main(String[] args) {
		SpringApplication.run(ApplicationConfig.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(ApplicationConfig.class);
	}
	
	@Transactional
    @Override
    public void run(String... args) throws Exception {
		
		
	}
	
}
