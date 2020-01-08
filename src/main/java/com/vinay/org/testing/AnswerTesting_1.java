
import com.vinay.org.dao.OptionsDaoImp;
import com.vinay.org.dao.QuestionsDaoImp;
import com.vinay.org.dao.SubjectDaoImp;
import com.vinay.org.entity.Questions;
import com.vinay.org.entity.Subject;
import java.util.List;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vinay
 */

@Controller
@ComponentScan("com.vinay.org")
public class AnswerTesting_1 {
    
        private static SubjectDaoImp subjectDaoImp = new SubjectDaoImp();
    private static OptionsDaoImp optionsDaoImp = new OptionsDaoImp();
    private static QuestionsDaoImp questionsDaoImp = new QuestionsDaoImp();

        @RequestMapping("/studentExamPhase2")
    public String studentExamPhase2(@RequestParam("subj_id") Integer stuId, Model m){
        Subject subject=new Subject();
        subject = subjectDaoImp.FindById(1);
        List<Questions> subjec=subjectDaoImp.findBySubject(subject);
        m.addAttribute("student", subjec);
        return "studentExamPhase2";
    }

    
}
