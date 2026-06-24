package com.rajesh.quizservice.entities;

import lombok.*;


public class QuestionWrapper {

	private int id;
	private String question;
	private String option_A;
	private String option_B;
	private String option_C;
	private String option_D;

	public int getId() {
		return id;
	}

	public String getOption_D() {
		return option_D;
	}

	public String getOption_C() {
		return option_C;
	}

	public String getOption_B() {
		return option_B;
	}

	public String getOption_A() {
		return option_A;
	}

	public String getQuestion() {
		return question;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public void setOption_A(String option_A) {
		this.option_A = option_A;
	}

	public void setOption_B(String option_B) {
		this.option_B = option_B;
	}

	public void setOption_C(String option_C) {
		this.option_C = option_C;
	}

	public void setOption_D(String option_D) {
		this.option_D = option_D;
	}

	public QuestionWrapper(String option_D, String option_C, String option_B, String option_A, String question, int id) {
		this.option_D = option_D;
		this.option_C = option_C;
		this.option_B = option_B;
		this.option_A = option_A;
		this.question = question;
		this.id = id;
	}

	public QuestionWrapper() {
	}
}
