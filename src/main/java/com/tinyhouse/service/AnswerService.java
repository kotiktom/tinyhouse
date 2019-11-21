package com.tinyhouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void saveAnswer(long id, String answer) {
		Question question = questionRepository.getOne(id);
		question.getAnswers().add(new Answer(answer));
		
	}
	
	
}
