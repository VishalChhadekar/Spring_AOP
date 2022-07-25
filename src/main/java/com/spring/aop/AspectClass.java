package com.spring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
@Component
public class AspectClass {
	private Bank bank;

	public Bank getBank() {
		return bank;
	}

	@Autowired
	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Around(value = "execution(public void com.spring.aop.Bank.showBalance())")
	public void validateUser(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Validating user before pointcut: showBalance");
		joinPoint.proceed();
		System.out.println("Execution after pointcut");
	}

	@Before(value = "execution(public void com.spring.aop.Bank.deposit(..))")
	public void notification() {
		System.out.println("Checking for KYC status");
	}

	@After(value = "execution(public void com.spring.aop.Bank.deposit(..)) ||"
			+ "execution(public void com.spring.aop.Bank.withdraw(..))")
	public void transactionNotification() {
		System.out.println("Transaction completed Successfully!");
	}

	@AfterReturning(value = "execution(public int com.spring.aop.Bank.changePin(..))")
	public void afterChnagePin() {
		System.out.println("You have successfully changed the pin");
	}

    @AfterThrowing(value = "within(com.spring.aop.Bank)")
    public void afterWrongPin() {
        System.out.println("Error");
    }

}
