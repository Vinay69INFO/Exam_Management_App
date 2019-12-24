/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.dao;

import com.vinay.org.entity.StudentExamInfo;
import java.util.List;

/**
 *
 * @author vinay
 */
public interface StudentExamDao {
    public long save(com.vinay.org.entity.StudentExamInfo studentInfo);
    
    public List<StudentExamInfo> selectAllStudentExamInfo();
    
}
