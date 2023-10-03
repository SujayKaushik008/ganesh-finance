package com.oracle.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan (basePackages = "com.oracle.finance")
public class GaneshFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaneshFinanceApplication.class, args);

		System.out.println("first commit");
	}

}
