package com.onetomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetomany.entity.Question;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

}
