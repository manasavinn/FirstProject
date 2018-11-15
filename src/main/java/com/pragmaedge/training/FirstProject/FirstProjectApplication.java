package com.pragmaedge.training.FirstProject;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstProjectApplication implements CommandLineRunner {
	@Autowired
	private DataSource datasource;
	public static void main(String[] args) {
	
		SpringApplication.run(FirstProjectApplication.class, args);
		
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.print("Datasource="+datasource);
	}
}
