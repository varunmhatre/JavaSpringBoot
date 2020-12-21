package com.examples.example4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Alien {
	
	@Id
	@GeneratedValue
	private int aid;
	private int anum;
	private String aname;
	private String tech;
	
	@Override
	public String toString() {
		return "Alien = ["+aid+", "+aname+"]";
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}	
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}

	public int getAnum() {
		return anum;
	}

	public void setAbirth(int abirth) {
		this.anum = abirth;
	}
}
