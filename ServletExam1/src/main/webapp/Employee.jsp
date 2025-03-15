<%@page import="java.io.PrintWriter"%>
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
     String id = request.getParameter("id");
     String name = request.getParameter("name");
     String desg = request.getParameter("desg");
     double bsal = Double.parseDouble(request.getParameter("bsal"));
     double hra = bsal*0.93;
     double da = bsal*0.61;
     double tsal = bsal+hra+da;
     
     out.println("Employee id :"+id);
     out.println("Employee Name :"+name);
     out.println("Employee Desg :"+desg);
     out.println("Basic Salary :"+bsal);
     out.println("Total Salary :"+tsal);
   %>

</body>
</html>