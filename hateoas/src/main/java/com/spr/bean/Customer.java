package com.spr.bean;

public class Customer {
    private String id;
    private String name;
    private String company;
	public Customer() {
	
	}
	public Customer(String id, String name, String company) {
		super();
		this.id = id;
		this.name = name;
		this.company = company;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", company=" + company + "]";
	}


}
