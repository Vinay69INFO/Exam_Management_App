<%-- 
    Document   : ShowAllStudents
    Created on : 26 Nov, 2019, 10:16:22 PM
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
        <link href="static/css/globalStyle.css" rel="stylesheet" type="text/css">
    </head>
    <body>        
        <jsp:include page="./components/header.jsp" />

        <h1>user dashbord</h1>
        <div class="row center-form">           
            <div class="col-sm-9" style="background: white;">
                <table class="table">
                    <thead>
                        <tr><h1 class="text-white title-h1 " style="color: white;">All Student Record</h1></tr>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Contact</th>
                            <th>Address</th>
                            <th>Email</th>
                            <th>Admission_Date</th>
                            <th>Course</th>
                            <th>Course_Detail</th>
                            <th>Fees</th>
                            <th>UserName</th>
                            <th>Password</th>
                            <th>Update</th>
                            <th>Delete</th>
                        </tr>     
                    </thead>
                    <tbody>
                        <c:forEach items="${student}" var="student" >
                            <tr>
                                <td>${student.id}</td>
                                <td>${student.name}</td>
                                <td>${student.contact}</td>
                                <td>${student.address}</td>
                                <td>${student.email}</td>
                                <td>${student.admission_datecourse}</td>
                                <td>${student.course}</td>
                                <td>
                                    <c:forEach items="${student.getSubjectList()}" var="subject" >
                                        ${subject.sub_name}<br>
                                    </c:forEach>
                                </td>
                                <td>${student.fees}</td>                   
                                <td>${student.username}</td>
                                <td>${student.password}</td>
                                <t:url var="update_stu" value="/updateStudent?student=${sessionScope.id}" />
                                <td><a href="${update_stu}">Update</a></td>
                                <td><a href="./deleteStudent">Delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>

            </div><!--/col-9-->
        </div><%-- row --%>





    </body>
</html>
