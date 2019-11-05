package com.tinyhouse.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tinyhouse.model.InputType;
import com.tinyhouse.model.Question;
import com.tinyhouse.model.Survey;
import com.tinyhouse.repository.InputTypeRepository;
import com.tinyhouse.repository.QuestionRepository;
import com.tinyhouse.repository.SurveyRepository;

@Controller
public class QuestionController {

	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	SurveyRepository surveyRepository;
	
	@Autowired
	InputTypeRepository inputrepo;
	
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
	

	@RequestMapping(value = "/save", method = RequestMethod.POST) 
	public String save(Question question) {
		questionRepository.save(question);
		inputrepo.save(question);
		return "redirect:test";
		}
	
	@RequestMapping(value = "/saveque", method = RequestMethod.POST)
	public String save(InputType inputtype) {
		inputrepo.save(inputtype);
		return "redirect:test";
		}
	
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String Home2(Model model) {
		model.addAttribute("inputs1", inputrepo.findAll());
		model.addAttribute("inputs", new InputType());
		return "test";
		}

	@GetMapping("/que")
	@ResponseBody
	public List<InputType> getQue() {
		return inputrepo.findAll();
	}
}
