package com.example.demo.services;

import com.example.demo.dao.QuestionsDao;
import com.example.demo.dao.QuizDao;
import com.example.demo.model.QuestionWrapper;
import com.example.demo.model.Questions;
import com.example.demo.model.Quiz;
import com.example.demo.model.QuizResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionsDao questionsDao;
    public ResponseEntity<String> createQuiz(String category,Integer numQ,String label){
        List<Questions> questions = questionsDao.findRandomQueByCategory(category,numQ);

        System.out.println("rows-fetched:"+questions.size());
        Quiz quiz = new Quiz();
        quiz.setTitle(label);
        quiz.setQuestions(questions);
        quizDao.save(quiz);

        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public ResponseEntity<QuestionWrapper> getQuiz(Integer id) {
        Quiz quiz = quizDao.findById(id).orElse(new Quiz());

        List<Questions> questionsFromDB = quiz.getQuestions();

        List<QuestionWrapper> questionWrapper = new ArrayList<>();
        for(Questions q:questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getQuestionID(),q.getOption1(),q.getOption2(),q.getOption3(),q.getTitle());
            questionWrapper.add(qw);
        }

        return new ResponseEntity(questionWrapper,HttpStatus.OK);
    }

    public ResponseEntity<String> submitQuiz(Integer id,List<QuizResponse> quizResponses) {
        Quiz quiz = quizDao.findById(id).orElse(new Quiz());
        List<Questions> questions = quiz.getQuestions();

        int right = 0;
        for(QuizResponse quizResponse:quizResponses){
            int responseQuid = quizResponse.getId();

            Questions correspondingQue = null;
            for(Questions q:questions){
                if(q.getQuestionID()==responseQuid){
                    System.out.println("found:"+q.getQuestionID());
                    correspondingQue = q;
                    if(correspondingQue.getAnswer().equals(quizResponse.response)) {
                        right++;
                    }
                    break;
                }
            }
        }
        return new ResponseEntity("correct answers are:"+right,HttpStatus.OK);
    }
}
