package com.tinyhouse.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Question extends AbstractPersistable<Long> {

	private String content;
	
	@OneToMany(mappedBy = "question")
	private List<QuestionOption> questionOptions;

	private InputType inputType = InputType.TEXTFIELD;

	@JsonIgnore
	@ManyToOne
	private Survey survey;

	@JsonIgnore
	@OneToMany(mappedBy = "question")
	private List<Answer> answers;
	
	public Question(String content) {
		this.content = content;
		answers = new ArrayList<>();
	}
	
	public void setInputType(String ipType) {

		switch (ipType) {
		case "TEXTFIELD":
			inputType = InputType.TEXTFIELD;
			break;
		case "RADIO":
			inputType = InputType.RADIO;
			break;
		case "DROPDOWN":
			inputType = InputType.DROPDOWN;
			break;
		case "CHECKBOX":
			inputType = InputType.CHECKBOX;
			break;
		default:
			break;
		}
		
	}
	
	
}
