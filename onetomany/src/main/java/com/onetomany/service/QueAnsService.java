package com.onetomany.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onetomany.entity.Answer;
import com.onetomany.entity.Question;
import com.onetomany.repo.AnswerRepo;
import com.onetomany.repo.QuestionRepo;

@Service
public class QueAnsService {

	@Autowired private QuestionRepo question;
	@Autowired private AnswerRepo ans;
	
	public java.util.Map<Question,java.util.List<Answer>> getQuest(Integer qid) {
		
		 Question q=question.findById(qid).get();
		 java.util.List<Answer>   a=q.getAnswers();
		 HashMap<Question, java.util.List<Answer>> qa= new HashMap<>();
		 qa.put(q, a);
		 return qa;
	}
	
	@Transactional
	public void addQuest(Question quest, java.util.List<Answer> answers, String postedby) {
		quest.setAnswers(answers);
		for (Answer ans:answers) {
			ans.setPostedBy(postedby);
		}
		question.save(quest);
//		return question.save(quest);
	}
	
}
