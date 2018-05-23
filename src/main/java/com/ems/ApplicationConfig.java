package com.ems;

import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.assertj.core.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.EmployeeTypeRepository;
import com.ems.dao.JobRepository;
import com.ems.dao.UserRepository;
import com.ems.entities.Employee;
import com.ems.entities.EmployeeLeave;
import com.ems.entities.Job;
import com.ems.entities.User;
import com.ems.service.EmployeeService;
import com.ems.service.RoleService;

@SpringBootApplication
@EnableJpaRepositories("com.ems.dao")
public class ApplicationConfig  extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	JobRepository jobRepository;
	
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

		Job job = new Job();
		job.setAdvisor("Rohan");
		job.setArrivalDate(new Date());
		job.setDelieveryDate(DateUtils.addDays(new Date(), 1));
		job.setMobileNumber("9039393939");
		job.setRegNo("MP09");
		job.setStatus("READY FOR DELIVERY");
		job.setTicketNo("TIC-101");
		job.setVehicleName("Toyota Corolla");
		job.setCustomerName("Shankar Reddy");
		job.setInsuranceName("IFCO TOKIO");
		
		jobRepository.save(job);
		
		
	}
	
}
