package com.tinyhouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tinyhouse.repository.QuestionRepository;

@Controller
public class AnswerController {
	
	@Autowired QuestionRepository questionRepository;

	@GetMapping("/questions/{id}/answers")
	@ResponseBody
	public String getAnswers(@PathVariable long id){
		Question q = que
		
		
	}
	
	
}
