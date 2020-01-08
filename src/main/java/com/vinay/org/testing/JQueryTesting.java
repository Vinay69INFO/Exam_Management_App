/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vinay.org.testing;

import com.vinay.org.dao.SubjectDaoImp;
import com.vinay.org.entity.Subject;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author vinay
 */
@Controller
public class JQueryTesting {

    private static SubjectDaoImp subjectDaoImp = new SubjectDaoImp();

    @RequestMapping("/test/test_Query")
    public String testQuery() {
        return "testQuery";
    }

    @RequestMapping("/test/get_time")
    @ResponseBody
    public String getServerTime() {
        System.out.println("-------getServerTime()-------");
        Date d = new Date();
        return d.toString();
    }

    @RequestMapping("/text/getValuCheck")
    public String getValuCheck(Model m) {
        List<Subject> subjectList = subjectDaoImp.FindAll();
        m.addAttribute("subjectList", subjectList);
        return "testCheckbox";
    }

    @RequestMapping("/text/getRequestChe")
    @ResponseBody
    public String getRequestChe(@RequestParam Integer fid,@RequestParam Integer fav) {
        try {
            System.out.println("-------getServerTime()-------" + fid);
            System.out.println("Shri Sitaram"+fav.toString());
            return "SUCCESS: Status Changed";

        } catch (Exception e) {
            System.out.println("Exception occure" + e);
            return "ERROR: Unable to Change Status";
        }
    }
    
    
    
    @RequestMapping(value = "/check_avail")
    @ResponseBody
    public String getServer(@ModelAttribute("fid:") Long id){
        
        System.out.println("-------getServerTime()-------"+id);
        Date d=new Date();
        return d.toString();
    }
    
    
    

}
