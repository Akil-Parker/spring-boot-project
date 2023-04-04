package com.rest.webservice.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.rest.webservice.restfulwebservices.model.Employee;

@Component
public class EmployeeDAOService {

	private static List<Employee> employees = new ArrayList<>();

	private static int usersCount = 3;
	
	static {
		employees.add(new Employee(1, "yash","25000","Engineer" ));
		employees.add(new Employee(2, "sonu","35000","Team Leader" ));
		employees.add(new Employee(3, "irene","45000","Admin" ));
		 }
	
	public List<Employee> findAll()
	 {
	 return employees;
	 }
	
	public Employee save(Employee emp)
	 {
	 if (emp.getId() == null) {
		 emp.setId(++usersCount);
	 }
	 employees.add(emp);
	 return emp;
	 }
	
	public Employee findOne(int id) {
		 for (Employee emp : employees) {
		    if (emp.getId() == id) {
			    return emp;
		     } 
		 }
		 return null;
		 }
	
	public Employee deleteById(int id) {
		Iterator<Employee> itr = employees.iterator();
		while(itr.hasNext()) {
			Employee employee = itr.next();
		    if (employee.getId() == id) {
		    	itr.remove();
			    return employee;
		     } 
		}
		 return null;
	}

	

	
}