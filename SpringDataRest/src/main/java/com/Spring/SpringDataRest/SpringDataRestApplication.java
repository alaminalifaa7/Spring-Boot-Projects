package com.Spring.SpringDataRest;

import com.Spring.SpringDataRest.entity.User;
import com.Spring.SpringDataRest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataRestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRestApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = User.builder()
				.firstName("Rahim")
				.lastName("Sterling")
				.email("rahim@gmail.com")
				.build();


		User user2 = User.builder()
				.firstName("Rahim2")
				.lastName("Sterling2")
				.email("rahim@gmail.com")
				.build();


		User user3 = User.builder()
				.firstName("Rahi3")
				.lastName("Sterling3")
				.email("rahim@gmail.com")
				.build();


		User user4 = User.builder()
				.firstName("Rahim4")
				.lastName("Sterling4")
				.email("rahim@gmail.com")
				.build();

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
	}
}
