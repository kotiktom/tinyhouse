package com.tinyhouse.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tinyhouse.model.Question;
import com.tinyhouse.model.Survey;
import com.tinyhouse.repository.QuestionRepository;
import com.tinyhouse.repository.SurveyRepository;

@Controller
public class QuestionController {

	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	SurveyRepository surveyRepository;
	
	@GetMapping("/question/{id}")
	@ResponseBody
	public Question getQuestion(@PathVariable long id) {
		return questionRepository.getOne(id);
	}
	
	@GetMapping("/questions")
	@ResponseBody
	public List<Question> getQuestions() {
		return questionRepository.findAll();
	}
	

	@PostMapping("/question")
	@ResponseBody
	public Question addQuestion(@RequestBody Question question) {
		
		
		
		return questionRepository.save(question);
	}
	
	
}
