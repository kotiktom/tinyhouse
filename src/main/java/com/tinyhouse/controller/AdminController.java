package com.tinyhouse.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tinyhouse.model.Question;
import com.tinyhouse.model.Survey;
import com.tinyhouse.repository.QuestionRepository;
import com.tinyhouse.repository.SurveyRepository;

@Controller
public class AdminController{

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private SurveyRepository surveyRepository;

	@GetMapping("/admin/surveys")
    public String listExams(Model model) {
        model.addAttribute("surveys", surveyRepository.findAll());
        return "surveys";
    }

    @GetMapping("/admin/surveys/{id}")
    public String viewExam(Model model, @PathVariable Long id) {
        model.addAttribute("survey", surveyRepository.getOne(id));
        model.addAttribute("questions", questionRepository.findAll());
        
        return "survey";
    }
    
    @PostMapping("/admin/surveys")
    public String addSurvey(@RequestParam String subject) {
        
        Survey survey = new Survey();
        survey.setSubject(subject);
        survey.setQuestions(new ArrayList<>());

        surveyRepository.save(survey);

        return "redirect:/admin/surveys";
    }

    @PostMapping("/admin/surveys/{surveyId}/questions/")
    @Transactional
    public String addQuestionToSurvey(@PathVariable Long surveyId, @RequestParam String content) {

        Survey survey = surveyRepository.getOne(surveyId);
        Question question = new Question();
        question.setAnswers(new ArrayList<>());
        question.setContent(content);
        question.setSurvey(survey);
        questionRepository.save(question);

        survey.getQuestions().add(question);
        
        
        questionRepository.save(question);
        surveyRepository.save(survey);
        
        return "redirect:/admin/surveys/" + surveyId;
    }


	@GetMapping("/admin/questions")
	public String list(Model model) {
		model.addAttribute("questions", questionRepository.findAll());
		return "questions";
	}

	@PostMapping("/admin/questions")
	public String addQuestion(@RequestParam String content) {
		Question q = new Question();
		q.setContent(content);
		questionRepository.save(q);
		
		return "redirect:/admin/questions";
	}
	
}
