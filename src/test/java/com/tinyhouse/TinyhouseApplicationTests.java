package com.tinyhouse;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tinyhouse.model.Question;
import com.tinyhouse.repository.QuestionRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TinyhouseApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
 
	@Test
    public void createQuestion() {
		Question newQuestion = new Question();
		newQuestion.setQuestion("Testi 1");
		
		questionRepository.save(newQuestion);
		
		Question q = questionRepository.getOne(newQuestion.getId());
		
    	assertThat(q.getId()).isNotNull();
    	assertThat(q.getQuestion().contentEquals("Testi "));
    }
 

}