package com.ems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

import com.ems.dao.EmployeeTypeRepository;
import com.ems.dao.UserRepository;
import com.ems.entities.Employee;
import com.ems.entities.EmployeeLeave;
import com.ems.entities.User;
import com.ems.service.EmployeeService;
import com.ems.service.RoleService;

@SpringBootApplication
@EnableJpaRepositories("com.ems.dao")
public class ApplicationConfig  extends SpringBootServletInitializer implements CommandLineRunner {

	@Autowired
	EmployeeService employeeService;
	
	/*
	@Autowired
	private EmployeeTypeService employeeTypeService;  */
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	EmployeeTypeRepository empTypeRepo;
	
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
/*
		Employee emp = new Employee();
		emp.setAddress("ram nagar");
		emp.setBankAccountNumber(1000000001);
		emp.setBankName("BOI");
		emp.setBranchName("saket");
		emp.setCountry("INDIA");
		emp.setDateOfBirth(new Date());
		emp.setDateOfJoining(new Date());
		emp.setEmail("");
		EmployeeType type = new EmployeeType();
		type.setEmployeeTypeCode("");
		type.setEmployeeTypeDescription("Manager");
		type.setEmployeeTypeId(101);
		type.setLeavesGrantedPerYear(20);
		Role role = new Role();
		role.setRoleName("MANAGER");
		Set<String> s = new HashSet<>();
		s.add("EMPLOYEE_UPDATE");
		role.setRolePermission(s);
	
		emp.setEmployeeType(type);
		emp.setFirstName("first");
		emp.setIfscCode("adfadfadf");
		emp.setLastName("john");
		emp.setLeaveBalance(4);
		emp.setMiddleName("ddd");
		emp.setPassword("ram");
		emp.setPhoneNumber("999999999");
		emp.setSalary(5000);
		type.setRole(role);
		employeeService.insert(emp);
		System.out.println("***************"+employeeService.findAll().get(0).getEmployeeType().getRole().getRoleName());*/
		
		/*EmployeeType type = new EmployeeType();
		type.setEmployeeTypeCode("AA");
		type.setEmployeeTypeDescription("PERMANENT");
		type.setLeavesGrantedPerYear(50);
		Role role = new Role();
		role.setRoleName("USER");
		role.setRolePermission(null);
	//	type.setRole(role);
		employeeTypeService.insert(type);*/
		
		/*User user = new User();
		user.setUserName("admin");
		user.setPassword("admin");
		userRepo.save(user);*/
		/*System.out.println("CREATED");
		Employee emp = new Employee();
		emp.setRole(roleService.findById(1));
		emp.setEmployeeType(empTypeRepo.findOne(1));
		emp.setUser(userRepo.findAll().get(0));
		employeeService.insert(emp);*/
	}
	
}
