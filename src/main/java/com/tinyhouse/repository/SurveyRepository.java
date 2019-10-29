package com.tinyhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tinyhouse.model.Question;
import com.tinyhouse.model.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

	Survey findByName(String name);
	
}