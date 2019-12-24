<%-- 
    Document   : studentExamPhase2
    Created on : 6 Dec, 2019, 4:56:31 PM
    Author     : vinay
--%>

<%@page import="com.vinay.org.entity.Questions"%>
<%@page import="com.vinay.org.entity.Options"%>
<%@page import="java.util.List"%>
<%@page import="com.vinay.org.dao.OptionsDaoImp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="t"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../commonLib/cdnLink.jsp" /> 
        <link href="../static/css/globalStyle.css" rel="stylesheet" type="text/css">
        <style>
            body{
                font-family: monospace;
            }
            h2,h3{
                margin: 1px;
                font-weight: bold;
                color: black;
            }
        </style>
    </head>
    <body>
        <jsp:include page="./components/header.jsp" />
        <h1>user dashbord</h1>
        <div class="container">
            <h1>Subject Id: ${subject.sub_id}  Subject Name: ${subject.sub_name} </h1>
            <%
                int count = 0;
                boolean lastq = false;
            %>
            ${questionsList}
            <c:if test="${questionsList ne null}">
                <c:forEach items="${questionsList}" var="question">

                    <% count++;%>
                    <c:if test="${count eq size}" >
                        <% lastq = true;%>
                    </c:if>
                    <c:if test="${question.getQue_type() eq 'Written' or question.getQue_type() eq 'Practical'}">
                        <p>${question}</p>
                        <div class="well well-sm">
                            <t:url var="answer" value="../quesAnswerSubmit/${studentId}" />
                            <form action="${answer}" method="POST">
                                <h2>Question type: ${question.que_type}</h2>
                                <h3>(<%=count%>) : ${question.que_text} <span class="badge badge-success">for ${question.que_marks} marks</span> </h3>
                                <textarea name="answer_Text" class="form-control"></textarea>

                                <ul class="pager">
                                    <input type="hidden" value="${question.que_id}" name="queid">
                                    <input type="hidden" value="${subject.sub_id}" name="subj_id">
                                    <input type="hidden" value="<%= lastq%>" name="lastq">
                                    <button type="submit" class="next">Next</button>
                                </ul>
                            </form>
                        </div>
                    </c:if>
                    <c:if test="${question.getQue_type() eq 'Optional'}">
                        <p>${question}</p>
                        <br><br>
                        <p><%= count%><%= lastq = true%></p>
                        <div class="well well-sm">
                            <t:url var="answer" value="../quesAnswerSubmit/${studentId}" />
                            <form action="${answer}" method="POST">

                                <h2>Question type: ${question.que_type}</h2>
                                <h3>(<%=count%>) : ${question.que_text} <span class="badge badge-success">for ${question.que_marks} marks</span> </h3>
                                <%
                                    Questions question=(Questions)pageContext.getAttribute("question");
                                    OptionsDaoImp optionsDaoImp = new OptionsDaoImp();
                                    List<Options> optionsList = null;
                                    optionsList=optionsDaoImp.findByQuestion(question);
                                    pageContext.setAttribute("optionsList", optionsList);
                                %>
                                <c:forEach items="${optionsList}" var="options">
                                    <ul class="list-group"> 
                                        <li class="list-group-item"><input type="radio" value="${options.option1}" name="answer_Text"> ${options.option1}</li>
                                        <li class="list-group-item"><input type="radio" value="${options.option2}" name="answer_Text"> ${options.option2}</li>
                                        <li class="list-group-item"><input type="radio" value="${options.option3}" name="answer_Text">">< ${options.option3}</li>
                                        <li class="list-group-item"><input type="radio" value="${options.option4}" name="answer_Text"> ${options.option4}</li>
                                    </ul> 

                                </c:forEach>
                                <ul class="pager">
                                    <input type="hidden" value="${question.que_id}" name="queid">
                                    <input type="hidden" value="${subject.sub_id}" name="subj_id">
                                    <input type="hidden" value="<%= lastq%>" name="lastq">
                                    <button type="submit" class="next">Next</button>
                                </ul>
                            </form>
                        </div>
                    </c:if>
                </c:forEach>
            </c:if>
            <c:if test="${ empty questionsList}">
                <c:out value="${'Look like  you have already given the exam or No questions are their for subject id  1'}" escapeXml="false" />
                <br>
                check your previous result for  ${subject.sub_name} <a href="../showResultUser/${sessionScope.id}/${subject.sub_id}">Get Result</a>
            </c:if>
        </div>


    </body>
</html>
