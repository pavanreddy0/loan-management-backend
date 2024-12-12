package com.loan.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

}


/*
*
* TO check if customer is eligible for a personal loan of $5000, I need to check for a criteria, for now I am assuming
* there is a field called credit_score, stored in the customer table, and can be assigned randomly for now.
*
* Based on this, I can check for eligibility
* */