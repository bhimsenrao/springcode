package com.jpaProj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jpaProj.entity.Person;
import com.jpaProj.service.PersonService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class PersonController {
	@Autowired private PersonService service;
	
	@GetMapping("/persons")
	public java.util.List<Person> viewPersons(){
		return service.getAllPerons();
	}
	// url:  http://localhost:9090/persons

	@GetMapping("/{id}")
	public Person getPersonById(@PathVariable("id") Integer id) {
		return service.getPersonById(id);
	}
	@GetMapping("/addPerson/{pname}/{mail}")
	public Person addPerson(@PathVariable("pname")String name,@PathVariable("mail")String mail) {
		return service.addPerson(name, mail);
	}
	@GetMapping("/updPerson/{id}/{mail}")
	public Person addPerson(@PathVariable("id")Integer id,@PathVariable("mail")String mail) {
		return service.updMail(id, mail);
	}
	//-------------
	
	@PostMapping("/addPerson")
	public Person addPerson(@RequestBody Person person) {
		
		return service.addPerson(person.getPname(),person.getEmail() );
	}
	
	@PutMapping("/upd")
	public Person update(@RequestBody Person person) {	
		return service.updMail(person.getPid(), person.getEmail());
	}
	
	@PutMapping("/update")
	public Person update1(@RequestBody Person person) {	
		return service.update(person);
	}
	@DeleteMapping("/delete/{id}")
	public Person delete(@PathVariable("id")Integer id) {	
		return service.deletePerson(id);
	}
	
	@GetMapping("/getByName/{name}")
	public java.util.List<Person> getAll(@PathVariable("name") String name){
		return service.findByName(name);
	}
	
}
