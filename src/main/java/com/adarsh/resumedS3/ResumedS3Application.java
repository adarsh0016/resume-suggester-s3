package com.adarsh.resumedS3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ResumedS3Application {

	public static void main(String[] args) {
		SpringApplication.run(ResumedS3Application.class, args);
	}

}
