package com.tinyhouse.repository;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tinyhouse.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	

	
}