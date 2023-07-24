package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "qna")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int questionID;

    private String category;
    private String level;
    private String option1;
    private String option2;
    private String option3;
    private String title;
    private String answer;
}
