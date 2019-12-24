package com.vinay.org.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "questions")
public class Questions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer que_id;
   
    private Integer que_marks;
    private String que_type;
    private String que_text;
    private String answer_text;
    
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Subject.class)
    private Subject subject_name;
    

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "question_option", joinColumns = @JoinColumn(name = "Que_id"), inverseJoinColumns = @JoinColumn(name = "option_id"))
//    private Set<Options> options=new HashSet<Options>();

    public Questions() {
    }

    public Integer getQue_id() {
        return que_id;
    }

    public void setQue_id(Integer que_id) {
        this.que_id = que_id;
    }

    public Integer getQue_marks() {
        return que_marks;
    }

    public void setQue_marks(Integer que_marks) {
        this.que_marks = que_marks;
    }

    public String getQue_type() {
        return que_type;
    }

    public void setQue_type(String que_type) {
        this.que_type = que_type;
    }

    public String getQue_text() {
        return que_text;
    }

    public void setQue_text(String que_text) {
        this.que_text = que_text;
    }

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }

    public Subject getSubject_name() {
        return subject_name;
    }

    public void setSubject_name(Subject subject_name) {
        this.subject_name = subject_name;
    }

    @Override
    public String toString() {
        return "Questions{" + "que_id=" + que_id + ", que_marks=" + que_marks + ", que_type=" + que_type + ", que_text=" + que_text + ", answer_text=" + answer_text + ", subject_name=" + subject_name + '}';
    }

    
}
