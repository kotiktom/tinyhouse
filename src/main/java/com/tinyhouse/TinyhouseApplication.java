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
			
			ArrayList<String> answers = new ArrayList<String>();
			answers.add("test1");
			answers.add("test2");
			
			Question q = new Question(questions, null, answers);
			
			questionrepo.save(q);
			
			InputType i = new InputType("<input type=\"checkbox\" name=\"vehicle1\" value=\"Bike\"> I have a bike");
			InputType i2 = new InputType("<input type=\"checkbox\" name=\"vehicle2\" value=\"Car\"> I have a car" );
			InputType i3 = new InputType("<input type=\"checkbox\" name=\"vehicle3\" value=\"Boat\" checked> I have a boat" );
			
			inputrepo.save(i);
			inputrepo.save(i2);
			inputrepo.save(i3);
		};
	
}}
