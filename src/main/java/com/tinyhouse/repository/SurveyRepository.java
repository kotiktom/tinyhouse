package com.tinyhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tinyhouse.model.Survey;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

	@Query(
	value = "SELECT TOP 1 questionAmount FROM Survey ORDER BY ID DESC", nativeQuery = true)
	String FindLastRecordSurvey();
	
}