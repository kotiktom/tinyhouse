package com.tinyhouse.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Survey extends AbstractPersistable<Long> {
	
	private String topic;
	@Column(name = "QUESTIONAMOUNT")
	private int questionAmount;
	
	@OneToMany(mappedBy = "survey")
	@JsonIgnore
	private List<Question> questions;	     
}

