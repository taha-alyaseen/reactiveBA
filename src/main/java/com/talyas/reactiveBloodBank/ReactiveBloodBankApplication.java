package com.talyas.reactiveBloodBank;

import com.talyas.reactiveBloodBank.service.donor.DonorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveBloodBankApplication {
	@Autowired
	static DonorHandler donorHandler;
	public static void main(String[] args) {
		SpringApplication.run(ReactiveBloodBankApplication.class, args);
	}

}