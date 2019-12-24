/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.dao;

import com.vinay.org.entity.Student;
import java.util.List;

/**
 *
 * @author vinay
 */
public interface StudentDao {
    public void save(Student s);
    public void update(Student s);
    public Integer udDateBystuId(Integer id, Student st);
    public void delete(Student s);
    public void deleteById(Integer id);
    public List<Student> findByAll();
    public Student findById(Integer id);
    
}
