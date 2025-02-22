package com.spr.controller;

import org.springframework.hateoas.RepresentationModel;

public class CustomerResource extends RepresentationModel<CustomerResource> {
	private String id;
	private String name;
	private String company;

	public CustomerResource() {

	}

//	public CustomerResource(String id, String name, String company) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.company = company;
//	}

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
		return "CustomerResource [id=" + id + ", name=" + name + ", company=" + company + "]";
	}
}
