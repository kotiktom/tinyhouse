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
		
		Question q = questionRepository.getOne(id);
		
		return q.getAnswers();
	
	}

	@PostMapping("/questions/{id}/answers")
	// TODO Muuta vastaus tulemaan itse pyynnön mukana
	public String saveAnswer(@PathVariable long id, @RequestBody String answer){
		// Functional brahs
		answerService.saveAnswer(id, answer);

		return "redirect:/question/{}id/answers";
	}
	
	@PostMapping("/questions/{id}/answers/NOGO")
	@ResponseBody
	// TODO Muuta vastaus tulemaan itse pyynnön mukana
	public Question postAnswer(@PathVariable long id, @RequestBody String answer){
		Question q = questionRepository.getOne(id);
		
		Answer newAnswer = new Answer(answer, q);
		
		ArrayList<Answer> newQuestionWithAnswer = new ArrayList<Answer>();
		newQuestionWithAnswer.add(newAnswer);
	
		answerrepo.save(newAnswer);
		q.getAnswers().add(newAnswer);		
		
		return q;
	}
	
	@GetMapping("/answers")
	@ResponseBody
	public List<Answer> getAnswers() {
		return answerrepo.findAll();
	}
	
	
	
}
