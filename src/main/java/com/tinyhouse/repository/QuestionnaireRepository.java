package com.tinyhouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tinyhouse.model.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {

}