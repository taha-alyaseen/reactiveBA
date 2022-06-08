package com.talyas.reactiveBloodBank;

import com.talyas.reactiveBloodBank.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveBloodBankApplication {
	@Autowired
	static DonorService donorService;
	public static void main(String[] args) {


		SpringApplication.run(ReactiveBloodBankApplication.class, args);
	}

}