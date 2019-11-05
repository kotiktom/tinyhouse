package com.tinyhouse.repository;

import java.util.ArrayList;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tinyhouse.model.InputType;
import com.tinyhouse.model.Question;

public interface InputTypeRepository extends JpaRepository<InputType, Long> {

}