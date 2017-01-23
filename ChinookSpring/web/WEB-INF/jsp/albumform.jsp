<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
  <h5><b><i class="fa fa-dashboard"></i> Manage Albums > Add Album</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

  <div class="w3-card-4">
    <div class="w3-container w3-blue">
      <h2>Album Information</h2>
    </div>

    <form:form method="post" action="/ChinookSpring/album/save" cssClass="w3-container">
      <div class="w3-padding-8">
        <label><b>Title</b></label>
        <form:input path="title" cssClass="w3-input w3-border"  />
      </div>
      
      <c:choose>
      <c:when test="${not empty command.artist}">
        <form:hidden path="artistid" />
        <div class="w3-padding-8">
          <label><b>Artist</b></label>
          <div class="w3-panel w3-border">
            <p><b>${command.artist.name}</b></p>
          </div>
         </div>
      </c:when>
      
      <c:otherwise>
        <div class="w3-padding-8">
          <label><b>Artist</b></label>
          <form:select path="artistid" cssClass="w3-select w3-border">
              <form:option value="-1">Select Artist</form:option>
              <form:options items="${command.artists}"  />
          </form:select>
        </div>
      </c:otherwise>
      </c:choose>
      
      <div class="w3-padding-8">
        <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
      </div>
    </form:form>
  </div>

</div>

<%@ include file="theme/footer.jsp" %>