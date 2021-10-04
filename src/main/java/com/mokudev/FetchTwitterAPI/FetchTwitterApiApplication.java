package com.mokudev.FetchTwitterAPI;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class FetchTwitterApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(FetchTwitterApiApplication.class, args);
	}

}
