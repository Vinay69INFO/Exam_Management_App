<%-- 
    Document   : testCheckbox
    Created on : 1 Dec, 2019, 2:38:59 PM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:url var="url_jqlib" value="/static/js/jquery-3.4.1.min.js" />
        <script src="${url_jqlib}"></script>
        <script>
           $(document).ready(function () {
               var id=10;
            $("#id_get_time").click(function () {
                               
                $.ajax({
                    url: 'check_avail',
                    data: {"id":id},
                    success: function (data) {
                        alert("hello"+data);
                    }
                });
            });
        });
        </script>
</head>
<body>
    <form>
        <c:forEach items="${subjectList}" var="subject">
            <input type="checkbox" name="sub" value="${subject.sub_id}">${subject.name} <br>    
            <input type="hidden" name="sub" value="${subject.name}">
        </c:forEach>

        <button id="id_get_time">Add Subject to Student</button>
    </form>
    
    
    
        <p id="id_time"></p>

</body>
</html>
