package com.tinyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

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
	

	
	public List<Answer> getAnswers(@PathVariable long id){
		
		Question q = questionRepository.getOne(id);
		
		return q.getAnswers();
	}
	
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
