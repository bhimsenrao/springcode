package com.jpaProj.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpaProj.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	public java.util.List<Person> findByPname(String pname);
}
