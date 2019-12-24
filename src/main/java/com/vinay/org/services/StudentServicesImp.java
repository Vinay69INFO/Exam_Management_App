/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.services;

import com.vinay.org.entity.Student;
import com.vinay.org.exception.InvalidPasswordException;
import com.vinay.org.hibercfg.HibernateConfigration;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinay
 */
@Service
public class StudentServicesImp implements StudentServices{

    @Override
    public Student login(String username, String password) throws InvalidPasswordException {
        String hql="from Student where username='"+username+"'";
        try(Session session=HibernateConfigration.getSessionFactory().openSession()){
            Query query=session.createQuery(hql);
            Student student=(Student)query.uniqueResult();
            if(student.getUsername().equals(username) && student.getPassword().equals(password)){
                System.out.println("hello vinay=========="+student);
                return student;
            }
            else{
                throw new InvalidPasswordException("Invalid Password!");
            }
        }catch(NullPointerException ex){
            return null;
        }
    }
    
}
