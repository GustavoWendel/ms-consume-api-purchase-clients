package com.br.spring.api.desafioibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DesafioibmApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioibmApplication.class, args);
	}

}
