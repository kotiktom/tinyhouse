package com.tinyhouse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tinyhouse.controller.QuestionController;
import com.tinyhouse.model.Question;
import com.tinyhouse.repository.QuestionRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class TinyhouseApplicationTests {
	
	@Autowired
	private QuestionRepository questionRepository;
    private QuestionController questionController;

 
	@Test
    public void createQuestion() {
		Question newQuestion = new Question();
		newQuestion.setContent("Testi 1");
		
		questionRepository.save(newQuestion);
		
		Question q = questionRepository.getOne(newQuestion.getId());
		
    	assertThat(q.getId()).isNotNull();
    	assertThat(q.getContent().contentEquals("Testi "));
    }
	@Test
    public void testQuestionList() {
        List<Question> questions = questionRepository.findAll();
        
        assertThat(questions).hasSize(4);
        assertThat(questions.get(0).getContent()).isEqualTo("Koulutusohjelma: ");
    }
	
	@Test
    public void DeletingAllQuestions() {
		questionRepository.deleteAll();
        assertThat(questionRepository.count()).isEqualTo(0);
    }
 
	 @Test
	    public void contexLoads() throws Exception {
	        assertThat(questionController).isNull();
	    }

}
