package com.talyas.reactiveBloodBank;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan({"com.talyas.reactiveBloodBank.repositories"})
@ComponentScan({"com.talyas.reactiveBloodBank.router"})
@ComponentScan({"com.talyas.reactiveBloodBank.entities"})
@ComponentScan({"com.talyas.reactiveBloodBank.config"})
public class ReactiveBloodBankApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReactiveBloodBankApplication.class, args);
	}

}