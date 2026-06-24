package com.rajesh.questionservice.service;


import com.rajesh.questionservice.entities.Question;
import com.rajesh.questionservice.entities.QuestionWrapper;
import com.rajesh.questionservice.entities.Response;
import com.rajesh.questionservice.repository.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepo questionRepo;

	//Used to check in which instance it used
	@Autowired
	Environment environment;

	// Method to add question
	public ResponseEntity<Question> addQuestion(Question question) {
		try {
			return new ResponseEntity<>(questionRepo.save(question), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new Question(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	// Method to get all questions from database

	public ResponseEntity<List<Question>> allQuestion() {
		try {
			return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
	}

	// Service method to get question by id

	public ResponseEntity<Question> findQuestionById(int id) {
		try {
			return new ResponseEntity<>(questionRepo.findById(id).get(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new ResponseEntity<>(new Question(), HttpStatus.BAD_REQUEST);
	}

	// Service Method to delete all Question from database

	public ResponseEntity<String> deleteAll() {
		try {
			questionRepo.deleteAll();
			return new ResponseEntity<>("All data Deleted Successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Something went wrong, Please try again!", HttpStatus.BAD_REQUEST);
	}

	// Service Method for delete Question By ID

	public ResponseEntity<String> deleteQuestionById(int id) {
		try {
			questionRepo.deleteById(id);
			return new ResponseEntity<>(id + "Deleted successfully", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Something went wrong, Please try again!", HttpStatus.BAD_REQUEST);
	}

	
	//Service Method to update Question
	public ResponseEntity<Question> updateQuestion(int id,Question question) {
		try {
		Question updatedQ = questionRepo.findById(id).map(q ->{
			q.setQuestion(question.getQuestion());
			q.setDifficultyLevel(question.getDifficultyLevel());
			q.setOption_A(question.getOption_A());
			q.setOption_B(question.getOption_B());
			q.setOption_C(question.getOption_C());
			q.setOption_D(q.getOption_D());
			return q;
		}).get();
		
		return new ResponseEntity<>(questionRepo.save(updatedQ),HttpStatus.CREATED);}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new Question(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Integer>> getQuestionForQuiz(String categoryName, int numQuestions) {
		List<Integer> questions = questionRepo.findRandomQuestionBytype(categoryName,numQuestions);
		return new ResponseEntity<>(questions,HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionFromIds(List<Integer> questionsIds) {
		List<QuestionWrapper> wrappers=new ArrayList<>();
		System.out.println(environment.getProperty("local.server.port"));
		List<Question> questions=new ArrayList<>();

		//fetching questions from questionIds and store it on questions List
		for (Integer id:questionsIds){
			questions.add(questionRepo.findById(id).get());
		}

		for (Question question:questions){
			QuestionWrapper wrapper=new QuestionWrapper();
			wrapper.setId(question.getId());
			wrapper.setQuestion(question.getQuestion());
			wrapper.setOption_A(question.getOption_A());
			wrapper.setOption_B(question.getOption_B());
			wrapper.setOption_C(question.getOption_C());
			wrapper.setOption_D(question.getOption_D());

			wrappers.add(wrapper);
		}

		return new ResponseEntity<>(wrappers,HttpStatus.CREATED);
	}

	public ResponseEntity<Integer> calculateScore(List<Response> response) {
		int score=0;
		for(Response res:response){
			//Check weather response is matching to right_answer or not
			if (res.getResponse().equals(questionRepo.findById(res.getId()).get().getRightAnswer())) {
				score++;
            }
		}

		return new ResponseEntity<>(score,HttpStatus.OK);
	}
}
