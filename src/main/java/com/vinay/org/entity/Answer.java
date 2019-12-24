/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author vinay
 */

@Entity
@Table(name="answer")
public class Answer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ans_id;
    private String wrongOrRight;
    private String answer_Text;
    private String answer_date;
    
    @OneToOne //(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Questions.class)
    private Questions questions;
    @ManyToOne(cascade = CascadeType.PERSIST) //(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Student.class)
    private Student student;
    @ManyToOne(cascade = CascadeType.PERSIST) //(fetch = FetchType.EAGER, cascade = CascadeType.ALL,targetEntity = Subject.class)
    private Subject subjectId;

    public Answer() {
    }

    public Integer getAns_id() {
        return ans_id;
    }

    public void setAns_id(Integer ans_id) {
        this.ans_id = ans_id;
    }

    public String getWrongOrRight() {
        return wrongOrRight;
    }

    public void setWrongOrRight(String wrongOrRight) {
        this.wrongOrRight = wrongOrRight;
    }

    public String getAnswer_Text() {
        return answer_Text;
    }

    public void setAnswer_Text(String answer_Text) {
        this.answer_Text = answer_Text;
    }

    public String getAnswer_date() {
        return answer_date;
    }

    public void setAnswer_date(String answer_date) {
        this.answer_date = answer_date;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Subject subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Answer{" + "id=" + ans_id + ", WrongOrRight=" + wrongOrRight + ", answer_Text=" + answer_Text + ", answer_date=" + answer_date + ", questions=" + questions + ", student=" + student + ", subjectId=" + subjectId + '}';
    }
    
    
}
