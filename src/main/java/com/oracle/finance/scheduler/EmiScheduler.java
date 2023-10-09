package com.oracle.finance.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.oracle.finance.service.TransactionService;

@Component
public class EmiScheduler {
	
	@Autowired
	TransactionService transactionService;
	
	@Scheduled(cron = "00 00 10 03 * *")
	public void payEMI() { 
		System.out.println("paying"); 
		transactionService.payEmi();
	}

}
