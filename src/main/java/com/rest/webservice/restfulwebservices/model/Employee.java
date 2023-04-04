package com.rest.webservice.restfulwebservices.model;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

public class Employee {
	private Integer id;
	@Size(min=2, message="Name should have atleast 2 character")
//	@ApiModelProperty(notes="Name should have atleast 2 character")
	private String name;

	private String salary;
	private String designation;
	public Employee(Integer id, String name, String salary, String designation) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
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
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", designation=" + designation + "]";
	}
	
	

}
