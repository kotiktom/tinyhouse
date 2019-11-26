package com.tinyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tinyhouse.model.Answer;
import com.tinyhouse.model.Question;
import com.tinyhouse.model.ResponseAnswer;
import com.tinyhouse.repository.AnswerRepository;
import com.tinyhouse.repository.QuestionRepository;
import com.tinyhouse.service.AnswerService;

@Controller
public class AnswerController {
	
	@Autowired
	QuestionRepository questionRepository;
	
	@Autowired
	AnswerRepository answerrepo;
	
	@Autowired
	AnswerService answerService;
	

	@GetMapping("/questions/{id}/answers")
	@ResponseBody
	public List<Answer> getAnswers(@PathVariable long id){
	
		return answerService.getAnswers(id);
	
	}




	
	@PostMapping("/questions/answers")
	@ResponseBody
	// TODO Muuta vastaus tulemaan itse pyynnön mukana
	public Question postAnswer(@RequestBody ArrayList<ResponseAnswer> answer){
		
		for (int i = 0; i < answer.size(); i++) {
		Question q = questionRepository.getOne(answer.get(i).getQuestionid());
		
		Answer newAnswer = new Answer(answer.get(i).getAnswer(), q);
		
		ArrayList<Answer> newQuestionWithAnswer = new ArrayList<Answer>();
		newQuestionWithAnswer.add(newAnswer);
	
		answerrepo.save(newAnswer);
		q.getAnswers().add(newAnswer);	
		}
		
		return null;
		
	}
	
	@GetMapping("/answers")
	@ResponseBody
	public List<Answer> getAnswers() {
		return answerrepo.findAll();
	}

}
