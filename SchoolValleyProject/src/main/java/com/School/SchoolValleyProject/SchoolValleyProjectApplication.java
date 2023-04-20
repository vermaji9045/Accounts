package com.School.SchoolValleyProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.School.SchoolValleyProject.repository")
@EntityScan("com.School.SchoolValleyProject.Model")
public class SchoolValleyProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolValleyProjectApplication.class, args);
	}

}
