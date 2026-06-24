package com.rajesh.quizservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;

	private String title;

	@ElementCollection
	private List<Integer> questionIds;

	public Quiz(int id, String title, List<Integer> questionIds) {
		this.id = id;
		this.title = title;
		this.questionIds = questionIds;
	}

	public Quiz() {
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public List<Integer> getQuestionIds() {
		return questionIds;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setQuestionIds(List<Integer> questionIds) {
		this.questionIds = questionIds;
	}
}
