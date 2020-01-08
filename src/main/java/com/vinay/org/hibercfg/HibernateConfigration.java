/*
    * Server Url: jdbc:mysql://node29536-exammanagement.cloudjiffy.net/exammanagement
    * User Name: root
    * Password:  ODYoea01858
*/

package com.vinay.org.hibercfg;

import com.vinay.org.entity.Answer;
import com.vinay.org.entity.Options;
import com.vinay.org.entity.Questions;
import com.vinay.org.entity.Student;
import com.vinay.org.entity.StudentExamInfo;
import com.vinay.org.entity.Subject;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;


@Repository
public class HibernateConfigration {

    private static SessionFactory sessionFactory;

    static {
        if (sessionFactory == null) {
            try {
                Configuration cfg = new Configuration();
                Properties setting = new Properties();
                setting.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                setting.put(Environment.URL, "jdbc:mysql://localhost:3306/exammanagement");
                setting.put(Environment.USER, "root");
                setting.put(Environment.PASS, "mysql");
                setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                setting.put(Environment.HBM2DDL_AUTO, "update");
                setting.put(Environment.SHOW_SQL, "true");

                cfg.setProperties(setting);

                // add jpa entity mapping class
                cfg.addAnnotatedClass(StudentExamInfo.class);
                cfg.addAnnotatedClass(Answer.class);
                cfg.addAnnotatedClass(Options.class);
                cfg.addAnnotatedClass(Questions.class);
                cfg.addAnnotatedClass(Subject.class);
                cfg.addAnnotatedClass(Student.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(cfg.getProperties()).build();
                sessionFactory = cfg.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                System.out.println(e);
            }
        } else{
            System.out.println("session is not created!");
        }

    }
    
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
}
