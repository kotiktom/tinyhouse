package com.tinyhouse.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question extends AbstractPersistable<Long> {

	private String content;
	@ManyToOne
	private Questionnaire questionnaire;
	
	//private List<Answer> answers;
	
	     
}

