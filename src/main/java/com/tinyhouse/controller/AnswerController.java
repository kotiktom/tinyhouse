package com.tinyhouse.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tinyhouse.model.Answer;
import com.tinyhouse.model.ResponseAnswer;
import com.tinyhouse.repository.AnswerRepository;
import com.tinyhouse.repository.QuestionRepository;
import com.tinyhouse.service.AnswerService;

@Controller
public class AnswerController {

	@Autowired
	QuestionRepository questionRepository;

	@Autowired
	AnswerRepository answerrepo;

	@Autowired
	AnswerService answerService;

	@Autowired
	AnswerRepository answerRepository;

	@GetMapping("/questions/{id}/answers")
	@ResponseBody
	public List<Answer> getAnswers(@PathVariable long id) {

		return answerService.getAnswers(id);

	}

	@PostMapping("/questions/answers")
	@ResponseBody
	public void postAnswer(@RequestBody ArrayList<ResponseAnswer> answer) {

		answerService.saveAnswer(answer);

	}

	@GetMapping("/answers")
	@ResponseBody
	public List<Answer> getAnswers() {
		return answerrepo.findAll();
	}

	@RequestMapping("/answer")
	public String answer(Model model) {
		model.addAttribute("question", questionRepository.findAll());
		model.addAttribute("answer", answerRepository.findAll());
		return "answer";
	}
}
