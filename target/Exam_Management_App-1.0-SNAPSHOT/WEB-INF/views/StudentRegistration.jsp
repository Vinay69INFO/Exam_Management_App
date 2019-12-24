<%-- 
    Document   : StudentRegistration
    Created on : 26 Nov, 2019, 8:30:14 AM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <br><br><br>
        <h2>Student Registration</h2>
    <c:if test="${param.act eq 'lo'}">
        <p style="color:green;">Registration Completed Successfully</p>
    </c:if>
    <div class="row center-form">
        <div class="col-12 col-xs-11  col-sm-12 col-md-7">
            <tags:url var="save" value="/saveStudenta" />
            <form:form class="form-controller" action="${save}" modelAttribute="student">
                <h1 class="text-white title-h1 " style="color: white;">Student Registration</h1>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <form:label path="name" for="name">Name</form:label>
                        <form:input type="text" class="form-control input-sm"  path="name" id="name"
                                    placeholder="Please Enter Your Name...." required="" />
                    </div>
                    <div class="form-group col-md-6">
                        <form:label path="contact" for="contact">Contact</form:label>
                        <form:input type="text" class="form-control input-sm" path="contact" id="contact"
                                    placeholder="Please Enter Your Contact No..." required="" />
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <form:label path="address" for="address">Address</form:label>
                        <form:input type="text" class="form-control input-sm" path="address" id="address"
                                    placeholder="Please Enter Your Address..." required="" />
                    </div>
                    <div class="form-group col-md-6">
                        <form:label path="fees" for="fees">Fees</form:label>
                        <form:input type="text" class="form-control input-sm" path="fees" id="fees"
                                    placeholder="Please Enter Your Fees..." required="" />
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <form:label path="admission_datecourse" for="admission_datecourse">Admission Date Course</form:label>
                        <form:input type="text" class="form-control input-sm" path="admission_datecourse" id="admission_datecourse"
                                    placeholder="Please Enter Your Admission Date Course..." required="" />
                    </div>
                    <div class="form-group col-md-6">
                        <form:label path="course" for="course">Course</form:label>
                        <form:input type="text" class="form-control input-sm" path="course" id="course"
                                    placeholder="Please Enter Your Course..." required="" />
                    </div>
                </div>

                <div class="form-row">
                    <div class="form-group col-md-6">
                        <form:label path="email" for="email">Email Id</form:label>
                        <form:input type="text" class="form-control" path="email" name="emailId" id="emailId"
                                    placeholder="Please Enter Your Email Id..." required="" />
                    </div>
                    <div class="form-group col-md-6">
                        <form:select path="role" for="course">
                            <form:option value="1">Admin 1</form:option>
                            <form:option value="2">Student 2</form:option>

                        </form:select>
                    </div>
                </div>




                <div class="form-group col-md-12">
                    <form:label path="username" for="username">User Name</form:label>
                    <form:input type="text" class="form-control" path="username" name="username" id="username"
                                placeholder="Please Enter Your User Name..." required="" />
                </div>
                <div class="form-group col-md-12">
                    <form:label path="password" for="password">Password</form:label>
                    <form:input type="password" class="form-control" path="password" name="password" id="password"
                                placeholder="Please Enter Your Password.." required="" />
                </div>
                <div class="form-group col-md-12">
                    <label path="conf_password" for="conf_password">Confirm Passowrd</label>
                    <input type="password" class="form-control" id="conf_password"
                           placeholder="Please Enter Your Confirm Password.." required="" >
                </div>
                <div class="form-group col-md-12">
                    <div class="form-check">
                        <input class="form-check-input"  type="checkbox" id="gridCheck" required>
                        <label class="form-check-label" for="gridCheck">
                            Check me out
                        </label>
                    </div>
                </div>

                <form:button type="submit" class="btn btn-primary btn-block">Submit</form:button>

            </form:form>
        </div>
    </div>
</body>
</html>
