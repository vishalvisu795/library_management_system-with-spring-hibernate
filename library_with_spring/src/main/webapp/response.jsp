<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<%@page isELIgnored = "false"%> 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>

body
{
  background-color:violet;
}
h1{
  
  margin-top:200px;
  margin-left:500px;
  content-align:center;
  height:200px;
  length:100px;
}
h3
{
   margin-top:50px;
   margin-left:600px;
}

</style>
</head>
<body>
<h1>RESPONSE___PAGE</h1>
<h1>
<a href=${link}><button   type="button" id="button" class="btn btn-primary btn-lg">${response}</button></a>
</h1>
<hr>

</body>
</html>