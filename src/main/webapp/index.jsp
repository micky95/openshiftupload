<%@page import="org.openshift.AudioProcessor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DB UPLOAD</title>
</head>
<body>
<h1>DB UPLOAD TEST</h1>
<p>
<%
out.println(new AudioProcessor().testConnection());
%>
</p>
<form method="post" action="fileupload.jsp" enctype="multipart/form-data">
Select file to upload:
<input type="file" name="dataFile" id="fileChooser"/><br/><br/>
<input type="submit" value="Upload" />
</form>
</body>
</html>
