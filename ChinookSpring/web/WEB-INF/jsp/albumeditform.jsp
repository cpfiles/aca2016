<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<%@ include file="theme/header.jsp" %>

<header class="w3-container" style="padding-top:22px">
  <h5><b><i class="fa fa-dashboard"></i> Manage Artists > Edit Artist</b></h5>
</header>

<div class="w3-row-padding w3-half w3-margin-bottom">

  <div class="w3-card-4">
    <div class="w3-container w3-blue">
      <h2>Header</h2>
    </div>

    <form:form method="POST" action="/ChinookSpring/album/editsave" cssClass="w3-container">
      <form:hidden path="id"  />
      
      <div class="w3-padding-8">
        <label><b>Title</b></label>
        <form:input path="title" cssClass="w3-input w3-border"  />
      </div>
      
      <div class="w3-padding-8">
        <label><b>Artist</b></label>
        <form:select path="artistid" cssClass="w3-select w3-border" items="${command.artists}" />
      </div>
      
      <div class="w3-padding-8">
        <button type="submit" class="w3-btn w3-padding w3-blue" style="width:120px">Save</button>
      </div>
    </form:form>
    
  </div>
</div>

<%@ include file="theme/footer.jsp" %>