/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.testing;

import com.vinay.org.dao.StudentDao;
import com.vinay.org.dao.StudentDaoImp;
import com.vinay.org.dao.SubjectDaoImp;
import com.vinay.org.entity.Student;
import com.vinay.org.hibercfg.HibernateConfigration;
import java.util.List;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vinay
 */
@Controller
@ComponentScan("com.vinay.org")
public class StudentTesting {

    private static StudentDao studentDao;
    private static SubjectDaoImp subjectDaoImp;

    @RequestMapping("/h")
    public String home() {
        return "home";
    }

    @RequestMapping("/saveStudenttt")
    public String saveStudenttt(Model m) {
        subjectDaoImp=new SubjectDaoImp();
        Student student = new Student();
        student.setName("Ankit");
        student.setContact("94834843");
        student.setAddress("katni");
        student.setFees(453.5);
        student.setAdmission_datecourse("7/9/2019");
        student.setCourse("math");
        student.setEmail("ankit.vin@gmail");
        student.setUsername("ankit");
        student.setPassword("a123");
        student.getSubjectList().add(subjectDaoImp.FindById(1));
        student.getSubjectList().add(subjectDaoImp.FindById(2));
        student.getSubjectList().add(subjectDaoImp.FindById(3));
        studentDao= new StudentDaoImp();
        studentDao.save(student);
        System.out.println("hello vinay");
        m.addAttribute("message", "Message Save Successfully!");
        return "home";
    }

    @RequestMapping("/updateStudentt")
    public String upDatett(Model m){
        Student student = new Student();
        student.setId(1);
        student.setName("na");
        student.setContact("94834843");
        student.setAddress("nagar");
        student.setFees(453.5);
        student.setAdmission_datecourse("7/9/2019");
        student.setCourse("math");
        student.setEmail("tiwari.vin@gmail");
        student.setUsername("na");
        student.setPassword("v123");
        studentDao= new StudentDaoImp();
        studentDao.update(student);
        m.addAttribute("message", "Message update Successfully!");
        return "home";
    }
    
    @RequestMapping("/findByAllStudenttt")
    public String findByAlltt(Model m){
        studentDao= new StudentDaoImp();
        List<Student> student= studentDao.findByAll();
        System.out.println("FindAll student============="+student);
        m.addAttribute("message", "Message findbyAll Successfully!");
        return "home";
    }
    
    @RequestMapping("/findByIdStudenttt")
    public String findByIdtt(Model m){
        studentDao= new StudentDaoImp();
        Student student=studentDao.findById(1);
        System.out.println("student findById========="+student);
        m.addAttribute("message", "Message FindById Successfully!");
        return "home";
    }
    
    @RequestMapping("/savett")
    public String savett() {
        try (Session session = HibernateConfigration.getSessionFactory().openSession()) {
            Student student = new Student();
            student.setName("vinay");
            student.setContact("94834843");
            student.setAddress("Maruti nagar");
            student.setFees(453.5);
            student.setAdmission_datecourse("7/9/2019");
            student.setCourse("math");
            student.setEmail("tiwari.vin@gmail");
            student.setUsername("vinay");
            student.setPassword("v123");
            System.out.println(student);

            session.save(student);
            System.out.println("User registration successfully!");

            return "home";
        }
    }
}
