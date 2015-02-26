<%-- 
    Document   : signout
    Created on : Feb 26, 2015, 1:41:33 PM
    Author     : anurag
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>signout</title>
    </head>
    <body>
      <%
      session.invalidate();
      response.sendRedirect("index.jsp");
      %>
    </body>
</html>
