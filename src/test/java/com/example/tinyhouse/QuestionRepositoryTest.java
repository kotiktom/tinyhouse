package com.example.tinyhouse;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tinyhouse.model.Question;
import com.tinyhouse.repository.QuestionRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionRepositoryTest {

	@Autowired
	private QuestionRepository repository;

	@Test
	public void findQuestion() {
		
		
	}

}
