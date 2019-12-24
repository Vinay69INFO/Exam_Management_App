/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.dao;

import com.vinay.org.entity.Student;
import com.vinay.org.entity.Subject;
import com.vinay.org.hibercfg.HibernateConfigration;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinay
 */
@Service
public class StudentDaoImp implements StudentDao {

    public static Transaction transaction;

    @Override
    public void save(Student s) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            System.out.println("imp method.............");
            session.save(s);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Student s) {
        String hql = "update Student set name='" + s.getName() + "', contact=" + s.getContact() + ", address='" + s.getAddress() + "',"
                + "fees=" + s.getFees() + ",admission_datecourse='" + s.getAdmission_datecourse() + "' ,course='" + s.getCourse() + "' where id=" + s.getId() + " ";
        System.out.println("helo " + hql);
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query q = session.createQuery(hql);
            int i = q.executeUpdate();
            System.out.println("Update successfully i===========" + i);
            transaction.commit();
        }
    }

    @Override
    public Integer udDateBystuId(Integer id, Student st) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            try{
            session.update(st);
            System.out.println("Update successfully i=***************8*==========" + id);
            }catch(Exception e){
                System.out.println("exception session--------------------->"+e);
                return -1;
            }
            transaction.commit();
            return id;
        }
    }

    @Override
    public void delete(Student s) {
        this.deleteById(s.getId());
    }

    @Override
    public void deleteById(Integer id) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            String hql = "delete Student where id=" + id + " ";
            Query q = session.createQuery(hql);
            int i = q.executeUpdate();
            System.out.println("update Successfully====" + i);
        }
    }

    @Override
    public List<Student> findByAll() {
        List<Student> list = new ArrayList<Student>();
        String hql = "from Student";

        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
//            Student student=session.get(Student.class, 1);
//            list.add(student);
            Query q = session.createQuery(hql);
            List<Student> stuList = q.list();
            for (Student stu : stuList) {
                Student student = new Student();
                student.setId(stu.getId());
                student.setName(stu.getName());
                student.setContact(stu.getContact());
                student.setAddress(stu.getAddress());
                student.setFees(stu.getFees());
                student.setAdmission_datecourse(stu.getAdmission_datecourse());
                student.setCourse(stu.getCourse());
                student.setEmail(stu.getEmail());
                student.setUsername(stu.getUsername());
                student.setPassword(stu.getPassword());
                student.setSubjectList(stu.getSubjectList());
                list.add(student);
            }
            return list;
        }
    }

    @Override
    public Student findById(Integer id) {
        String hql = "from Student where id=" + id + "";
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Query q = session.createQuery(hql);
            Student student = (Student) q.uniqueResult();

            System.out.println("Student findById successfully Completed!");
            return student;
        }
    }

}
