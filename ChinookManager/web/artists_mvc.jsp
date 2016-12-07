<%-- 
    Document   : artists
    Created on : Dec 7, 2016, 6:42:24 AM
    Author     : cfiles
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chinook Artist Manager</title>
    <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
  </head>
  <body>
    
    <c:if test="${not empty message}">
      <span style="color: red;">${message}</span>
    </c:if>
    
    <form method="post">
    <c:choose>
      <c:when test="${dothis eq 'Delete'}">
        <h1>Delete Artist</h1>
        <input type="hidden" name="id" value="${id}" />
        Are you sure you want to delete artist "${artist_name}"
        <input type="submit" value="Delete" name="action" />
      </c:when>
      <c:when test="${dothis eq 'Edit'}">
        <h1>Edit Artist</h1>
        <input type="hidden" name="id" value="${id}" />
        Artist Name: <input type="text" name="name" value="${artist_name}" />
        <input type="submit" value="Edit" name="action" />
      </c:when>
      <c:otherwise>
        <h1>Add an Artist</h1>
        Artist Name: <input type="text" name="name" />
        <input type="submit" value="Add" name="action" />
      </c:otherwise>
    </c:choose>
    </form>
            
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
          <td><a href="?do=Edit&id=${artist.key}">Edit</a> <a href="?do=Delete&id=${artist.key}">Delete</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>

  </body>
</html>
