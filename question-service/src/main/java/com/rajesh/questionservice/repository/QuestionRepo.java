package com.rajesh.questionservice.repository;


import com.rajesh.questionservice.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Integer> {

	public static final String createQuizQuery = "SELECT q.id FROM question q where q.type=:type ORDER BY RAND() LIMIT :numQ ";

	@Query(value=createQuizQuery,nativeQuery = true )
	List<Integer> findRandomQuestionBytype(String type,int numQ);

}
