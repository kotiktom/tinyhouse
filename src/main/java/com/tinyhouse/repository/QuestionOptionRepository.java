package com.tinyhouse.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tinyhouse.model.Question;

public interface QuestionOptionRepository extends JpaRepository<Question, Long> {


	

	
}