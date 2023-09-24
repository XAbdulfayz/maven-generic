package com.xa.MapperAndGeneric;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@OpenAPIDefinition
@SpringBootApplication
@EnableTransactionManagement
public class MapperAndGenericApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapperAndGenericApplication.class, args);
	}

}
