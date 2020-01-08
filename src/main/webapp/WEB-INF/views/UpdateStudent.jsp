<%-- 
    Document   : UpdateStudent
    Created on : 28 Nov, 2019, 4:17:54 PM
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
        <link href="../static/css/globalStyle.css" rel="stylesheet" type="text/css">
        <t:url var="url_jqlib" value="/static/js/jquery-3.4.1.min.js" />
        <script src="${url_jqlib}"></script>
        <script>
            $(document).ready(function () {
                var id = 10;
                // alert('JQuery is ready and integrated');
                $("#id_get_time").click(function () {
                    //alert('Button clicked....');
                    $.ajax({
                        url: 'check_avail',
                        data: {"id": id},
                        success: function (data) {
                            $("#id_time").html(data);
                            alert("hello" + data);
                        }
                    });
                });
            });

        </script>
    </head>
    <body>
    <form:errors path="stu.*" />

    <jsp:include page="./components/header.jsp" />
    <h1>user dashbord</h1>
    <div class="row" style="width: 100%">
        <jsp:include page="./components/userArtical.jsp"/>

        <div class="col-sm-10" style="background: white;">
            <div class="row center-Update">
                <div class="col-sm-8">
                    <t:url var="update" value="../updateStudentRecord" />
                    <f:form class="form-controller" action="${update}" modelAttribute="student">
                        <h1 class="text-white title-h1 " style="color: white;">Student Profile Update</h1>
                        <div class="form-row">
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
                <div class="col-sm-4">
                    <div class="row">
                        <div class="col-sm-6">
                            <div class="form-group">
                                <h5 for="fees">Taken by Student</h5>
                                <ul>
                                    <form class="form-controller">
                                        <li class="list-group-item">
                                            <c:forEach items="${student.subjectList}" var="subject" >
                                                <input type="checkbox" name="${subject.sub_name}" value="${subject.sub_id}"/> &nbsp;&nbsp;&nbsp;&nbsp;${subject.sub_name}
                                                <br><hr>
                                            </c:forEach>
                                        </li>
                                        <input type="hidden" name="studentid" value="${sessionScope.id}"/>
                                        <button type="submit" class="btn btn-block btn-success">Remove Subject</button>
                                    </form>
                                </ul>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="form-group">
                                <h5 for="fees">All Available Subjects:</h5>
                                <ul>
                                    <c:if test="${param.message eq 'subject is already in student'}">
                                        <p style="color:green;">subject is already in student</p>
                                    </c:if>
                                        <c:if test="${param.message eq 'subject is add successfully!'}">
                                        <p style="color:green;">subject is add successfully!</p>
                                    </c:if>
                                    <h6>${message}</h6>
                                    <t:url var="add_subj" value="/addSubjStudent" />
                                    <form action="${add_subj}" class="form-controller1" method="POST"> 
                                        <li class="list-group-item">
                                            <c:forEach items="${subjectList}" var="subjecta" >
                                                <input type="checkbox" name="subjectID" value="${subjecta.sub_id}"/> &nbsp;&nbsp;&nbsp;&nbsp;${subjecta.sub_name}
                                                <br><hr>
                                            </c:forEach>
                                        </li>
                                        <input type="hidden" name="studentid" value="${sessionScope.id}"/>
                                        <button type="submit" class="btn btn-block btn-success">Add Subject</button>
                                    </form>
                                </ul>
                            </div>
                        </div>



                    </div>
                </div>




            </div>
        </div><!--/col-9-->
    </div>
</body>
</html>



