package com.onetomany.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onetomany.entity.Answer;

public interface AnswerRepo extends JpaRepository<Answer, Integer> {

}
