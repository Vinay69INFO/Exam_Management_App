<%-- 
    Document   : showAllQuestions
    Created on : 18 Dec, 2019, 10:16:05 AM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="t"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../commonLib/cdnLink.jsp" /> 
        <link href="../static/css/globalStyle.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <jsp:include page="./components/header.jsp" />
        <h1>Hello World!</h1>
        <div class="row center-form">
            <div class="col-sm-10" style="background: white;">
                <% Integer count=0;%>
                <table class="table">
                    <thead>
                        <tr><h1 class="text-white title-h1 " style="color: white;">All Student Record</h1></tr>
                    <tr>
                        <th>Id</th>
                        <th>Subject Name</th>
                        <th>Question Name</th>
                        <th>Question Marks</th>
                        <th>Answer</th>
                        <th>Question Type</th>
                        <th>Update</th>
                        <th>Delete</th>
                    </tr>     
                    </thead>
                    <tbody>
                    <c:forEach items="${questionLis}" var="question" >
                        <% count++;%>
                        <tr>
                            <td><%=count%></td>
                            <td>${question.subject_name.sub_name}</td>
                            <td>${question.que_text}</td>
                            <td>${question.que_marks}</td>
                            <td>${question.answer_text}</td>
                            <td>${question.que_type}</td>
                            <t:url var="update_stu" value="./updatetQuestionRecord/${question.que_id}" />
                                <td><a href="${update_stu}">Update</a></td>
                                <td><a href="./deleteStudent">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>
    </body>
</html>
