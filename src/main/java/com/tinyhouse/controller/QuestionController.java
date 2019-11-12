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
	

	@PostMapping("/save")
	public String save(Question question) {
		questionRepository.save(question);
		return "redirect:test";
		}
	
	@PostMapping("/saveque")
	public String save(InputType inputtype) {
		inputrepo.save(inputtype);
		return "redirect:index";
		}
	
	@PostMapping("/savesurvey")
	public String saveSurvey(Survey survey) {
		surveyRepository.save(survey);
		
		return "redirect:/index";
		}
	
	
	@GetMapping("/test")
	public String Home2(Model model) {
		model.addAttribute("inputs1", inputrepo.findAll());
		model.addAttribute("inputs", new InputType());

		return "test";
	}
	
	public List<String> QuestionAmount() {
	int in = Integer.parseInt(surveyRepository.FindLastRecordSurvey());
	List<String> l = null;
	
	for (int i = 0; i < in; i++) {
		l.add(" ");
	}
	System.out.println(l);
		return l;
		
	}
	

	@GetMapping("/index")
	public String Home(Model model) {

		
		int in = Integer.parseInt(surveyRepository.FindLastRecordSurvey());
		ArrayList<String> list = new ArrayList<String>();
		System.out.println(in);
		int i = 0;
		while (i < in) {
		list.add("asd");
			i++;
		}
		
		model.addAttribute("inputs", inputrepo.findAll());
		model.addAttribute("allSurveys", surveyRepository.findAll());
		model.addAttribute("loopValue", list);
		model.addAttribute("question", new Question());
		return "index";
		}
	
	@GetMapping("/addsurvey")
	public String AddSurvey(Model model) {
		model.addAttribute("survey", new Survey());
		return "newSurvey";
		}
	
	@GetMapping("/que")
	@ResponseBody
	public List<InputType> getQue() {
		return inputrepo.findAll();
	}
}
