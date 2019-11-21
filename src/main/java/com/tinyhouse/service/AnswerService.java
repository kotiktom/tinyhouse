package com.tinyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tinyhouse.model.Answer;
import com.tinyhouse.model.Question;
import com.tinyhouse.repository.AnswerRepository;
import com.tinyhouse.repository.QuestionRepository;

@Service

public class AnswerService {

	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	QuestionRepository questionRepository;
	
	@Transactional	
	public void saveAnswer(long id, String answerContent) {
		
		Question question = questionRepository.getOne(id);
		Answer answer = new Answer();
		answer.setAnswer(answerContent);
		answer.setQuestion(question);
		answerRepository.save(answer);

		question.getAnswers().add(answer);
		questionRepository.save(question);
		
		
		System.out.println("toimii");
	}
	
	
}
