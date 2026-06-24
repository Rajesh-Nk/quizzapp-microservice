package com.rajesh.quizservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



public class Response {

	private int id;
	private String response;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Response(int id, String response) {
		this.id = id;
		this.response = response;
	}

	public Response() {
	}

	@Override
	public String toString() {
		return "Response{" +
				"id=" + id +
				", response='" + response + '\'' +
				'}';
	}
}
