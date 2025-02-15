package com.nj.nj_rpg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NjRpgApplication {

	public static void main(String[] args) {
		SpringApplication.run(NjRpgApplication.class, args);
	}

}
