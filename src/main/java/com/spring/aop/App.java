package com.spring.aop;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Program initiated!");
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		Bank bank = context.getBean(Bank.class);
		bank.showBalance();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter amout to deposite");
		int amount = scanner.nextInt();
		bank.deposit(amount);
		System.out.println("Enter amout to withdraw");
		int input = scanner.nextInt();
		bank.withdraw(input);
		System.out.println("Enter new Pin");
		int pin = scanner.nextInt();
		int changedPin = bank.changePin(pin);

	}
}
