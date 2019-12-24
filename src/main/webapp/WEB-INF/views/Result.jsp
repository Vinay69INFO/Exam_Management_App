<%-- 
    Document   : Result
    Created on : 8 Dec, 2019, 9:20:47 PM
    Author     : vinay
--%>

<%@page import="com.vinay.org.entity.Student"%>
<%@page import="java.util.ListIterator"%>
<%@page import="com.vinay.org.dao.AnswerDaoImp"%>
<%@page import="com.vinay.org.dao.AnswerDao"%>
<%@page import="java.util.List"%>
<%@page import="com.vinay.org.entity.Answer"%>
<%@page import="com.vinay.org.entity.Subject"%>
<%@page import="com.vinay.org.dao.QuestionsDaoImp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../commonLib/cdnLink.jsp" /> 

    </head>
    <body>
        <div class="jumbotron container" style="margin-top: 0px!important">


            <%
                int qno = 0;

            %>
            <div class="row profile-name page-header" style="margin-top: 0px!important;">
                <div class="col-sm-1" style="margin-top: 0px!important; text-align: center">
                    <img src="" height="100" width="100" alt="" />
                    <br>
                    ${student.name}
                </div>
                <div class="col-sm-3">
                    <div class="row">
                        <div class="col-sm-12">Contact: ${student.contact}</div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">Address: ${student.address}</div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">Email: ${student.email}</div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">Course: ${student.course}</div>
                    </div>

                </div>
                <c:set var="student"  value="${student}" />
                <c:set var="subject"  value="${subject}" />
                <c:set var="answerLis" value="${answerList}" />
                <%                    
                    
                    Subject subjec = (Subject) pageContext.getAttribute("subject");
                    Student studen = (Student) pageContext.getAttribute("student");
                    List<Answer> answerLis = (List<Answer>) pageContext.getAttribute("answerLis");
                    System.out.println("============subject==========" + subjec);
                    System.out.println("======== Student ======>" + answerLis);

                    QuestionsDaoImp questionsDaoImp = new QuestionsDaoImp();
                    AnswerDaoImp answerDaoImp = new AnswerDaoImp();

                    int totalalquestions = questionsDaoImp.selectBySubject(subjec).size();
                    int attemptQuestions = answerLis.size();
                    int totalrightanswer = answerDaoImp.WrongOrRight("Right", studen, subjec).size();
                    int totalwronganswer = answerDaoImp.WrongOrRight("Wrong", studen, subjec).size();
                    System.out.println("attemptQuestions =======" + totalwronganswer);

                    double totalmarkofsubject = questionsDaoImp.SumOfMarks(subjec);
                    double tatalmarkofstudent = 0.0;
                    ListIterator lit = answerLis.listIterator();
                    //----------to sum of all right answer marks
                    double totalRighAnswerMarks = 0;
                    if (answerDaoImp.WrongOrRight("Right", studen, subjec) != null) {
                        List<Answer> righ_tans_li = answerDaoImp.WrongOrRight("Right", studen, subjec);
                        ListIterator righ_tans_lit = righ_tans_li.listIterator();
                        while (righ_tans_lit.hasNext()) {
                            Answer ans = (Answer) righ_tans_lit.next();
                            totalRighAnswerMarks += ans.getQuestions().getQue_marks();
                        }
                    }

                %>
                <div class="col-sm-6">
                    <div class="row">
                        <div class="col-sm-12">Total Question:<%= totalalquestions%></div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">Total attempted Questions: <%=attemptQuestions%> </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">Total Right Answer:<%= totalrightanswer%> </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">Total Wrong Answer:<%= totalwronganswer%> </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12"> Total Marks for: <%= subjec.getSub_name() + ": " + questionsDaoImp.SumOfMarks(subjec)%> </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">Total marks for right answer <%= totalRighAnswerMarks%> </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12" style="color: #990000; font-weight: bold;"> You are :<%=((totalRighAnswerMarks * 100) / questionsDaoImp.SumOfMarks(subjec)) < 40 ? "Failed" : "Passed"%></div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-12">
                        <div class="progress">
                            <div class="progress-bar progress-bar-striped active" role="progressbar"
                                 aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width:<%= ((totalRighAnswerMarks * 100) / questionsDaoImp.SumOfMarks(subjec)) + "%"%>"  >
                                <%=((totalRighAnswerMarks * 100) / questionsDaoImp.SumOfMarks(subjec)) + "%"%>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
            ${answerList}
            <c:forEach items="${answerList}" var="answer" >
                <c:out value="${answer}"></c:out>
                <% qno++;%>
                <div class="row" style="margin-bottom: 10px; box-shadow: 1px 1px 5px black;">
                    <div class="col-sm-2">
                        <div class="row">
                            <div class="col-sm-12 well well-sm">
                                Question: <%=qno%>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 well well-sm">
                                Your Answer
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 well well-sm">
                                Right answer
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-8">   

                        <div class="row">
                            <div class="col-sm-12 well well-sm">${answer.getQuestions().que_text}</div>
                        </div>  
                        <div class="row">
                            <div class="col-sm-12 well well-sm">${answer.getAnswer_Text()} <span style="float: right"><div style="color: red">${answer.getWrongOrRight()}</div></span></div>
                        </div>  
                        <div class="row">
                            <div class="col-sm-12 well well-sm">${answer.getQuestions().getAnswer_text()}</div>
                        </div>  
                    </div>  
                    <div class="col-sm-2">
                        <div class="row">
                            <div class="col-sm-12 well well-sm">${answer.getWrongOrRight()} </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 well well-sm">Try Again</div>
                        </div>
                        <div class="row">
                            <div class="col-sm-12 well well-sm">Not Satisfied</div>
                        </div>
                    </div>
                </div>

            </c:forEach>
        </div>
    </body>
</html>
