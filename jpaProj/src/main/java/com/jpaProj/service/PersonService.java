package com.jpaProj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpaProj.entity.Person;
import com.jpaProj.exception.RecordNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public java.util.List<Person> getAllPerons(){
		return  repository.findAll();
	}
	public Person getPersonById(Integer id) {
		return repository.findById(id).get();
	}
	public Person addPerson(String pname,String mail) {
		Person p= new Person();
		p.setPname(pname);
		p.setEmail(mail);
		return repository.save(p);
	}
	
	public Person updMail(Integer id,String mail) {
		Person p= repository.findById(id).get();
		if(p!=null) {
		  p.setEmail(mail);
		  return repository.save(p);  
		}
		else
			return null;
		
	}
	public Person update(Person person) {
		Person p=repository.findById(person.getPid())
				.orElseThrow(()->new RecordNotFoundException("Record not found with id="+person.getPid() ));
		p.setPname(person.getPname());
		p.setEmail(person.getEmail());
         return repository.save(p);			
	}
	
	public Person deletePerson(Integer id) {
		Person p=repository.findById(id).get();
		repository.delete(p);
		return p;
	}
	public java.util.List<Person> findByName(String name){
		return repository.findByPname(name);
	}
}
