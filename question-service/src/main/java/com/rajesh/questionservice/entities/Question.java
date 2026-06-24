package com.rajesh.questionservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@ToString
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String question;
	private String option_A;
	private String option_B;
	private String option_C;
	private String option_D;
	private String rightAnswer;
	private String type;
	private String difficultyLevel;



}
