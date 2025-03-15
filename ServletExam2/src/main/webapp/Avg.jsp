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
   double v1 = Double.parseDouble(request.getParameter("value1"));
   double v2 = Double.parseDouble(request.getParameter("value2"));
   double v3 = (v1+v2)/2;
   
   out.println("Average is : "+v3);
 %>

</body>
</html>