package com.onetomany.entity;

import java.util.List;

public class QuestionRequest {
    private Question question;
    private List<Answer> answers;

    // Getters and setters
    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
}

