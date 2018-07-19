<%-- 
    Document   : insertNumber
    Created on : Jul 18, 2018, 10:24:20 PM
    Author     : Mayada
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>


        <form action = "http://localhost:8080/BubbleSortAPI/api/version1/BubbleSortingNumber/insertNumber" method = "POST">
            Number: <input type = "text" name = "number">
            <br />
            <input type = "submit" value = "insert" />
        </form>
    </body>
</html>
