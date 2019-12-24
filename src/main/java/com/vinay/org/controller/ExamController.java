/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.controller;

import com.vinay.org.dao.AnswerDaoImp;
import com.vinay.org.dao.OptionsDaoImp;
import com.vinay.org.dao.QuestionsDaoImp;
import com.vinay.org.dao.StudentDaoImp;
import com.vinay.org.dao.StudentExamInfoImp;
import com.vinay.org.dao.SubjectDaoImp;
import com.vinay.org.entity.Answer;
import com.vinay.org.entity.Options;
import com.vinay.org.entity.Questions;
import com.vinay.org.entity.Student;
import com.vinay.org.entity.StudentExamInfo;
import com.vinay.org.entity.Subject;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vinay
 */

@Controller
public class ExamController {
   
    private static StudentDaoImp studentDaoImp = new StudentDaoImp();
    private static SubjectDaoImp subjectDaoImp = new SubjectDaoImp();
    private static OptionsDaoImp optionsDaoImp = new OptionsDaoImp();
    private static QuestionsDaoImp questionsDaoImp = new QuestionsDaoImp();
    private static AnswerDaoImp answerDaoImp = new AnswerDaoImp();
    private static StudentExamInfoImp studentExamInfoImp=new StudentExamInfoImp();
    
    @RequestMapping("/showProfile")
    public String showProfile(){
        return"Profile";
    }
    
    @RequestMapping("/useSelectLanguage/{studentId}")
    public String selectLanguage(@PathVariable("studentId") Integer stuId, Model m){
        Student student=new Student();
        student=studentDaoImp.findById(stuId);
//        Subject subject=new Subject();
//        List<Subject> subjectList=subjectDaoImp.FindAll();
//        m.addAttribute("subjectList", subjectList);
        m.addAttribute("student", student);
        return "useSelectLanguage";
    }
   
    @RequestMapping("/studentExamPhase2/{studentId}")
    public String studentExamPhase2(@PathVariable("studentId") Integer studId, 
            @RequestParam("subj_id") Integer subjId, Model m){
        Student student=studentDaoImp.findById(studId);
        
        List<Options> optionsList = null;
        
        Subject subject=new Subject();
        subject = subjectDaoImp.FindById(subjId);

        List<Questions> questionsList=questionsDaoImp.selectNotIn(subject, student);
        System.out.println("---------questionsList------------>"+questionsList);
        
        int size= questionsList.size();
       m.addAttribute("studentId", studId);
        m.addAttribute("subject", subject);
        m.addAttribute("questionsList", questionsList);
        m.addAttribute("optionsList", optionsList);
        m.addAttribute("size", size);
        return "studentExamPhase2";
    }
    
    @RequestMapping(value = "/quesAnswerSubmit/{studentId}" , method = RequestMethod.POST)
    public String quesAnswerSubmit(@PathVariable("studentId") Integer studentId,
            @RequestParam("answer_Text") String answerText,
            @RequestParam("queid") Integer queId, 
            @RequestParam("subj_id") Integer subId,
            @RequestParam("lastq") boolean lastanswer,Model m ){
        
        String WrongOrRight="Wrong";
        
        Student student=new Student();
        Subject subject=new Subject();
        Questions question=new Questions();
        
        String adate=new Date().toString();
        
        student=studentDaoImp.findById(studentId);
        subject=subjectDaoImp.FindById(subId);
        question=questionsDaoImp.FindById(queId);
        
        System.out.println("======="+student);
        System.out.println("========="+subject);
        System.out.println("========"+question);
        
        System.out.println("-----------"+student);
       
        if(answerText.equals(question.getAnswer_text())){
            WrongOrRight="Right";
        }
        
        Answer answer=new Answer();
        answer.setWrongOrRight(WrongOrRight);
        answer.setAnswer_Text(answerText);
        answer.setAnswer_date(adate);
        answer.setQuestions(question);
        answer.setStudent(student);
        answer.setSubjectId(subject);
        
        System.out.println("==========="+answer);
        Integer pk=answerDaoImp.insert(answer);
        System.out.println("anser id============="+pk);
        System.out.println("--------lastanswer---------------"+lastanswer);
       if(pk > 0 && !lastanswer){
           System.out.println("hello vinay ji...............");
           return "home";
       } else {
                   System.out.println("--------lastanswer2---------------"+lastanswer);

           List<Answer> anserList=answerDaoImp.serchByStudent$language(student, subject);
           ListIterator lit=anserList.listIterator();
           //-----------------------to sum of all right answer marks
           double totalRightAnswerMarks=0;
           if(answerDaoImp.WrongOrRight("Right", student, subject)!= null){
               List<Answer> right_ans= answerDaoImp.WrongOrRight("Right", student, subject);
               ListIterator right_tans_lit = right_ans.listIterator();
               while(right_tans_lit.hasNext()){
                   Answer ans=(Answer) right_tans_lit.next();
                   totalRightAnswerMarks += ans.getQuestions().getQue_marks();       
               }
           }
       }
        m.addAttribute("message", "message successfully saved!");       
        return "home";
    }
    
}
