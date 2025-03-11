package com.kiran.test;

public class Departments 
{
	Integer id;
	String name;
	String location;
	Integer managerId;
	public Departments(int id, String name, String location, int managerId) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.managerId = managerId;
	}
	public Departments() {
		super();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Departments [id=" + id + ", name=" + name + ", location=" + location + ", managerId=" + managerId + "]";
	}
	

}
