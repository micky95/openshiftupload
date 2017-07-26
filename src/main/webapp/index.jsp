<%@page import="org.openshift.InsultGenerator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insult Generator</title>
</head>
<body>
<h1>TEST</h1>
<p>
<%
out.println(new InsultGenerator().generateInsult());
%>
</p>
<form method="post" action="fileupload.jsp" enctype="multipart/form-data">
Select file to upload:
<input type="file" name="dataFile" id="fileChooser"/><br/><br/>
<input type="submit" value="Upload" />
</form>
</body>
</html>
