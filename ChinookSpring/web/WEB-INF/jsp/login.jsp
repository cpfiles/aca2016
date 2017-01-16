<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
  <title>Chinook Spring Manager</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <style>html,body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}</style>
  <body class="w3-light-grey">

    <div class="w3-container">
      <br/><br/>

      <div id="id01">
        <div class="w3-modal-content w3-card-8 w3-animate-zoom" style="max-width:600px">

          <div class="w3-center"><br>
            <span onclick="document.getElementById('id01').style.display = 'none'" class="w3-closebtn w3-hover-red w3-container w3-padding-8 w3-display-topright" title="Close Modal">&times;</span>
            <img src="<c:url value="/media/img/avatar.png" />" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top">
          </div>

          <form id="loginForm" class="w3-container" action="<c:url value='/j_spring_security_login' />" method='POST'>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <div class="w3-section">
              <c:if test="${not empty msg}">
              <div class="w3-panel w3-border w3-pale-blue w3-round-large"><p>${msg}</p></div>
              </c:if>
              <c:if test="${not empty error}">
              <div class="w3-panel w3-border w3-pale-red w3-round-large"><p>${error}</p></div>
              </c:if>
              
              <label><b>Username</b></label>
              <input class="w3-input w3-border w3-margin-bottom" type="text" placeholder="Enter Username" name="username" required>
              <label><b>Password</b></label>
              <input class="w3-input w3-border" type="password" placeholder="Enter Password" name="password" required>
              <button class="w3-btn-block w3-green w3-section w3-padding" type="submit">Login</button>
            </div>
          </form>

        </div>
      </div>
    </div>

  </body>
</html>