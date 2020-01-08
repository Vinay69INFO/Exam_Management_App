/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.dao;

import com.vinay.org.entity.Answer;
import com.vinay.org.entity.Questions;
import com.vinay.org.entity.Student;
import com.vinay.org.entity.Subject;
import java.util.List;

/**
 *
 * @author vinay
 */
public interface AnswerDao {
    public Integer insert(Answer ans);
    public void upDate(Integer id, Answer answer);
    public void delete(Integer id);
    public Answer selectAnswer(Integer id);
    public List selectAllAnswers();
    public Answer serchByQuestion(Questions questions);

    public List serchByStudent(Student student);
    public List WrongOrRight(String WrongOrRight);
    public List WrongOrRight(String WrongOrRight, Student student, Subject sub);
    
    public List<Answer> serchByStudent$language(Student student, Subject sub);
    
            
}   
