<%-- 
    Document   : artists
    Created on : Dec 7, 2016, 6:42:24 AM
    Author     : cfiles
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.HashMap"%>
<%@page import="edu.uca.aca2016.jdbc.cpfiles.ChinookManager"%>
<%
    ChinookManager cm = new ChinookManager();
    HashMap<Integer, String> artists = cm.getArtists();
    request.setAttribute("artists", artists);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chinook Artist Manager</title>
    <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
  </head>
  <body>
    <h1>Manage Artist</h1>
    <table border="1">
      <thead>
        <tr>
          <th>ID</th>
          <th>Name</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${artists}" var="artist">
        <tr>
          <td>${artist.key}</td>
          <td>${artist.value}</td>
          <td><a href="?do=Edit&id=${artist.key}">Edit</a> <a href="?do=Edit&id=${artist.key}">Delete</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  </body>
</html>
