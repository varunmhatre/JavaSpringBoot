package com.examples.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Alien {

	private int aID;
	private String aName;
	private String aTechnology;
	@Autowired
	@Qualifier("comp1")
	private Device device;
	@Autowired
	private Laptop laptop;
	
	public Alien() {
		super();
		System.out.println("Alien created");
	}
	public int getaID() {
		return aID;
	}
	public void setaID(int aID) {
		this.aID = aID;
	}
	public String getaName() {
		return aName;
	}
	public void setaName(String aName) {
		this.aName = aName;
	}
	public String getaTechnology() {
		return aTechnology;
	}
	public void setaTechnology(String aTechnology) {
		this.aTechnology = aTechnology;
	}	
	public Laptop getLaptop() {
		return laptop;
	}
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public Device getDevice() {
		return device;
	}
	public void setDevice(Device device) {
		this.device = device;
	}
	
	public void show()
	{
		System.out.println("In show");
		laptop.compile();
	}
	
}
