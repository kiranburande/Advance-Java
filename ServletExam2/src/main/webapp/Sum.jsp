<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
  int v1 = Integer.parseInt(request.getParameter("value1"));
  int v2 = Integer.parseInt(request.getParameter("value2"));
  int sum = v1+v2;
  
  out.print("Sum is :" +sum);
   
  %>
</body>
</html>