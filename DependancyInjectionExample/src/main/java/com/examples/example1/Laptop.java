package com.examples.example1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Laptop implements Device {

	private int lID;
	private String brand;
	
	public Laptop() {
		System.out.println("Laptop object created ");
	}
	
	public int getlID() {
		return lID;
	}
	public void setlID(int lID) {
		this.lID = lID;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/*
	 * @Override public String toString() { return
	 * "Laptop: [lID="+lID+", brand="+brand+"]"; }
	 */
	public void compile()
	{
		System.out.println("Compiling...");
	}
}
