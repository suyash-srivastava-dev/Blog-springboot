package com.suyash.deubank;

import com.suyash.deubank.pojo.Blog;
import com.suyash.deubank.pojo.Employee;
import com.suyash.deubank.pojo.Role;
import com.suyash.deubank.services.BlogServiceImpl;
import com.suyash.deubank.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@SpringBootApplication
public class DeubankApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeubankApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(EmployeeService employeeService, BlogServiceImpl blogService){
		return args -> {
			Employee e1=new Employee(null,"suyash","suyash@gmail.com","password123",new ArrayList<>(),"School","ABPS");
			Employee e2=new Employee(null,"srijan","srijan@gmail.com","passwordSrijan",new ArrayList<>(),"School","ABPS");
			Employee e3=new Employee(null,"maya","maya@gmail.com","passwordMaya",new ArrayList<>(),"School","ABPS");
			employeeService.saveEmployee(e1);
			employeeService.saveEmployee(e2);
			employeeService.saveEmployee(e3);

			Role r1=new Role(null,"Admin");
			Role r2=new Role(null,"SuperAdmin");
			Role r3=new Role(null,"Reader");

			employeeService.saveRole(r1);
			employeeService.saveRole(r2);
			employeeService.saveRole(r3);

			employeeService.addRoleToEmployee(e1.getName(),r1.getName());
			employeeService.addRoleToEmployee(e2.getName(),r2.getName());
			employeeService.addRoleToEmployee(e2.getName(),r1.getName());
			employeeService.addRoleToEmployee(e3.getName(),r3.getName());

//			Blog blog=new Blog(null,"First Blog","This is my first blog",null,"suyash","published");
//			Blog blog1=new Blog(null,"Second Blog","This is my Second blog",null,"srijan","published");
//			Blog blog2=new Blog(null,"Third Blog","This is my Third blog",null,"maya","published");
//			Blog blog3=new Blog(null,"fourth Blog","This is my fourth blog",null,"suyash","pending");
//			Blog blog4=new Blog(null,"fifth Blog","This is my fifth blog",null,"srijan","pending");

			Blog blog= new Blog("First Blog","This is my first blog",null,"suyash","published");
			Blog blog1=new Blog("Second Blog","This is my Second blog",null,"srijan","published");
			Blog blog2=new Blog("Third Blog","This is my Third blog",null,"maya","published");
			Blog blog3=new Blog("fourth Blog","This is my fourth blog",null,"suyash","pending");
			Blog blog4=new Blog("fifth Blog","This is my fifth blog",null,"srijan","pending");

			blogService.saveBlog(blog);
			blogService.saveBlog(blog1);
			blogService.saveBlog(blog2);
			blogService.saveBlog(blog3);
			blogService.saveBlog(blog4);

		};
	}
}
