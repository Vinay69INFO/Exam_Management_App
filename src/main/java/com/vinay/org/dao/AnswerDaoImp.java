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
import com.vinay.org.hibercfg.HibernateConfigration;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

/**
 *
 * @author vinay
 */
public class AnswerDaoImp implements AnswerDao {

    private Transaction transaction;

    @Override
    public Integer insert(Answer ans) {
        String hql="insert into Answer ";
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
           Integer pk=(Integer) session.save(ans);
            transaction.commit();
            System.out.println("insert completed successfully!");
            return pk;
        }
    }

    @Override
    public void upDate(Integer id, Answer answer) {
        //answer.setId(id);
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            session.merge(answer);
            transaction.commit();
        }
    }

    @Override
    public void delete(Integer id) {
        String hql = "delete Answer where ans_id=" + id + " ";
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query q = session.createQuery(hql);
            int i = q.executeUpdate();
            System.out.println("Delete successfully i===========" + i);
            transaction.commit();
            System.out.println("Subject Delete Successfully!");

        }
    }

    @Override
    public Answer selectAnswer(Integer id) {
        String hql = "from Options where ans_id=" + id + "";
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            Answer answer = (Answer) query.uniqueResult();

            return answer;
        }
    }

    @Override
    public List selectAllAnswers() {
        String hql = "from Answer";
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            List<Answer> answerList = query.list();

            return answerList;
        }
    }

    @Override
    public Answer serchByQuestion(Questions questions) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Answer.class);
            criteria.add(Restrictions.eq("questions", questions));
            Answer answer = (Answer) criteria.uniqueResult();
            return answer;
        }
    }

    @Override
    public List serchByStudent(Student student) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Answer.class);
            criteria.add(Restrictions.eq("student", student));
            List<Student> studentList = criteria.list();
            return studentList;
        }
    }

    @Override
    public List WrongOrRight(String WrongOrRight) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Answer.class);
            criteria.add(Restrictions.eq("WrongOrRight", WrongOrRight));
            List li = criteria.list();
            return li;
        }
    }

    @Override
    public List<Answer> WrongOrRight(String WrongOrRight, Student student, Subject sub) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Answer.class);
            criteria.add(Restrictions.eq("wrongOrRight", WrongOrRight));
            criteria.add(Restrictions.and(Restrictions.eq("student", student)));
            List<Answer> li = criteria.list();
            return li;
        }
    }

    @Override
    public List<Answer> serchByStudent$language(Student student, Subject sub) {
        String hql="from Answer where student ="+student+" and subjectId="+sub+"";
        System.out.println("hql------------------>"+hql);
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
//            Criteria criteria=session.createCriteria(Answer.class);
//            criteria.add(Restrictions.eq("student",student));
//            criteria.add(Restrictions.and(Restrictions.eq("subjectId",sub)));
            
            Query query=session.createQuery(hql);
            
           List<Answer> answerList = query.list();
            System.out.println("list==============>"+answerList.size());
            return answerList;
        }
    }

}
