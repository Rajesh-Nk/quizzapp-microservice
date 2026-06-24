package com.rajesh.quizservice.service;


import com.rajesh.quizservice.entities.QuestionWrapper;
import com.rajesh.quizservice.entities.Quiz;
import com.rajesh.quizservice.entities.Response;
import com.rajesh.quizservice.feign.QuizInterface;
import com.rajesh.quizservice.repository.QuizRepo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class QuizService {

	@Autowired
	QuizRepo quizRepo;

	@Autowired
	QuizInterface quizInterface;


	public ResponseEntity<String> createQuiz(String title, String quizCategory, int numQuestions) {

		//List<Integer> questions= //call the generate url - Rest Template http://localhost:8080/question/generate
		List<Integer> questions=quizInterface.getQuestionForQuiz(quizCategory,numQuestions).getBody();
		Quiz quiz=new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizRepo.save(quiz);

		return new ResponseEntity<String>("Sucess", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(int id) {
		Quiz quiz = quizRepo.findById(id).get();
		List<Integer> questionIds = quiz.getQuestionIds();
		ResponseEntity<List<QuestionWrapper>> question = quizInterface.getQuestionFromIds(questionIds);

		return question;
	}

	public ResponseEntity<Integer> countScore(int id, List<Response> responses) {

		ResponseEntity<Integer> score = quizInterface.calculateScore(responses);
		return score;
	}

}
