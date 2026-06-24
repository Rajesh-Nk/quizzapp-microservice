package com.rajesh.questionservice.controller;


import com.rajesh.questionservice.entities.Question;
import com.rajesh.questionservice.entities.QuestionWrapper;
import com.rajesh.questionservice.entities.Response;
import com.rajesh.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/add")
	public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
		
		return questionService.addQuestion(question);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Question>> allQuestions() {
		return questionService.allQuestion();
	}
	
	@GetMapping("/findBy/{id}")
	public ResponseEntity<Question> findQuestionById(@PathVariable int id) {
		return questionService.findQuestionById(id);	
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Question> updateQuestion(@PathVariable int id,@RequestBody Question question){
		return questionService.updateQuestion(id,question);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAll(){
		return questionService.deleteAll();
	}
	@DeleteMapping("/deleteBy/{id}")
	public ResponseEntity<String> deleteQuestionById(@PathVariable int id) {
		return questionService.deleteQuestionById(id);	
	}

	//Generate quiz
	//get the quiz
	//calculate the score

	//1- Generate quiz
	@GetMapping("/generate")
	public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam int numQuestions){
		return questionService.getQuestionForQuiz(categoryName,numQuestions);
	}

	//2- get the quiz
	@PostMapping("/getQuiz")
	public ResponseEntity<List<QuestionWrapper>> getQuestionFromIds(@RequestBody List<Integer> questionsIds){
		return questionService.getQuestionFromIds(questionsIds);
	}

	//3-calculate the score
    @PostMapping("/score")
		public ResponseEntity<Integer> calculateScore(@RequestBody List<Response> response){

			return questionService.calculateScore(response);

		}

}
