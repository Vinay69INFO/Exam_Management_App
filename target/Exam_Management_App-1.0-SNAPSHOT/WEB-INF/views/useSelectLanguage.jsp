<%-- 
    Document   : useSelectLanguage
    Created on : 5 Dec, 2019, 11:27:07 AM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="tag" %>
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
        <h1>user dashbord</h1>
        <div class="row center-form">
        <div class="col-sm-6">
            
                <tag:url var="ExamPhase2" value="/studentExamPhase2/${student.id}" />
                <form class="form-controller1" action="${ExamPhase2}">
                    <input type="hidden" value="${student.id}" name="studentId">
                    <div class="form-group">
                        <label for="sell">Select your subject:</label>
                        <select class="form-control" name="subj_id">
                            <c:forEach items="${student.getSubjectList()}" var="subject">
                                <option value="${subject.sub_id}">${subject.sub_name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="jumbotron">
                        <h2>Read before next Phase</h2>
                        <ul class="list-group">

                            <li class="list-group-item">Dear students your first attempts of examination is free next attempt is chargeable based on subject</li>
                            <li class="list-group-item">Question can have in three category (Practical, Optional, Written).</li>
                            <li class="list-group-item">After completion of this exam you will be awarded by Exam-Infotec certificate.</li>
                            <li class="list-group-item"><input type="checkbox" required> I am agree</li>
                        </ul>
                    </div>
                    <input class="btn btn-login btn-success" type="submit" name="submit">
                </form>
<!--            </div>-->
        </div>
        </div>






    </body>
</html>
