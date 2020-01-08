/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.dao;

import static com.vinay.org.dao.StudentDaoImp.transaction;
import com.vinay.org.entity.Answer;
import com.vinay.org.entity.Questions;
import com.vinay.org.entity.Student;
import com.vinay.org.entity.Subject;
import com.vinay.org.hibercfg.HibernateConfigration;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

/**
 *
 * @author vinay
 */
@Service
public class QuestionsDaoImp implements QuestionsDao {

    private Transaction transaction;

    @Override
    public void Save(Questions question) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(question);
            transaction.commit();
            System.out.println("question save Successfully!");
        }
    }

    @Override
    public void Update(Questions q) {
        String hql="update Student set que_marks="+q.getQue_marks()+", que_text='"+q.getQue_text()+"', que_type='"+q.getQue_type()+"',"
                + "answer_text='"+q.getAnswer_text()+"' where id="+q.getQue_id()+" ";
        System.out.println("helo------> "+hql);
        try(Session session=HibernateConfigration.getSessionFactory().openSession()){
           transaction=session.beginTransaction();
            Query query=session.createQuery(hql);
            int i=query.executeUpdate();
            System.out.println("Update successfully i==========="+i);
            transaction.commit();
        }
    }

    @Override
    public void Delete(Questions question) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Questions FindById(Integer qid) {
        String hql = "from Questions where que_id=" + qid + " ";
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Query q = session.createQuery(hql);
            Questions questions = (Questions) q.uniqueResult();
            System.out.println("questions FindById Successfully!");
            return questions;
        }
    }

    @Override
    public List<Questions> FindAll() {
        String hql = "from Questions";
        List<Questions> questionList = new ArrayList<Questions>();
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Query q = session.createQuery(hql);
            List<Questions> questionsList = q.list();
            for (Questions quest : questionsList) {
                Questions question = new Questions();
                question.setQue_id(quest.getQue_id());
                question.setSubject_name(quest.getSubject_name());
                question.setQue_marks(quest.getQue_marks());
                question.setQue_type(quest.getQue_type());
                question.setQue_text(quest.getQue_text());
                question.setAnswer_text(quest.getAnswer_text());

                questionList.add(question);
            }
            return questionList;
        }

    }

    @Override
    public List<Questions> selectNotIn(Subject sub, Student st) {
        String hql = "from Questions where que_id not in (select questions from Answer where student=" + st.getId() + " and subjectId=" + sub.getSub_id() + ") and subject_name=" + sub.getSub_id() + "";
        System.out.println("hql======>"+hql);
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            List<Questions> questionList = query.list();

            return questionList;
        }
    }

    @Override
    public double SumOfMarks(Subject sub) {
        String hql = "select sum(que_marks) from Questions where subject_name=" + sub.getSub_id() + "";
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Query query = session.createQuery(hql);
            long total_marks = (Long) query.uniqueResult();
            return total_marks;
        }
    }

    @Override
    public List<Questions> selectBySubject(Subject sub) {

        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Questions.class);
            criteria.add(Restrictions.eq("subject_name", sub));
            List<Questions> questionsList = criteria.list();
            return questionsList;
        }
    }
}
