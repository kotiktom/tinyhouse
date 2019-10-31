package com.tinyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tinyhouse.model.Question;
import com.tinyhouse.repository.QuestionRepository;

@Controller
public class AnswerController {
	
	@Autowired QuestionRepository questionRepository;

	@GetMapping("/questions/{id}/answers")
	@ResponseBody
	public List<String> getAnswers(@PathVariable long id){
		Question q = questionRepository.getOne(id);
		
		return q.getContent();
		
	}
	
	@PostMapping("/questions/{id}/answers/{answer}")
	@ResponseBody
	public Question postAnswer(@PathVariable long id, @PathVariable String answer){
		Question q = questionRepository.getOne(id);
		
		if (q.getAnswers() == null) {
			q.setAnswers(new ArrayList<>());
		} else {
			q.getAnswers().add(answer);
		}
		
		return questionRepository.save(q);
		
	}
	
}
