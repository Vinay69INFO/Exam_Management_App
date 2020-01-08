/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.controller;

import com.vinay.org.dao.AnswerDao;
import com.vinay.org.dao.AnswerDaoImp;
import com.vinay.org.dao.OptionsDaoImp;
import com.vinay.org.dao.QuestionsDaoImp;
import com.vinay.org.dao.StudentDaoImp;
import com.vinay.org.dao.SubjectDaoImp;
import com.vinay.org.entity.Answer;
import com.vinay.org.entity.Questions;
import com.vinay.org.entity.Student;
import com.vinay.org.entity.Subject;
import java.util.List;
import java.util.ListIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vinay
 */
@Controller
@ComponentScan("com.vinay.org")
public class AnswerController {
    
    private static AnswerDao answerDaoImp = new AnswerDaoImp();
    private static StudentDaoImp studentDaoImp = new StudentDaoImp();
    private static SubjectDaoImp subjectDaoImp = new SubjectDaoImp();
    private static OptionsDaoImp optionsDaoImp = new OptionsDaoImp();
    
    @Autowired
    QuestionsDaoImp questionsDaoImp;
    
    
    @RequestMapping("/showAllAnswerSeat")
    public String showAllAnswerSeat(Model m){
        List<Answer> answerList=answerDaoImp.selectAllAnswers();
        
        m.addAttribute("answer",answerList);
        return "showAllAnswerSeate";
    }
    
    @RequestMapping("/showResultUser/{studentId}/{subjectId}")
    public String showResultUser(@PathVariable("studentId") Integer studentId,
            @PathVariable("subjectId") Integer subjectId,Model m){
        
            Student student=new Student();
            Subject subject=new Subject();
            Questions questions=new Questions();
            Answer answer=new Answer();
           student= studentDaoImp.findById(studentId);
           subject= subjectDaoImp.FindById(subjectId);

           System.out.println("student------------------->"+student);
           System.out.println("subject==================>"+subject);
           List answerList= answerDaoImp.serchByStudent$language(student, subject);
         
           System.out.println("size of the lists"+answerList.size());
         
          m.addAttribute("student", student);
           m.addAttribute("subject",subject);
           m.addAttribute("answerList", answerList);
        if(answerList.size()>0){
        return "Result";
       }else{
            return "redirect:../../studentExamPhase2?subj_id="+subjectId+"&act=lo";
        }
        
    }
}

