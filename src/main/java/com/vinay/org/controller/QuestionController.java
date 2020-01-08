/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.controller;

import com.vinay.org.dao.OptionsDaoImp;
import com.vinay.org.dao.QuestionsDaoImp;
import com.vinay.org.dao.SubjectDaoImp;
import com.vinay.org.entity.Options;
import com.vinay.org.entity.Questions;
import com.vinay.org.entity.Subject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vinay
 */
@Controller
@ComponentScan("com.vinay.org")
@RequestMapping("/admin")
public class QuestionController {

    private static SubjectDaoImp subjectDaoImp = new SubjectDaoImp();
    private static OptionsDaoImp optionsDaoImp = new OptionsDaoImp();
    @Autowired
    QuestionsDaoImp questionsDaoImp;

    @RequestMapping("/addQuestionForm")
    public String addQuestionForm(Model m) {
        List<Subject> subjectList = subjectDaoImp.FindAll();
        m.addAttribute("subjectlist", subjectList);
        return "addQuestion";
    }

    @RequestMapping("/saveQuestionOption")
    public String saveQuestionOption(@RequestParam("subje_id") Integer sub_id,
            @RequestParam("Que_marks") Integer Que_marks,
            @RequestParam("Que_type") String Que_type,
            @RequestParam("Que_text") String Que_text,
            @RequestParam("option1") String option1,
            @RequestParam("option2") String option2,
            @RequestParam("option3") String option3,
            @RequestParam("option4") String option4,
            @RequestParam("answer_text") String answer_text, Model m) {

        Subject subject = new Subject();
        Questions question = new Questions();
        Options options = new Options();

        subject = subjectDaoImp.FindById(sub_id);

        question.setSubject_name(subject);
        //question.getSubject_name().add(subject);
        question.setQue_marks(Que_marks);
        question.setQue_type(Que_type);
        question.setQue_text(Que_text);
        question.setAnswer_text(answer_text);
        questionsDaoImp.Save(question);

        if (Que_type.equals("Optional")) {
            options.setOption1(option1);
            options.setOption2(option2);
            options.setOption3(option3);
            options.setOption4(option4);
            options.setQuestion_id(question);
            optionsDaoImp.Save(options);
        }

        System.out.println("question==============" + sub_id + " " + Que_text);
        m.addAttribute("message", "execute successfully");
        return "redirect:ShowAllQuestions?std=lo";
    }

    @RequestMapping("/ShowAllQuestions")
    public String ShowAllQuestions(Model m) {
        List<Questions> questionList = questionsDaoImp.FindAll();
        m.addAttribute("questionLis", questionList);
        System.out.println("question====================?" + questionList);
        return "showAllQuestions";
    }

    @RequestMapping("/updatetQuestionRecord/{questionId}")
    public String updatetQuestionRecord(@PathVariable("questionId") Integer que_id, Model m) {
        Questions question = questionsDaoImp.FindById(que_id);
        m.addAttribute("questions", question);
        return "updateQuestionRecordes";
    }

    @RequestMapping("/upQuestion")
    public String updateQuestion(@ModelAttribute("questions") Questions questions,
            @RequestParam("option1") String option1,
            @RequestParam("option2") String option2,
            @RequestParam("option3") String option3,
            @RequestParam("option4") String option4, Model m) {

        System.out.println("questions=========>"+questions);
        Options options = new Options();
        questionsDaoImp.Update(questions);
        
        if (questions.getQue_type().equals("Optional")) {
            options.setOption1(option1);
            options.setOption2(option2);
            options.setOption3(option3);
            options.setOption4(option4);
            options.setQuestion_id(questions);
            optionsDaoImp.Update(options);
        }
        
        return "home";
    }
    @RequestMapping("/demo")
    public String demo(){
        return "home";
    }
    
}
