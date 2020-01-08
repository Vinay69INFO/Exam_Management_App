<%-- 
    Document   : loginPage
    Created on : 16 Dec, 2019, 4:50:31 PM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../commonLib/cdnLink.jsp" /> 
                <link href="static/css/globalStyle.css" rel="stylesheet" type="text/css">

        <link href="static/css/loginStyle.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <jsp:include page="./components/header.jsp" />
        <br><br><br>
        <section class="login-block">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 login-sec">
                        <h2 class="text-center">Login Now</h2>
                        <c:if test="${err !=null}">
                            <p style="color:red;">${err}</p>
                        </c:if>
                        <c:if test="${param.act eq 'lo'}">
                            <p style="color:green;">Logout Successfully! Thanks for using Exam Management application.</p>
                        </c:if>
                        <c:url var="url_login" value="/login" />
                        <f:form class="login-form" action="${url_login}" modelAttribute="command">
                            <div class="form-group">
                                <label for="exampleInputEmail1" class="text-uppercase">Username</label>
                                <f:input type="text" path="username" class="form-control" placeholder="" />

                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1" class="text-uppercase">Password</label>
                                <f:input type="password" path="password" class="form-control" placeholder="" />
                            </div>


                            <div class="form-check">
                                <label class="form-check-label">
                                    <input type="checkbox" class="form-check-input">
                                    <small>Remember Me</small>
                                </label>
                                <button type="submit" class="btn btn-login float-right">Submit</button>
                            </div>

                        </f:form>
                    </div>
                    <div class="col-md-8 banner-sec">
                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active">
                                    <img class="d-block img-fluid" style="width: 100%" src="https://static.pexels.com/photos/33972/pexels-photo.jpg" alt="First slide">
                                    <div class="carousel-caption d-none d-md-block">
                                        <div class="banner-text">
                                            <h2>This is Heaven</h2>
                                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation</p>
                                        </div>	
                                    </div>
                                </div>
                            </div>	   

                        </div>
                    </div>
                </div>
        </section>
    </body>
</html>
