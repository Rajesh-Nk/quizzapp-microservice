package com.rajesh.quizservice.entities;




public class QuizDto {

    private String title;
    private String quizCategory;
    private  int numQuestions;

    public String getTitle() {
        return title;
    }

    public String getQuizCategory() {
        return quizCategory;
    }

    public int getNumQuestions() {
        return numQuestions;
    }

    public void setQuizCategory(String quizCategory) {
        this.quizCategory = quizCategory;
    }

    public void setNumQuestions(int numQuestions) {
        this.numQuestions = numQuestions;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
