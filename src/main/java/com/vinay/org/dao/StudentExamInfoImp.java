/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.dao;

import com.vinay.org.entity.StudentExamInfo;
import com.vinay.org.hibercfg.HibernateConfigration;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author vinay
 */
public class StudentExamInfoImp implements StudentExamDao{

    private Transaction transaction;

    @Override
    public long save(StudentExamInfo studentInfo) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            transaction=session.beginTransaction();
            long l=(long) session.save(studentInfo);
            transaction.commit();
            return l;
        }
    }

    @Override
    public List<StudentExamInfo> selectAllStudentExamInfo() {
        String hql= "from StudentExamInfo";
        try(Session session=HibernateConfigration.getSessionFactory().openSession()){
            Query query=session.createQuery(hql);
            List<StudentExamInfo> infoList=query.list();
            return infoList;
        }
    }

        
}
