<%-- 
    Document   : result
    Created on : Jul 28, 2017, 9:02:20 AM
    Author     : nagelsm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload Example in JSP and Servlet - Java web application</title>
    </head>
    <body>
        <div id="result">
            <h3>${requestScope["message"]}
                <br>
                ${requestScope["file"]}
                <br>
                ${requestScope["data"]}
                <br>
                <%
                out.println(request.getAttribute("data"));
                %>
            </h3>
        </div>
    </body>
</html>

