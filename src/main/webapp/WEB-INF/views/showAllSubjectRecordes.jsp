<%-- 
    Document   : showAllSubjectRecordes
    Created on : 18 Dec, 2019, 11:51:03 PM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="t"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../commonLib/cdnLink.jsp" /> 
        <link href="static/css/globalStyle.css" rel="stylesheet" type="text/css">
    </head>
    <body>
       <jsp:include page="./components/header.jsp" />
        <h1>Hello World!</h1>
        <div class="row center-form">
            <div class="col-sm-10" style="background: white;">
                <% Integer count=0;%>
                <table class="table">
                    <thead>
                        <tr><h1 class="text-white title-h1 " style="color: white;">All Subject Record</h1></tr>
                    <tr>
                        <th>Id</th>
                        <th>Subject Name</th>
                        <th>Subject Max_Marks</th>
                        <th>Subject Passing_Marks</th>
                        <th>Subject Total_Question</th>
                        <th>Paper Duration</th>
                        <th>Subject Fees</th>
                        <th>Subject Offer</th>
                    </tr>     
                    </thead>
                    <tbody>
                    <c:forEach items="${subjectList}" var="subject" >
                        <% count++;%>
                        <tr class="text-center">
                            <td><%=count%></td>
                            <td>${subject.sub_name}</td>
                            <td>${subject.max_marks}</td>
                            <td>${subject.passing_marks}</td>
                            <td>${subject.total_questions}</td>
                            <td>${subject.duration}</td>
                            <td>${subject.fees}</td>
                            <td>${subject.offer}</td>
                            <t:url var="update_sub" value="./updateSubjectRecord/${subject.sub_id}" />
                                <td><a href="${update_sub}">Update</a></td>
                                <td><a href="./DeleteSubject/${subject.sub_id}">Delete</a></td>
                        </tr>
                    </c:forEach>
                    </tbody>

                </table>
            </div>
        </div>
    </body>
</html>
