<%-- 
    Document   : GradeCard
    Created on : 21 Dec, 2019, 9:33:50 PM
    Author     : vinay
--%>

<%@page import="com.vinay.org.dao.AnswerDaoImp"%>
<%@page import="com.vinay.org.dao.QuestionsDaoImp"%>
<%@page import="java.util.ListIterator"%>
<%@page import="java.util.List"%>
<%@page import="com.vinay.org.dao.StudentExamInfoImp"%>
<%@page import="com.vinay.org.entity.StudentExamInfo"%>
<%@page import="org.springframework.web.context.annotation.SessionScope"%>
<%@page import="com.vinay.org.entity.Student"%>
<%@page import="com.vinay.org.dao.SubjectDaoImp"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.vinay.org.dao.StudentDaoImp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:if test="${sessionScope.id ne null}">
            <c:set var="studentId" value="${sessionScope.id}" />
            <%
                Integer stuId=(Integer)pageContext.getAttribute("studentId");
               StudentDaoImp studentDaoImp = new StudentDaoImp();
                SubjectDaoImp subjectDaoImp = new SubjectDaoImp();
                Student student = studentDaoImp.findById(stuId);
                
                StudentExamInfoImp studentExamInfo=new StudentExamInfoImp();
                List<StudentExamInfo> studentExam=studentExamInfo.selectAllStudentExamInfo();
                ListIterator lit=studentExam.listIterator();
                
                AnswerDaoImp answerDaoImp=new AnswerDaoImp();
                QuestionsDaoImp questionsDaoImp=new QuestionsDaoImp();


            %> 
            <div class="container">
                <div class="row profile-name page-header" style="margin-top: 0px!important;">
                    <div class="col-sm-2" style="margin-top: 0px!important; text-align: center;">
                        <img src="static/image/vinay.png" height="100" width="100" alt="image" />
                        <br>
                        <%=student.getName()%>
                    </div>
                    <div class="col-sm-10">
                        <div class="row">
                            <div class="col-sm-6">
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </body>
</html>
