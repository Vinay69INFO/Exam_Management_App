<%-- 
    Document   : dashbord_admin
    Created on : 16 Dec, 2019, 9:42:14 PM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <h1>Admin dashbord!</h1>
        <div class="row center-form" style="width:100%">

            <div class="col-sm-9 form-controller" style="background:   #e6e6e6;">
                <table class="table">
                    <div class="text-center">
                                    <img style="width: 150px; height: 150px;" src="../static/images/vinay.jpg" class="avatar img-circle img-thumbnail" alt="Image">
                                    <h6 style="color:black;">${sessionScope.student.name}</h6>
<!--                                    <input type="file" class="text-center center-block file-upload">-->
                                </div></hr><br>
                    <thead>
                        <tr class="text-center">
                            <th scope="col">Admin Profile [<a href="../updateAdmin/${sessionScope.student.id}">Edit</a>]</th>
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
        </div>

    </body>
</html>
