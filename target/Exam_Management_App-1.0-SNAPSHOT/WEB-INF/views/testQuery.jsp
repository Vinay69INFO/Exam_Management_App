<%-- 
    Document   : testQuery
    Created on : 30 Nov, 2019, 10:14:42 AM
    Author     : vinay
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <s:url var="url_jqlib" value="/static/js/jquery-3.4.1.min.js" />
        <script src="${url_jqlib}"></script>
        <script>
            $(document).ready(function(){
               // alert('JQuery is ready and integrated');
               $("#id_get_time").click(function(){
                   //alert('Button clicked....');
                   $.ajax({
                       url : 'get_time',
                       success : function(data){
                           $("#id_time").html(data);
                       }
                   });
               });
            });
        </script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <button id="id_get_time">Get Server Time</button>
        <p id="id_time"></p>
        
        <form>
            <select>
                <input type="text" name=""
            </select>
        </form>
    </body>
</html>
