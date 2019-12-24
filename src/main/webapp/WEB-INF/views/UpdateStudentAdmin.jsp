<%-- 
    Document   : UpdateStudentAdmin
    Created on : 20 Dec, 2019, 10:53:10 AM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                <div class="col-sm-8">
                    <t:url var="update" value="../updateStudentRecord" />
                    <f:form class="form-controller1" action="${update}" modelAttribute="student">
                        <h1 class="text-white title-h1 " style="color: white;">Update Admin</h1>                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <f:label path="name" for="name">Name</f:label>
                                <f:input type="text" class="form-control input-sm"  path="name" id="name"
                                         placeholder="Please Enter Your Name...." required="" />
                            </div>
                            <div class="form-group col-md-6">
                                <f:label path="contact" for="contact">Contact</f:label>
                                <f:input type="text" class="form-control input-sm" path="contact" id="contact"
                                         placeholder="Please Enter Your Contact No..." required="" />
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <f:label path="address" for="address">Address</f:label>
                                <f:input type="text" class="form-control input-sm" path="address" id="address"
                                         placeholder="Please Enter Your Address..." required="" />
                            </div>
                            <div class="form-group col-md-6">
                                <f:label path="fees" for="fees">Fees</f:label>
                                <f:input type="text" class="form-control input-sm" path="fees" id="fees"
                                         placeholder="Please Enter Your Fees..." required="" />
                            </div>
                        </div>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <f:label path="admission_datecourse" for="admission_datecourse">Admission Date Course</f:label>
                                <f:input type="text" class="form-control input-sm" path="admission_datecourse" id="admission_datecourse"
                                         placeholder="Please Enter Your Admission Date Course..." required="" />
                            </div>
                            <div class="form-group col-md-6">
                                <f:label path="course" for="course">Course</f:label>
                                <f:input type="text" class="form-control input-sm" path="course" id="course"
                                         placeholder="Please Enter Your Course..." required="" />
                            </div>
                        </div>
                        <div class="form-group col-md-12">
                            <f:label path="email" for="email">Email Id</f:label>
                            <f:input type="text" class="form-control" path="email" name="emailId" id="emailId"
                                     placeholder="Please Enter Your Email Id..." required="" />
                        </div>
                        <div class="form-group col-md-12">
                            <f:label path="username" for="username">User Name</f:label>
                            <f:input type="text" class="form-control" path="username" name="username" id="username"
                                     placeholder="Please Enter Your User Name..." required="" />
                        </div>
                        <div class="form-group col-md-12">
                            <f:label path="password" for="password">Password</f:label>
                            <f:input type="text" class="form-control" path="password" name="password" id="password"
                                     placeholder="Please Enter Your Password.." required="" />
                        </div>

                        <div class="form-group col-md-12">
                            <div class="form-check">
                                <input class="form-check-input"  type="checkbox" id="gridCheck" required>
                                <label class="form-check-label" for="gridCheck">
                                    Check me out
                                </label>
                            </div>
                        </div>
                        <f:input type="hidden" path="id" />
                        <f:button type="submit" class="btn btn-primary btn-block">Submit</f:button>

                    </f:form>
                </div>
            </div>
                </body>
                </html>
