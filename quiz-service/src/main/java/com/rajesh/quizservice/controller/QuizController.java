package com.rajesh.quizservice.controller;


import com.rajesh.quizservice.entities.QuestionWrapper;
import com.rajesh.quizservice.entities.QuizDto;
import com.rajesh.quizservice.entities.Response;
import com.rajesh.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	@Autowired
	QuizService quizService;

	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {
		return quizService.createQuiz(quizDto.getTitle(),quizDto.getQuizCategory(),quizDto.getNumQuestions());
		}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable int id){
		return quizService.getQuizQuestion(id);
	}
	
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable int id,@RequestBody List<Response> responses){
		
		return quizService.countScore(id,responses);
		
	}
}
