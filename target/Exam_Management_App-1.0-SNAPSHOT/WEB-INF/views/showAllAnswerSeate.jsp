<%-- 
    Document   : showAllAnswerSeate
    Created on : 8 Dec, 2019, 8:40:29 AM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="t" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../commonLib/cdnLink.jsp" /> 

    </head>
    <body>
        <div class="container">
            <table class="table table-striped">
                <caption>All Questions records</caption>
                <thead>
                    <tr>
                        <th>Answer Id</th>
                        <th>Subject Name</th>
                        <th>Question Id</th>
                        <th>Question Marks</th>
                        <th>Question type</th>
                        <th>Question text</th>
                        <th>Actual Answer Text</th>
                        <th>Student Answer Test</th>
                        <th>Wrong or Right</th>
                        <th>Answer Date</th>
                    </tr>     
                </thead>
                
                    <tbody>
                        <c:forEach items="${answer}" var="answer" >
                        <tr>
                            <td>${answer.ans_id}</td>
                            <td>${answer.getSubjectId().sub_name}</td>
                            <td>${answer.getQuestions().que_id}</td>
                            <td>${answer.getQuestions().que_marks}</td>
                            <td>${answer.getQuestions().que_type}</td>
                            <td>${answer.getQuestions().que_text}</td>
                            <td>${answer.getQuestions().answer_text}</td>
                            <td>${answer.answer_Text}</td>                           
                            <td>${answer.wrongOrRight}</td>
                            <td>${answer.answer_date}</td>
                        </tr>
                        </c:forEach>
                    </tbody>
                
            </table>    

        </div>

    </body>
</html>
