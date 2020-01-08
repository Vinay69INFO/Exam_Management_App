<%-- 
    Document   : updateQuestionRecordes
    Created on : 18 Dec, 2019, 1:52:04 PM
    Author     : vinay
--%>

<%@page import="com.vinay.org.entity.Options"%>
<%@page import="com.vinay.org.dao.OptionsDaoImp"%>
<%@page import="com.vinay.org.entity.Questions"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="t"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../commonLib/cdnLink.jsp" /> 
    <s:url var="url_jqlib" value="/static/js/jquery-3.4.1.min.js" />
    <script src="${url_jqlib}"></script>
    <link href="../../static/css/globalStyle.css" rel="stylesheet" type="text/css">
</head>
<body>
    <jsp:include page="./components/header.jsp" />
    <br><br><br><br>
    <div class="row center-form">
        <div class="col-sm-8">
            <t:url  var="update" value="../../demo" />
            <f:form class="form-controller1" action="${update}" method="POST" modelAttribute="questions">
                <h1 class="text-white title-h1 " style="color: white;">Update Questions</h1>
                <div class="form-group">
                    <label name="subject_name" for="question_marks">Subject:</label>
                    <input type="text" class="form-control input-sm" value="${questions.subject_name.sub_name}" id="contact"
                             placeholder="Please Enter Your Contact No..." required="" />
                </div>
                <div class="form-group">
                    <label name="que_marks" for="que_marks">Question Marks</label>
                    <f:input type="text" class="form-control input-sm" path="que_marks" id="contact"
                             placeholder="Please Enter Your Contact No..." required="" />
                </div>
                <div class="form-group" id="q_option">
                    <label for="Que_type">Question Type</label>
                    <f:select class="form-control" path="que_type" id="Que_type">
                        <option value="${questions.que_type}" selected="">${questions.que_type}</option>

                        
                    </f:select>
                </div>
                <div class="form-group">
                    <label for="Que_text">Question Text</label>
                    <f:input type="text" class="form-control" path="que_text" id="Que_text" placeholder="Question Text" />
                </div>




                <c:if test="${questions.getQue_type() eq 'Optional'}">
                    <div class="form-group" id="qoptions" style="display: none;" > 
                        <c:set var="questions" value="${questions}" />
                        <%
                            Questions question = (Questions) pageContext.getAttribute("questions");
                            OptionsDaoImp optionsDaoImp = new OptionsDaoImp();
                            Options options = optionsDaoImp.FindById(question.getQue_id());
                            pageContext.setAttribute("options", options);
                        %>
                        <label for="options">Update option for this Questions</label>
                        &nbsp;<input type="text" class="form-control" name="option1" value="${options.option1}" placeholder="Option 1" />
                        &nbsp;<input type="text" class="form-control" name="option2" value="${options.option2}" placeholder="Option 2" />
                        &nbsp;<input type="text" class="form-control" name="option3" value="${options.option3}" placeholder="Option 3" />
                        &nbsp;<input type="text" class="form-control" name="option4" value="${options.option4}" placeholder="Option 4" />
                    </div>

                </c:if>
                <div class="form-group">
                    <label for="answer_text">Answer Text</label>
                    <f:input type="text" class="form-control" path="answer_text" id="answer_text" placeholder="Answer Text" />
                </div>

                <button type="submit" class="btn btn-lg btn-success">Submit</button>
            </f:form>
        </div>
    </div>

    <script>
        $(document).ready(function () {
           // $('#q_option').change(function () {
                var optionSelected = $(this).find("option:selected");
                var textSelected = optionSelected.text();
                if (textSelected == "Optional") {
                    $('#qoptions').slideDown(1000);
                } else if (textSelected == "Written") {
                    $('#qoptions').slideUp();
                } else if (textSelected == "Practical") {
                    $('#qoptions').slideUp();
                }
            //});
        });
    </script>

</body>
</html>
