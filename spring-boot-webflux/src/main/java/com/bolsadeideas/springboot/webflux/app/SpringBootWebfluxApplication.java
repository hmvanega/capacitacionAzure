package com.bolsadeideas.springboot.webflux.app;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebfluxApplication {

		
	@Autowired
		
	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxApplication.class, args);
	}


}
