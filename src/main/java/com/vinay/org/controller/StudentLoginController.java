/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.controller;

import com.vinay.org.entity.LoginCommand;
import com.vinay.org.entity.Student;
import com.vinay.org.exception.InvalidPasswordException;
import com.vinay.org.services.StudentServices;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author vinay
 */
@Controller
public class StudentLoginController {
    
    @Autowired
    StudentServices studentServices;
    
    @RequestMapping(value = {"/loginPage"})
    public String loginPage(Model m){
        m.addAttribute("command", new LoginCommand());
        return "loginPage";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession session){
        try{
        Student loggedStudent=studentServices.login(cmd.getUsername(),cmd.getPassword());
        System.out.println("login stutas------------"+loggedStudent);
        if(loggedStudent == null){
            //FAILED
            //add error message and go back to login-form
            System.out.println("null pointer..................");
            m.addAttribute("err","Login Failed Enter valid Credentials.");
            return "loginPage";
        } else{
            //SUCCESS
            //Check the role and redirect to a appropriate dashboard
            if(loggedStudent.getRole().equals(StudentServices.ADMIN_ROLE)){
                addUserSession(loggedStudent, session);
                return "redirect:admin/dashbord";
            }else if(loggedStudent.getRole().equals(StudentServices.USER_ROLE)){
                 addUserSession(loggedStudent, session);
                return "redirect:user/dashbord";
            }else{
                //add error message and go back to login-form
                System.out.println("exceeepkkkkkkk-----------");
                m.addAttribute("err", "Invalid User Role");
                return "loginPage";
            }
        }
        }catch(InvalidPasswordException ex){
            System.out.println("User has been blocked: "+ ex.getMessage());
            m.addAttribute("err", ex.getMessage());
            return "loginPage";
        }
    }
    @RequestMapping(value = "/logout")
    public String studentDashbord(HttpSession session){
       session.invalidate();
        return "redirect:loginPage?act=lo";
    }
    
    @RequestMapping(value = "/user/dashbord")
    public String studentDashbord(){
       
        return "dashbord_student";
    }
    
    @RequestMapping(value = "/admin/dashbord")
    public String adminDashbord(){
        return "dashbord_admin";
    }
    
    private void addUserSession(Student stu, HttpSession session){
        session.setAttribute("student", stu);
        session.setAttribute("id", stu.getId());
        session.setAttribute("role", stu.getRole());
    }
    
    
}
