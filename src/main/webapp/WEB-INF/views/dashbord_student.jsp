<%-- 
    Document   : dashbord_student
    Created on : 16 Dec, 2019, 9:40:50 PM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="row" style="width:100%">
            <jsp:include page="./components/userArtical.jsp"/>
            
            <div class="col-sm-9" style="background: white;">
                <table class="table">
                    <thead>
                        <tr>
                           <h2>Profile</h2>
                           
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">Id</th>
                            <td>${sessionScope.student.id}</td>
                            
                        </tr>
                        <tr>
                            <th scope="row">Name</th>
                            <td>${sessionScope.student.name}</td>
                        </tr>
                        <tr>
                            <th scope="row">Address</th>
                            <td>${sessionScope.student.address}</td>
                        </tr>
                        <tr>
                            <th scope="row">Admission Date</th>
                            <td>${sessionScope.student.admission_datecourse}</td>
                        </tr>
                        <tr>
                            <th scope="row">Contact Number</th>
                            <td>${sessionScope.student.contact}</td>
                        </tr>
                        <tr>
                            <th scope="row">Email Id</th>
                            <td>${sessionScope.student.email}</td>
                        </tr>
                        <tr>
                            <th scope="row">Course</th>
                            <td>${sessionScope.student.course}</td>
                        </tr>
                        <tr>
                            <th scope="row">Fees</th>
                            <td>${sessionScope.student.address}</td>
                        </tr>
                        <tr>
                            <th scope="row">UserName</th>
                            <td>${sessionScope.student.username}</td>
                        </tr>
                        <tr>
                            <th scope="row">Password</th>
                            <td>${sessionScope.student.password}</td>
                        </tr>
                    </tbody>
                </table>
            </div><!--/col-9-->
        </div><!--/row-->

    </body>
</html>
