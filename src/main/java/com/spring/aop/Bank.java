package com.spring.aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bank {
	private int balance;
	private int pin;

	public int getBalance() {
		return balance;
	}

	@Value("5000")
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getPin() {
		return pin;
	}

	@Value("1234")
	public void setPin(int pin) {
		this.pin = pin;
	}

	public void showBalance() {
		System.out.println("Available balance is: " + this.balance);
	}

	public void deposit(int amount) {
		this.balance = balance + amount;
		System.out.println("Amount deposited successfully!");
	}

	public void withdraw(int amount) {
		this.balance = this.balance - amount;
		System.out.println("Amount withdrawal successfully!");
	}

	public int changePin(int newPin) {
		return this.pin = newPin;
	}

}
