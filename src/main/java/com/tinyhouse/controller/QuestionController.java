package com.tinyhouse.controller;

import java.util.ArrayList;
import java.util.List;

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
	
	@GetMapping("/questions")
	@ResponseBody
	public List<Question> getQuestions() {
		
		return questionRepository.findAll();
	}
	
	//name = surveyname
	@PostMapping("/{name}/question")
	public Question addQuestion(@PathVariable String name, @RequestBody Question question) {
		
		if (surveyRepository.findByName(name) == null) {
            surveyRepository.save(new Survey("name", null));
        }
        
        Question q = question;
        Survey s = surveyRepository.findByName(name);
        q.setSurvey(s);
        questionRepository.save(q);
        
		
		return questionRepository.save(question);
	}
	
	
}
