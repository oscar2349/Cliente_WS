<%-- 
    Document   : newjsp
    Created on : 26/05/2020, 04:47:54 PM
    Author     : Sammy Guergachi <sguergachi at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <%
            String msg = (String) session.getAttribute("servletMsg");
            out.print(msg);
        %>
    </body>
</html>
