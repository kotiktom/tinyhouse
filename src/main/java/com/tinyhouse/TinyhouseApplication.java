package com.tinyhouse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tinyhouse.model.Answer;
import com.tinyhouse.model.InputType;
import com.tinyhouse.model.Question;
import com.tinyhouse.repository.QuestionRepository;
import com.tinyhouse.service.AnswerService;

@SpringBootApplication
public class TinyhouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyhouseApplication.class, args);
	}

	
	
	@Bean
	public CommandLineRunner tinyhouseRunner(QuestionRepository questionrepo, AnswerService answerService) {
		return (args) -> {

			Question q1 = new Question("Opiskeluvuosi: ");
			Question q2 = new Question("Mitä teet vapaa-ajallasi: ");
			Question q3 = new Question("Vapaa-aikaa on mielestäni riittävästi: ");
			q2.setInputtype(InputType.RADIO);


			// Question q1 = new Question("Koulutusohjelma: ", i1, null, vastaukset);

			// questionrepo.save(q1);
			questionrepo.save(q1);
			questionrepo.save(q2);
			questionrepo.save(q3);
			
			answerService.saveAnswer(q1.getId(), "Vastaus 1");

			/*
			 * InputType i = new
			 * InputType("<h4>Text: <input type=\"text\"value=\"input\"/></h4>", "Text");
			 * InputType i2 = new
			 * InputType("<h4>Checkbox: <input type=\"checkbox\" value=\"input\"/><h4>",
			 * "Checkbox"); InputType i3 = new
			 * InputType("<h4>Radio: <input type=\"radio\" value=\"input\"/><h4>", "Radio");
			 * InputType i4 = new
			 * InputType("<h4><input id=\"save\" type=\"submit\" value=\"Submit\"/>",
			 * "Submit");
			 * 
			 * inputrepo.save(i); inputrepo.save(i2); inputrepo.save(i3);
			 * inputrepo.save(i4);
			 */
		};

	}
}
