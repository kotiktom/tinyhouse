package com.tinyhouse.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tinyhouse.model.Question;
import com.tinyhouse.model.QuestionOption;
import com.tinyhouse.model.Survey;
import com.tinyhouse.repository.QuestionOptionRepository;
import com.tinyhouse.repository.QuestionRepository;
import com.tinyhouse.repository.SurveyRepository;

@Controller
public class AdminController {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private SurveyRepository surveyRepository;

	@Autowired
	private QuestionOptionRepository questionOptionRepository;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

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

	@GetMapping("/admin/questions/{id}")
	public String viewQuestion(Model model, @PathVariable Long id) {
		model.addAttribute("question", questionRepository.getOne(id));
		model.addAttribute("questions", questionOptionRepository.findAll());

		return "question";
	}

	@GetMapping("/admin/reset")
	public void ResetQuestions() {
		questionRepository.deleteAll();
		Question q1 = new Question("Opiskeluvuosi: ");
		Question q2 = new Question("Mitä teet vapaa-ajallasi: ");
		Question q3 = new Question("Vapaa-aikaa on mielestäni riittävästi: ");

		questionRepository.save(q1);
		questionRepository.save(q2);
		questionRepository.save(q3);
	}

	@PostMapping("/admin/questions/{questionId}/questions/")
	@Transactional
	public String addQuestionToQuestion(@PathVariable Long questionId, @RequestParam ArrayList<String> content) {

		Question q = questionRepository.getOne(questionId);

		for (int i = 0; i < content.size(); i++) {

			QuestionOption q1 = new QuestionOption(q, content.get(i));
			questionOptionRepository.save(q1);
			q.getQuestionOptions().add(q1);

			questionRepository.save(q);
		}
		return "redirect:/admin/questions/" + questionId;
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
	public String addQuestionToSurvey(@PathVariable Long surveyId, @RequestParam String content,
			@RequestParam String inputType) {

		Survey survey = surveyRepository.getOne(surveyId);
		Question question = new Question();
		question.setAnswers(new ArrayList<>());
		question.setContent(content);
		question.setSurvey(survey);
		question.setInputType(inputType);
		questionRepository.save(question);

		survey.getQuestions().add(question);

		questionRepository.save(question);
		surveyRepository.save(survey);

		return "redirect:/admin/surveys/" + surveyId;
	}

}
