package com.rest.webservice.restfulwebservices.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.webservice.restfulwebservices.dao.EmployeeDAOService;
import com.rest.webservice.restfulwebservices.exception.UserNotFoundException;
import com.rest.webservice.restfulwebservices.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeDAOService service;
	
	 @GetMapping("/employees")
	 public List<Employee> retrieveAllEmployee() {
	 return service.findAll();
	  }
	 
	 
	 @GetMapping("/employees/{id}")
	 public EntityModel<Employee> retrieveEmployee(@PathVariable int id) {
	 Employee employee =  service.findOne(id);
	 if(employee == null) 
		 
		 throw new UserNotFoundException("id - "+ id +" not found");
	 
	 //"all-users",SERVER_PATH +
	 EntityModel<Employee> resource = EntityModel.of(employee);
		
		WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllEmployee());
		
		resource.add(linkTo.withRel("all-employees"));
	 
	 return resource;
	 }
	 
	 
	 @DeleteMapping("/employees/{id}")
	 public ResponseEntity<Object> deleteEmployee(@PathVariable int id) {
	   Employee deleteEmp = service.deleteById(id);
	   URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{id}")
				 .buildAndExpand(deleteEmp.getId()).toUri();
		 
		 return ResponseEntity.noContent().build();
	 }
	 
	 @PostMapping("/employees")
	 public  ResponseEntity<Object>  createUser(@Valid @RequestBody Employee emp){
		 Employee savedEmp = service.save(emp);
		 URI location = ServletUriComponentsBuilder
				 .fromCurrentRequest()
				 .path("/{id}")

				 .buildAndExpand(savedEmp.getId()).toUri();
		 
		 return ResponseEntity.created(location).build();


	 } 


}
