<%-- 
    Document   : jb_genre
    Created on : Dec 12, 2016, 7:34:59 PM
    Author     : jeffb
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.HashMap"%>
<%@page import="edu.uca.aca2016.chinook.jeffbanksz4l.ChinookGenreManager"%>
<%
    ChinookGenreManager cm = new ChinookGenreManager();
    HashMap<Integer, String> genres = cm.getGenres();
    request.setAttribute("genres", genres);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chinook Genre Manager</title>
        <style>body { font-family: Times New Roman, Verdana, sans-serif; }</style>
    </head>
    <body>
        <h1>Manage Genre</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${genres}" var="genre">
                    <tr>
                        <td>${genre.key}</td>
                        <td>${genre.value}</td>
                        <td><a href="?do=Edit&id=${genre.key}">Edit</a> <a href="?do=Edit&id=${genre.key}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
