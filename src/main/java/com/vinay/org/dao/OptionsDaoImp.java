/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.dao;

import com.vinay.org.entity.Options;
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

/**
 *
 * @author vinay
 */
public class OptionsDaoImp implements OptionsDao {

    private Transaction transaction;

    @Override
    public void Save(Options option) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(option);
            transaction.commit();
            System.out.println("Options save Successfully!");
        }
    }

    @Override
    public void Update(Options option) {
        String hql = "update Options set option1='"+option.getOption1()+"', option2='"+option.getOption2()+"', option3='"+option.getOption3()+"',"
                + "option4='"+option.getOption4()+"' where option_id="+option.getOption_id()+" ";
        System.out.println("helo------> " + hql);
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            int i = query.executeUpdate();
            System.out.println("Update successfully i===========" + i);
            transaction.commit();
        }
    }

    @Override
    public void Delete(Options option) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Options FindById(Integer id) {
        String hql = "from Options where question_id=" + id + " ";
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Query q = session.createQuery(hql);
            Options option = (Options) q.uniqueResult();
            System.out.println("Options FindById Successfully!");
            return option;
        }
    }

    @Override
    public List<Options> FindAll() {
        String hql = "from Options";
        List<Options> optionsList = new ArrayList<Options>();
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Query q = session.createQuery(hql);
            List<Options> optionList = q.list();
            for (Options option : optionList) {
                Options optiones = new Options();
                optiones.setOption_id(option.getOption_id());
                optiones.setQuestion_id(option.getQuestion_id());
                optiones.setOption1(option.getOption1());
                optiones.setOption2(option.getOption2());
                optiones.setOption3(option.getOption3());
                optiones.setOption4(option.getOption4());
                optionsList.add(option);
            }
            return optionsList;
        }
    }

    @Override
    public List<Options> findByQuestion(Questions question) {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Criteria criteria = session.createCriteria(Options.class);
            criteria.add(Restrictions.eq("question_id", question));
            List<Options> Optionslist = criteria.list();

            return Optionslist;
        }
    }

}
