package com.mobiquityinc.test.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.mobiquityinc.test" })
public class SpringBootApplicationMain {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApplicationMain.class, args);
	}

}
