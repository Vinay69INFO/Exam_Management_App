/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.testing;

import com.vinay.org.dao.OptionsDaoImp;
import com.vinay.org.dao.QuestionsDaoImp;
import com.vinay.org.entity.Options;
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
public class OptionsTesting {

    private static OptionsDaoImp optionsDaoImp = new OptionsDaoImp();
    private static QuestionsDaoImp questionsDaoImp = new QuestionsDaoImp();

    @RequestMapping("/saveOptions")
    public String saveOptions(Model m) {

        Options option = new Options();
        option.setOption1("yes");
        option.setOption2("no");
        option.setOption3("both");
        option.setOption4("none of above");
        option.setQuestion_id(questionsDaoImp.FindById(1));

        optionsDaoImp.Save(option);
        System.out.println("Save Question successfully");
        m.addAttribute("message", "Message Save Successfully!");
        return "home";

    }
}
