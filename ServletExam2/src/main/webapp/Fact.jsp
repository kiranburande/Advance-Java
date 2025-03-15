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
  int v3=v1;
  int v4=v2;
  int sum1 =1, sum2=1;
  while(v3!=0)
  {
	  sum1 = sum1 * v3;
	  v3--;
  }
  while(v4!=0)
  {
	  sum2 = sum2 * v4;
	  v4--;
  }
  
  out.println("Factorial of "+v1+" is :"+sum1);
  out.println("Factorial of "+v2+" is :"+sum2);
   
  %>

</body>
</html>