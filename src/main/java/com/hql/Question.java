package com.hql;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question {

    @Id
    @Column(name = "question_id")
    private int questionId;

    private String question;


    //default FetchType is Lazy
    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Answer> answer;



    public Question(int questionId, String question, List<Answer> answer) {
        this.questionId = questionId;
        this.question = question;
        this.answer = answer;
    }

    public Question() {
        super();
    }

    public int getQuestionId() {
        return questionId;
    }
    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }


    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }



    public List<Answer> getAnswer(){
        return answer;
    }
    public void setAnswer(List<Answer> answer) {
        this.answer = answer;
    }




}
