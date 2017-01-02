<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<html>
  <head>
    <title>Manage Artists</title>
    <style>body { font-family: Verdana, Geneva, sans-serif; }</style>
  </head>
  <body>

    <h1>Manage Artists</h1>  
    <a href="artistform">Add New Artist</a><br/><br/>
    <table border="1" width="70%" cellpadding="2">  
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Action</th>
      </tr>  

      <c:forEach var="artist" items="${list}">   
        <tr>  
          <td>${artist.id}</td>  
          <td>${artist.name}</td>  
          <td><a href="editartist/${artist.id}">Edit</a> <a href="deleteartist/${artist.id}">Delete</a></td>  
        </tr>  
      </c:forEach>  
    </table>  
    <br/> 
  </body>
</html>
