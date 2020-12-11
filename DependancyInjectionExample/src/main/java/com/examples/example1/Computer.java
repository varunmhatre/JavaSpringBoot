package com.examples.example1;

import org.springframework.stereotype.Component;

@Component("comp1")
public class Computer implements Device {

	public Computer() {
		System.out.println("Computer object created ");
	}
	
	@Override
	public void compile() {
		System.out.println("Computing...");
	}

}
