<%-- 
    Document   : result
    Created on : Jul 28, 2017, 9:02:20 AM
    Author     : nagelsm
--%>
<%@page import="org.openshift.AudioProcessor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                for (byte b: (byte[])request.getAttribute("data")){
                    out.println(new AudioProcessor().setDPData(b));
                    //out.println(new AudioProcessor().setDPData(b));
                }
                
                %>
            </h3>
        </div>
    </body>
</html>

