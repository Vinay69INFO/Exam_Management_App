/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.testing;

import com.vinay.org.dao.StudentDaoImp;
import com.vinay.org.dao.SubjectDaoImp;
import com.vinay.org.entity.Student;
import com.vinay.org.entity.Subject;
import java.util.List;
import java.util.Set;
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
public class SubjectTesting {
    public static SubjectDaoImp subjectDaoImp;
    
    @RequestMapping("/saveSubjectt")
    public String saveSubjectt(Model m){
        
        Subject sub=new Subject();
        sub.setSub_name("Spring");
        sub.setMax_marks(50);
        sub.setPassing_marks(25);
        sub.setTotal_questions(12);
        sub.setDuration(22);
        sub.setFees(12);
        sub.setOffer(0);
        subjectDaoImp=new SubjectDaoImp();
        subjectDaoImp.Save(sub);
        m.addAttribute("message", "Hello Save message Successfully!");
        return "home";
    }
    @RequestMapping("/updateSubjectt")
    public String updateSubjectt(Model m){
        Subject sub=new Subject();
        sub.setSub_id(2);
        sub.setSub_name("python");
        sub.setMax_marks(50);
        sub.setPassing_marks(25);
        sub.setTotal_questions(12);
        sub.setDuration(22);
        sub.setFees(12);
        sub.setOffer(0);
        subjectDaoImp=new SubjectDaoImp();
        subjectDaoImp.Update(sub);
        m.addAttribute("message", "Hello Save message Successfully!");
        return "home";
    }
    
    @RequestMapping("/deleteSubjectt")
    public String deleteSubjectt(Model m){
        subjectDaoImp=new SubjectDaoImp();
        subjectDaoImp.DeleteById(1);
        m.addAttribute("message", "Message deletebyID Successfully!");
        return "home";
    }
    @RequestMapping("/findByAllSubjectt")
    public String findByAllSubjectt(Model m){
        subjectDaoImp=new SubjectDaoImp();
       List<Subject> subject= subjectDaoImp.FindAll();
        System.out.println("FindAll student============="+subject);
        m.addAttribute("message", "Message findbyAll Successfully!");
        return "home";
    }
 
    
    
}
