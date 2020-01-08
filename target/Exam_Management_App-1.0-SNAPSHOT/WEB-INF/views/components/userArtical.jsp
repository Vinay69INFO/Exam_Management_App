<%-- 
    Document   : userArtical
    Created on : 17 Dec, 2019, 3:49:29 PM
    Author     : vinay
--%>

<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<c:if test="${sessionScope.id!=null && sessionScope.role == 2}">
    <div class="col-sm-2" style="background: #6b6161;"><!--left col-->
        <div class="text-center">
            <img style="width: 250px; height: 250px;" src="../static/images/vinay.jpg" class="avatar img-circle img-thumbnail" alt="Image">
            <h6 style="color:white;">${sessionScope.student.name}</h6>
            <input type="file" class="text-center center-block file-upload">
        </div></hr><br>
        <div class="panel panel-default">
            <div class="panel-heading"><a href="../user/dashbord">Profile </a><i class="fa fa-link fa-1x"></i></div>
            <div class="panel-body border border-bottom-white"><a href="../updateStudent/${sessionScope.id}">Edit Profile</a></div>
            <div class="panel-body"><a href="../useSelectLanguage/${sessionScope.id}">Exams</a></div>
            <div class="panel-body"><a href="#">Grade Card</a></div>
        </div>
    </div><!--/col-3-->

</c:if>

