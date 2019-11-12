package com.tinyhouse.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
	
	@Column(length = 8000)
	private ArrayList<String> questions;
	@Column(length = 8000)
	private ArrayList<String> inputTypes;

	/* TODO
	private int priority;
	private boolean mandatory;
	*/
	
	private ArrayList<String> answers;
	@ManyToOne
	@JoinColumn(name = "survey")
	private Survey survey;
}
