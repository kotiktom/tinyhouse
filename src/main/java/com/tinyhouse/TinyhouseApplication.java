package com.tinyhouse;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tinyhouse.model.InputType;
import com.tinyhouse.model.Question;
import com.tinyhouse.repository.InputTypeRepository;
import com.tinyhouse.repository.QuestionRepository;

@SpringBootApplication
public class TinyhouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyhouseApplication.class, args);
	}

	
	@Bean
	public CommandLineRunner tinyhouseRunner(QuestionRepository questionrepo, InputTypeRepository inputrepo) {
		return (args) -> {
			
			ArrayList<String> questions = new ArrayList<String>();
			questions.add("test1");
			questions.add("test2");
			questions.add("test3");
			questions.add("test4");
			
			ArrayList<String> answers = new ArrayList<String>();
			answers.add("test1");
			answers.add("test2");
			
			ArrayList<String> inputs = new ArrayList<String>();
			
			inputs.add("<h4>Text: <input type=\"text\"value=\"input\"/></h4>");
			inputs.add("<h4>Checkbox: <input type=\"checkbox\" value=\"input\"/><h4>");
			inputs.add("<h4>Radio: <input type=\"radio\" value=\"input\"/><h4>");
			inputs.add("<h4><input id=\"save\" type=\"submit\" value=\"Submit\"/>");
			
			Question q = new Question(questions, inputs, answers, null);
			
			questionrepo.save(q);
			
			InputType i = new InputType("<h4>Text: <input type=\"text\"value=\"input\"/></h4>", "Text");
			InputType i2 = new InputType("<h4>Checkbox: <input type=\"checkbox\" value=\"input\"/><h4>", "Checkbox");
			InputType i3 = new InputType("<h4>Radio: <input type=\"radio\" value=\"input\"/><h4>", "Radio");
			InputType i4 = new InputType("<h4><input id=\"save\" type=\"submit\" value=\"Submit\"/>", "Submit");

			inputrepo.save(i);
			inputrepo.save(i2);
			inputrepo.save(i3);
			inputrepo.save(i4);
	
		};
	
}}
