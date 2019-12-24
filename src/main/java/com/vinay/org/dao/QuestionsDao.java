/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.dao;

import com.vinay.org.entity.Questions;
import com.vinay.org.entity.Student;
import com.vinay.org.entity.Subject;
import java.util.List;

/**
 *
 * @author vinay
 */
public interface QuestionsDao {
     public void Save(Questions question);
    public void Update(Questions question);
    public void Delete(Questions question);
    public void DeleteById(Integer id);
    public Questions FindById(Integer id);
    public List<Questions> FindAll();
    public List<Questions> selectBySubject(Subject sub);
    public double SumOfMarks(Subject sub);
    public List<Questions> selectNotIn(Subject sub, Student st);
}
