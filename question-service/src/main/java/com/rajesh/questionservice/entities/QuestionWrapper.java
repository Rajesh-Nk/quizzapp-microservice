package com.rajesh.questionservice.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class QuestionWrapper {

	private int id;
	private String question;
	private String option_A;
	private String option_B;
	private String option_C;
	private String option_D;


}
