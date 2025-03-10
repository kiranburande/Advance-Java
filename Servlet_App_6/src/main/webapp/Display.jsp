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
  String userId = request.getParameter("id");
  String userFName = request.getParameter("fname");
  String userLName = request.getParameter("lname");
  String mailId = request.getParameter("mailid");
  long phNo = Long.parseLong(request.getParameter("phno"));
  
  out.println("<h2>User id is ->"+userId);
  out.println("<br>User First Name is -> "+userFName);
  out.println("<br>User Last Name is -> "+userLName);
  out.println("<br>User Mail Id is -> "+mailId);
  out.println("<br>User Phone No is -> "+phNo+"</h2>");
  %>
</body>
</html>