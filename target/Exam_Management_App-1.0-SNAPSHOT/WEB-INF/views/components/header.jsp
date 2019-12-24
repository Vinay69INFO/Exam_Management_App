<%-- 
    Document   : header
    Created on : 26 Nov, 2019, 8:35:14 AM
    Author     : vinay
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="url_logout" value="/logout" />

<c:if test="${sessionScope.id==null}">
    <%-- User is not yet logged in : Guest Menu --%>

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12 col-sm-6">
                <nav class="navbar-default navbar-inverse navbar-fixed-top">
                    <div class="navbar-header">
                        <p class="navbar-brand"><img src="static/images/vinay.jpg" alt="logo" style="width:25px;"></p>
                        <a class="navbar-brand" href="#">Exam Management App</a>
                        <button type="button" class="navbar-toggle" data-toggle="collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Contact</a></li>
                            <li><a href="./AboutUS">About</a></li>
                            <li><a href="#">Products</a></li>
                        </ul>

                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="./studentForm"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                            <li><a href="./loginPage"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>

    <%-- Admin is logged in : Guest Menu --%>

</c:if>
<c:if test="${sessionScope.id!=null && sessionScope.role == 1}">

    <%-- Admin is logged in : Guest Menu --%>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <nav class="navbar-default navbar-inverse navbar-fixed-top">
                    <div class="navbar-header">
                        <p class="navbar-brand"><img src="../../static/images/vinay.jpg" alt="logo" style="width:25px;"></p>
                        <a class="navbar-brand" href="#">Exam Management App</a>
                        <button type="button" class="navbar-toggle" data-toggle="collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="navbar-collapse collapse dropdown show">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="./dashbord">Home</a></li>
<!--                            <li><a href="../addQuestionForm">Question Control</a></li>-->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="../addQuestionForm">Question Control</a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="./addQuestionForm">Question Control</a>
                                    <a class="dropdown-item" href="./ShowAllQuestions">Question List</a>
                            </li>

                            <li><a href="../findByAllStudent">Student Controller</a></li>
                            
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="../showSubRegist">Subject Controller</a>
                                <div class="dropdown-menu">
                                    <a class="dropdown-item" href="../showSubRegist">Subject Controller</a>
                                    <a class="dropdown-item" href="./showAllSubject">Subject List</a>
                            </li>

                        </ul>

                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="./saveStudenta"><span class="glyphicon glyphicon-user"></span>${sessionScope.student.name}</a></li>
                            <li><a href="${url_logout}"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>

</c:if>
<c:if test="${sessionScope.id!=null && sessionScope.role == 2}">

    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12">
                <nav class="navbar-default navbar-inverse navbar-fixed-top">
                    <div class="navbar-header">
                        <c:url var="logo_image" value="../static/images/vinay.jpg" />
                        <p class="navbar-brand"><img src="${logo_image}" alt="logo" style="width:25px;"></p>
                        <a class="navbar-brand" href="#">Exam Management App</a>
                        <button type="button" class="navbar-toggle" data-toggle="collapse">
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="../user/dashbord">Home</a></li>
                            <li><a href="../updateStudent/${sessionScope.id}">Edit Profile</a></li>
                            <li><a href="../useSelectLanguage/${sessionScope.id}">Exams</a></li>
                        </ul>

                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="../user/dashbord"><span class="glyphicon glyphicon-user"></span> ${sessionScope.student.name}</a></li>
                            <li><a href="${url_logout}"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>



</c:if>
