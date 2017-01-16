<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

  <header class="w3-container" style="padding-top:22px">
    <h5><b><i class="fa fa-dashboard"></i> Manage Artists</b></h5>
  </header>

  <div class="w3-row-padding w3-margin-bottom">

  <table class="w3-table w3-striped w3-bordered w3-border w3-hoverable w3-white">  
    <tr>
      <th>Name</th>
      <th>Action</th>
    </tr>  

    <c:forEach var="artist" items="${list}">   
      <tr>  
        <td>${artist.name}</td>  
        <td>
          <a href="editartist/${artist.id}"><button class="w3-btn w3-round w3-blue">Edit</button></a>
          <a href="deleteartist/${artist.id}"><button class="w3-btn w3-round w3-red">Delete</button></a>
        </td>  
      </tr>  
    </c:forEach>  
  </table> 

  <div class="w3-padding-8">
    <ul class="w3-pagination">
      <c:forEach begin="1" end="${pages}" varStatus="p">  
        <li><a class="<c:if test="${p.index eq page}">w3-green</c:if>" href="<c:url value="/artist/viewartist/${p.index}" />">${p.index}</a></li>
      </c:forEach>
    </ul>
  </div>
    
  </div>

<%@ include file="theme/footer.jsp" %>