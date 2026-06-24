package com.rajesh.quizservice.feign;

import com.rajesh.quizservice.entities.QuestionWrapper;
import com.rajesh.quizservice.entities.Response;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
    //1- Generate quiz
    @GetMapping("/question/generate")
    public ResponseEntity<List<Integer>> getQuestionForQuiz(@RequestParam String categoryName, @RequestParam int numQuestions);

    //2- get the quiz
    @PostMapping("/question/getQuiz")
    public ResponseEntity<List<QuestionWrapper>> getQuestionFromIds(@RequestBody List<Integer> questionsIds);
    //3-calculate the score
    @PostMapping("/question/score")
    public ResponseEntity<Integer> calculateScore(@RequestBody List<Response> response);
}
