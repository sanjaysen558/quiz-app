package com.example.demo.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class QuestionWrapper {

    private int id;
    private String option1;
    private String option2;
    private String option3;
    private String title;

    public QuestionWrapper(int id, String optionOne, String option2, String option3, String title) {
        this.id = id;
        this.option1 = optionOne;
        this.option2 = option2;
        this.option3 = option3;
        this.title = title;
    }
}
