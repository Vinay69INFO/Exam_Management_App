/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.controller;

import com.vinay.org.dao.StudentDaoImp;
import com.vinay.org.dao.SubjectDaoImp;
import com.vinay.org.entity.Student;
import com.vinay.org.entity.Subject;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vinay
 */
@Controller
@ComponentScan("com.vinay.org")
public class StudentController {

    @Autowired
    StudentDaoImp studentDaoImp;
    private static SubjectDaoImp subjectDaoImp = new SubjectDaoImp();

    @RequestMapping("/home")
    public String studentReg() {
        return "home";
    }
    
    @RequestMapping("/AboutUS")
    public String AboutUS(){
        return "AboutUS";
    }
    
    @RequestMapping("/studentForm")
    public String studentForm(@ModelAttribute("student") Student student){
        return "StudentRegistration";
    }

    @RequestMapping("/saveStudenta")
    public String saveStudenta(@ModelAttribute("student") Student student) {
        studentDaoImp.save(student);
        return "redirect:studentForm?act=lo";
    }

    @RequestMapping("/findByAllStudent")
    public String findByAllStudent(Model m) {
        List<Student> studentList = studentDaoImp.findByAll();
        m.addAttribute("student", studentList);
        return "ShowAllStudents";
    }

    @RequestMapping("/updateStudent/{studentID}")
    public String updateStudent(@PathVariable("studentID") int id, Model m) {

        Student student = studentDaoImp.findById(id);
        m.addAttribute("student", student);
        List<Subject> subjectList = subjectDaoImp.FindAll();
        m.addAttribute("subjectList", subjectList);

        return "UpdateStudent";
    }

    @RequestMapping("/updateStudentRecord")
    public String updateStudentRecord(@ModelAttribute("student") Student student) {
        studentDaoImp.update(student);
        return "redirect:user/dashbord?act=lo";
    }

    @RequestMapping("/updateAdmin/{studentID}")
    public String updateAdmin(@PathVariable("studentID") int id, Model m) {

        Student student = studentDaoImp.findById(id);
        m.addAttribute("student", student);
        List<Subject> subjectList = subjectDaoImp.FindAll();
        m.addAttribute("subjectList", subjectList);

        return "UpdateStudentAdmin";
    }

    @RequestMapping(path = "/addSubjStudent", method = RequestMethod.POST)
    public String addSubjStudent(@RequestParam("studentid") Integer studentid,
            @RequestParam("subjectID") Set<String> subjId, Model m) {

        Student student = null;
        Subject subjecta;

        Iterator listIter = subjId.iterator();
        while (listIter.hasNext()) {
            try {
                Integer subjectID = Integer.valueOf((String) listIter.next());
                System.out.println("value )))))--->" + subjectID);
                student = studentDaoImp.findById(studentid);
                subjecta = subjectDaoImp.FindById(subjectID);
                student.getSubjectList().add(subjectDaoImp.FindById(subjectID));
                System.out.println("successfylly code*****************");
            } catch (Exception e) {
                System.out.println("exception------------->" + e);
            }
        }
        Integer returnId = studentDaoImp.udDateBystuId(studentid, student);
        System.out.println("returnI->>>>>>"+returnId);
        if (returnId > 0) {
            System.out.println("=============" + studentid);
            System.out.println("id=======" + subjId);
            m.addAttribute("message", "subject is add successfully!");
            return "redirect:updateStudent/"+studentid+"";
        }else if(returnId==-1){
            m.addAttribute("message", "subject is already in student");
            return "redirect:updateStudent/"+studentid+"";
        }

        return "home";
    }

    @RequestMapping("/addSub_Student")
    @ResponseBody
    public String addSubhStudent(@RequestParam Integer stuId) {
        System.out.println("=======================" + stuId);
        System.out.println("=================hello==============");
        return "SuCCESS: Status Changed";
    }

    @RequestMapping(value = "/updateStudent/check_avail")
    @ResponseBody
    public String getServer(@ModelAttribute("id") Long id) {

        System.out.println("-------getServerTime()-------" + id);
        Date d = new Date();
        return d.toString();
    }

}
