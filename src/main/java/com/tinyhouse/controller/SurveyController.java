package com.tinyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tinyhouse.model.Question;
import com.tinyhouse.model.Survey;
import com.tinyhouse.repository.QuestionRepository;
import com.tinyhouse.repository.SurveyRepository;

@Controller
public class SurveyController {

	@Autowired
	SurveyRepository surveyRepository;
	
	@GetMapping("/surveys")
	@ResponseBody
	public List<Survey> getQuestions() {
		
		return surveyRepository.findAll();
	}
	
	@PostMapping("/surveys")
	public Survey addSurvey(@RequestBody Survey survey) {
		return surveyRepository.save(survey);
	}
	
	
}
