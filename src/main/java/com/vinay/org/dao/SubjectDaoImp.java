package com.vinay.org.dao;

import com.vinay.org.entity.Questions;
import com.vinay.org.entity.Subject;
import com.vinay.org.hibercfg.HibernateConfigration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

@Service
public class SubjectDaoImp implements SubjectDao {

    private Transaction transaction;

    @Override
    public void Save(Subject sub) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(sub);
            transaction.commit();
            System.out.println("Subject save Successfully!");
        }
    }

    @Override
    public void Update(Subject sub) {
        String hql = "update Subject Set sub_name='" + sub.getSub_name() + "', "
                + "max_marks=" + sub.getMax_marks() + ", "
                + "Passing_marks=" + sub.getPassing_marks() + ", "
                + "total_questions=" + sub.getTotal_questions() + ", "
                + "duration=" + sub.getDuration() + ", "
                + "fees=" + sub.getFees() + ", "
                + "offer=" + sub.getOffer() + " where sub_id=" + sub.getSub_id() + " ";
        System.out.println("hql for subject--------------->"+hql);
        
        System.out.println("sql============" + hql);
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query q = session.createQuery(hql);
            int i = q.executeUpdate();
            transaction.commit();
            System.out.println("Subject Update Successfully!");
        }
    }

    @Override
    public void Delete(Subject sub) {
        this.DeleteById(sub.getSub_id());
    }

    @Override
    public void DeleteById(Integer id) {
        String hql = "delete Subject where sub_id=" + id + " ";
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
    public Subject FindById(Integer id) {
        String hql = "from Subject where sub_id=" + id + " ";
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!"+hql);
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Query q = session.createQuery(hql);
            Subject subject = (Subject) q.uniqueResult();
            
            System.out.println("Subject FindById Successfully!"+subject);
            return subject;
        }
    }

    @Override
    public List<Subject> FindAll() {
        String hql = "from Subject";
        List<Subject> subjectList = new ArrayList<Subject>();
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Query q = session.createQuery(hql);
            List<Subject> subList = q.list();
            for (Subject subject : subList) {
                Subject subjec = new Subject();
                subjec.setSub_id(subject.getSub_id());
                subjec.setSub_name(subject.getSub_name());
                subjec.setMax_marks(subject.getMax_marks());
                subjec.setPassing_marks(subject.getPassing_marks());
                subjec.setTotal_questions(subject.getTotal_questions());
                subjec.setDuration(subject.getDuration());
                subjec.setFees(subject.getFees());
                subjec.setOffer(subject.getOffer());
                subjectList.add(subjec);
            }
            return subjectList;
        }
    }

    public List<Questions> findBySubject(Subject subject) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Questions.class);
            criteria.add(Restrictions.eq("subject_name", subject));
            List<Questions> questionlist=criteria.list();
            
            return questionlist;
        }   
    }

}
