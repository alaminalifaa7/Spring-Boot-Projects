package com.example.springdatajpapractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaPracticeApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringDataJpaPracticeApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args->{
			Student maria = new Student("Maria","jones","maria@gmail.com",25);
			studentRepository.save(maria);
		};
	}
}
