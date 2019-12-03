package com.tinyhouse.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tinyhouse.model.Question;
import com.tinyhouse.model.QuestionOption;

public interface QuestionOptionRepository extends JpaRepository<QuestionOption, Long> {
	
}