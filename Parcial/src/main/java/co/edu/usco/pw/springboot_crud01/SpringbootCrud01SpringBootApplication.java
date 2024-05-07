package co.edu.usco.pw.springboot_crud01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootCrud01SpringBootApplication {
	
	public static void main(String[] args) {
		System.setProperty("server.port", "8080");
		SpringApplication.run(SpringbootCrud01SpringBootApplication.class, args);
	
	}
}
