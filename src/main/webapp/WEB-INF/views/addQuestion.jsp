<%-- 
    Document   : addQuestion
    Created on : 3 Dec, 2019, 8:55:09 AM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="t" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../commonLib/cdnLink.jsp" /> 
    <s:url var="url_jqlib" value="/static/js/jquery-3.4.1.min.js" />
    <script src="${url_jqlib}"></script>
    <link href="../static/css/globalStyle.css" rel="stylesheet" type="text/css">
</head>
<body>          
    <jsp:include page="./components/header.jsp" />
    <br><br><br><br>
    <div class="row center-form">
        <div class="col-sm-8">
            <t:url  var="saves" value="./saveQuestionOption" />
            <form class="form-controller1" action="${saves}">
                <h1 class="text-white title-h1 " style="color: white;">Add Questions</h1>
                <div class="form-group">
                    <label name="subject_name" for="question_marks">Select Any Subject to add questions:</label>
                    <select for="subject_name" name="subje_id">
                        <c:forEach items="${subjectlist}" var="subject">
                            <option value="${subject.sub_id}">${subject.sub_name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label name="Que_marks" for="Que_marks">Question Marks</label>
                    <input type="text" class="form-control input-sm" name="Que_marks" id="contact"
                           placeholder="Please Enter Your Contact No..." required="" />
                </div>

                <div class="form-group" id="q_option">
                    <label for="Que_type">Question Type</label>
                    <select class="form-control" name="Que_type" id="Que_type">
                        <option value="Optional">Optional</option>
                        <option value="Written" selected>Written</option>
                        <option value="Practical">Practical</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="Que_text">Question Text</label>
                    <input type="text" class="form-control" name="Que_text" id="Que_text" placeholder="Question Text" />
                </div>
                <div class="form-group" id="qoptions" style="display: none;">      
                    <label for="options">Add option for this Questions</label>
                    &nbsp;<input type="text" class="form-control" name="option1" placeholder="Option 1" />
                    &nbsp;<input type="text" class="form-control" name="option2" placeholder="Option 2" />
                    &nbsp;<input type="text" class="form-control" name="option3" placeholder="Option 3" />
                    &nbsp;<input type="text" class="form-control" name="option4" placeholder="Option 4" />
                </div>
                <div class="form-group">
                    <label for="answer_text">Answer Text</label>
                    <input type="text" class="form-control" name="answer_text" id="answer_text" placeholder="Answer Text" />
                </div>

                <button type="submit" class="btn btn-lg btn-success">Submit</button>
            </form>
        </div>
    </div>
    <div class="container">

    </div>

    <script>
        $(document).ready(function () {
            $('#q_option').change(function () {
                var optionSelected = $(this).find("option:selected");
                var textSelected = optionSelected.text();
                if (textSelected == "Optional") {
                    $('#qoptions').slideDown(1000);
                } else if (textSelected == "Written") {
                    $('#qoptions').slideUp();
                } else if (textSelected == "Practical") {
                    $('#qoptions').slideUp();
                }
            });
        });
    </script>

</body>
</html>
