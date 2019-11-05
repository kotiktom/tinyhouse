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
	
	/*
	@RequestMapping(value = "/question", method = RequestMethod.GET, produces="application/xml")
    public void show(HttpServletRequest request, HttpServletResponse response) throws Exception {
        this.surveyService = new SurveyService(surveyRepository);
        Survey survey = surveyService.find(Long.parseLong(request.getParameter("survey")));

        Question currentQuestion = survey.getQuestionByNumber(Integer.parseInt(request.getParameter("question")));
        QuestionBuilder builder = getQuestionHandler(currentQuestion, request);

        if (currentQuestion != null) {
            response.getWriter().print(builder.build());
        } else {
            response.getWriter().print(builder.buildNoMoreQuestions());
        }
        response.setContentType("application/xml");
    }	
    */

	@RequestMapping(value = "/save", method = RequestMethod.POST) 
	public String save(Question question) {
		questionRepository.save(question);
		return "index";
		}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces="text/html")
	@ResponseBody
	public void Home2(Model model, HttpServletResponse response) throws Exception {
		model.addAttribute("inputs", inputrepo.findAll());	
		
		List<InputType> A = new ArrayList<>();
		A = inputrepo.findAll();
		
		String returnString = "<html><body>";
		
		for (InputType i: A) {
			returnString += i.getType();
		}
		
		returnString += "</body></html>";
		
		response.getWriter().print(returnString);

		response.setContentType("text/html");
		}
}
