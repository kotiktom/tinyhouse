package com.tinyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tinyhouse.model.Question;
import com.tinyhouse.repository.QuestionRepository;

@RestController
public class QuestionController {

	@Autowired
	QuestionRepository questionRepository;
	
	@GetMapping("/questions")
	public List<Question> getQuestions() {
		
		return questionRepository.findAll();
	}
	
	
}
