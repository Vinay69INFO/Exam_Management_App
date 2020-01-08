/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.controller;

import com.vinay.org.dao.SubjectDaoImp;
import com.vinay.org.entity.Subject;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vinay
 */
@Controller
public class SubjectController {
    
    @Autowired
    SubjectDaoImp subjectDaoImp;
    
    @RequestMapping("/showSubRegist")
    public String showSubjectRegistration(@ModelAttribute("subject") Subject subject){
        return "SubjectRegistration";
    }
    
    @RequestMapping("/subRegist")
    public String SubjectRegistration(@ModelAttribute("subject") Subject subject,Model m){
        subjectDaoImp.Save(subject);
        System.out.println("subject hello vinay============>0"+subject);
        return "redirect:showSubRegist?act=lo";
    }
    
    @RequestMapping("/showAllSubject")
    public String showAllSubject(Model m){
        List<Subject> subjectList=subjectDaoImp.FindAll();
        System.out.println("hellll------------------>000"+subjectList);
        m.addAttribute("subjectList", subjectList);
        return "showAllSubjectRecordes";
    }
    
    @RequestMapping("/updateSubjectRecord/{subjectID}")
    public String updateSubjectRecord(@PathVariable("subjectID")Integer id,Model m){
        System.out.println("id+++++++"+id);
        Subject subjects=subjectDaoImp.FindById(id);
        System.out.println("subjecst------------->"+subjects);
        m.addAttribute("subject", subjects);
        return "UpdateSubjectDetails";
    }
    
    @RequestMapping( value = "/updSubjDetails",method = RequestMethod.POST)
    public String UpdateSubjectDetails(@ModelAttribute("subject") Subject subject){
        subjectDaoImp.Update(subject);
        System.out.println("update Subject recordes!"+subject);
        return "redirect:showAllSubject?std=lo";
    }
    @RequestMapping("/DeleteSubject/{subjectID}")
    public String DeleteSubject(@PathVariable("subjectID")Integer id,Model m){
        subjectDaoImp.DeleteById(id);
        System.out.println("Delete subject recorde");
        return "redirect:../showAllSubject?std=lo";
    }
}
