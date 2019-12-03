package com.tinyhouse.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tinyhouse.model.Answer;
import com.tinyhouse.model.Question;
import com.tinyhouse.model.ResponseAnswer;
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
	public void saveOneAnswer(ResponseAnswer answer) {
			Question q = questionRepository.getOne(answer.getQuestionId());
			
			Answer newAnswer = new Answer(answer.getAnswer(), q);
			
			ArrayList<Answer> newQuestionWithAnswer = new ArrayList<Answer>();
			newQuestionWithAnswer.add(newAnswer);
		
			answerRepository.save(newAnswer);
			q.getAnswers().add(newAnswer);	
	}
	
	@Transactional	
	public void saveAnswer(ArrayList<ResponseAnswer> answer) {
		
		for (int i = 0; i < answer.size(); i++) {
			Question q = questionRepository.getOne(answer.get(i).getQuestionId());
			
			Answer newAnswer = new Answer(answer.get(i).getAnswer(), q);
			
			ArrayList<Answer> newQuestionWithAnswer = new ArrayList<Answer>();
			newQuestionWithAnswer.add(newAnswer);
		
			answerRepository.save(newAnswer);
			q.getAnswers().add(newAnswer);	
			}
	}
	
}
