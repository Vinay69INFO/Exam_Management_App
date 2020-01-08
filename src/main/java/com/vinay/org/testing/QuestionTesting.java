/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.testing;

import com.vinay.org.dao.QuestionsDaoImp;
import com.vinay.org.dao.SubjectDaoImp;
import com.vinay.org.entity.Questions;
import com.vinay.org.entity.Subject;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ComponentScan("com.vinay.org")
public class QuestionTesting {
    
    private static QuestionsDaoImp questionDaoImp=new QuestionsDaoImp();
    private static SubjectDaoImp subjectDaoImp = new SubjectDaoImp();

    @RequestMapping("/saveQuestion")
    public String saveQuestion(Model m){
        Subject subject=new Subject();
        subject=subjectDaoImp.FindById(2);
        Questions questions=new Questions();
        questions.setSubject_name(subject);
        questions.setQue_marks(5);
        questions.setQue_type("option");
        questions.setQue_text("C++ have oops concept?");
        questions.setAnswer_text("yes");
        questionDaoImp.Save(questions);
        System.out.println("Save Question successfully");
        m.addAttribute("message", "Message Save Successfully!");
        return "home";
    }
}
