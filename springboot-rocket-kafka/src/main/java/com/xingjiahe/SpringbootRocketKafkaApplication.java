package com.xingjiahe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.xingjiahe.www")
public class SpringbootRocketKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootRocketKafkaApplication.class, args);
	}

}
