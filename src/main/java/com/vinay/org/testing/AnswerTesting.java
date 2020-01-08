/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.testing;

import com.vinay.org.dao.AnswerDaoImp;
import com.vinay.org.dao.OptionsDaoImp;
import com.vinay.org.dao.QuestionsDaoImp;
import com.vinay.org.dao.StudentDaoImp;
import com.vinay.org.dao.SubjectDaoImp;
import com.vinay.org.entity.Answer;
import com.vinay.org.entity.Questions;
import com.vinay.org.entity.Student;
import com.vinay.org.entity.Subject;
import java.util.Date;
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
public class AnswerTesting {

    private static StudentDaoImp studentDaoImp = new StudentDaoImp();
    private static SubjectDaoImp subjectDaoImp = new SubjectDaoImp();
    private static OptionsDaoImp optionsDaoImp = new OptionsDaoImp();
    private static QuestionsDaoImp questionsDaoImp = new QuestionsDaoImp();
    private static AnswerDaoImp answerDaoImp = new AnswerDaoImp();

    @RequestMapping(value = "/quesAnswerTesting/{studentId}")
    public String quesAnswerSubmit(@PathVariable("studentId") Integer studentId,
            @RequestParam("answer_Text") String answerText,
            @RequestParam("queid") Integer queId,
            @RequestParam("subid") Integer subId, Model m) {

        String WrongOrRight = "Wrong";

        Student student = new Student();
        Subject subject = new Subject();
        Questions question = new Questions();

        String adate = new Date().toString();

        student = studentDaoImp.findById(studentId);
        subject = subjectDaoImp.FindById(subId);
        question = questionsDaoImp.FindById(queId);
        System.out.println("-----------" + student);
        if (answerText.equals(question.getAnswer_text())) {
            WrongOrRight = "Right";
        }

        Answer answer = new Answer();
        answer.setWrongOrRight(WrongOrRight);
        answer.setAnswer_Text(answerText);
        answer.setAnswer_date(adate);
        answer.setQuestions(question);
        answer.setStudent(student);
        answer.setSubjectId(subject);

        answerDaoImp.insert(answer);
        m.addAttribute("message", "message successfully saved!");

        return "home";
    }

}
