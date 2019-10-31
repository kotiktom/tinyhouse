package com.tinyhouse.model;

import java.util.ArrayList;
import java.util.List;

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

	private ArrayList<String> content;
	@ManyToOne
	private Survey survey;
	
	/* TODO
	private int priority;
	private boolean mandatory;
	*/
	private ArrayList<String> answers;
	
	
	
}

