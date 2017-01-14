package com.bong.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bong.jpa.domain.Project;
import com.bong.jpa.domain.User;
import com.bong.jpa.service.ProjectService;

@SpringBootApplication
public class BongApplication {


	public static void main(String[] args) {
		SpringApplication.run(BongApplication.class);

	}

}
