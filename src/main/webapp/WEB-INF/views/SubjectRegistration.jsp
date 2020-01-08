<%-- 
    Document   : SubjectRegistration
    Created on : 18 Dec, 2019, 10:42:22 PM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="t"%>
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
        <h3>Subject Registration</h3>

        <div class="row center-form">
            <div class="col-sm-7">
                <t:url  var="saves" value="./subRegist" />
                <f:form class="form-controller1" action="${saves}" modelAttribute="subject">
                    <h1 class="text-white title-h1 " style="color: white;">Subject Registration</h1>

                    <div class="form-group">
                        <f:label path="sub_name" for="name">Subject Name</f:label>
                        <f:input type="text" class="form-control input-sm" path="sub_name" id="contact"
                                 placeholder="Please Enter Your Contact No..." required="" />
                    </div>
                    <div class="form-group">
                        <label for="total_questions">Total Question</label>
                        <f:input type="text" class="form-control" path="total_questions" id="total_questions" placeholder="Total Question.." />
                    </div>

                    <div class="form-group">
                        <label for="max_marks">Subject Marks</label>
                        <f:input type="text" class="form-control" path="max_marks" id="max_marks" placeholder="Subject Marks.." />
                    </div>

                    <div class="form-group">
                        <label for="Passing_marks">Passing Marks</label>
                        <f:input type="text" class="form-control" path="Passing_marks" id="Passing_marks" placeholder="Passing marks.." />
                    </div>
                    <div class="form-group">
                        <label for="duration">Paper Duration</label>
                        <f:input type="text" class="form-control" path="duration" id="duration" placeholder="Paper Duration.." />
                    </div>
                    <div class="form-group">
                        <label for="fees">Subject Fees</label>
                        <f:input type="text" class="form-control" path="fees" id="fees" placeholder="Subject Fees.." />
                    </div>
                    <div class="form-group">
                        <label for="offer">Subject Offer</label>
                        <f:input type="text" class="form-control" path="offer" id="offer" placeholder="Subject Offer.." />
                    </div>
                    <button type="submit" class="btn btn-lg btn-success">Submit</button>
                </f:form>
            </div>
        </div>

    </body>
</html>
