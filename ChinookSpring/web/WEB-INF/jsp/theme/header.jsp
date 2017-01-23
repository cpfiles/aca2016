<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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

    <!-- Top container -->
    <div class="w3-container w3-top w3-black w3-large w3-padding" style="z-index:4">
      <button class="w3-btn w3-hide-large w3-padding-0 w3-hover-text-grey" onclick="w3_open();"><i class="fa fa-bars"></i>  Menu</button>
      <span class="w3-right">Chinook Spring</span>
    </div>

    <!-- Sidenav/menu -->
    <nav class="w3-sidenav w3-collapse w3-white w3-animate-left" style="z-index:3;width:300px;" id="mySidenav"><br>
      <div class="w3-container w3-row">
        <div class="w3-col s4">
          <img src="<c:url value="/media/img/avatar.png" />" class="w3-circle w3-margin-right" style="width:46px">
        </div>
        <div class="w3-col s8">
          <sec:authorize access="hasRole('ROLE_USER')">
          <c:if test="${pageContext.request.userPrincipal.name != null}">
            <span>Welcome, <strong>${pageContext.request.userPrincipal.name}</strong></span><br>
          </c:if>
          <!--
          <a href="#" class="w3-hover-none w3-hover-text-red w3-show-inline-block"><i class="fa fa-envelope"></i></a>
          <a href="#" class="w3-hover-none w3-hover-text-green w3-show-inline-block"><i class="fa fa-user"></i></a>
          <a href="#" class="w3-hover-none w3-hover-text-blue w3-show-inline-block"><i class="fa fa-cog"></i></a>
          -->
          </sec:authorize>
        </div>
      </div>
      <hr>

      <a href="#" class="w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black" onclick="w3_close()" title="close menu"><i class="fa fa-remove fa-fw"></i>  Close Menu</a>
      <a href="<c:url value="/" />" class="w3-padding"><i class="fa fa-dashboard fa-fw"></i>  Dashboard</a>
      
      <sec:authorize access="hasRole('ROLE_ADMIN')">
      <div class="w3-dropdown-hover">
        <a href="<c:url value="/artist/viewartist" />" class="w3-padding"><i class="fa fa-music fa-fw"></i>  Artists  <i class="fa fa-caret-down"></i></a>
        <div class="w3-dropdown-content w3-white w3-card-4">
          <a class="w3-padding w3-dark-grey" href="<c:url value="/artist/artistform" />"><i class="fa fa-plus-square fa-fw"></i>  Add Artist</a>
        </div>
      </div>
        
      <div class="w3-dropdown-hover">
        <a href="<c:url value="/album/viewalbum" />" class="w3-padding"><i class="fa fa-microphone fa-fw"></i>  Albums  <i class="fa fa-caret-down"></i></a>
        <div class="w3-dropdown-content w3-white w3-card-4">
          <a class="w3-padding w3-dark-grey" href="<c:url value="/album/albumform" />"><i class="fa fa-plus-square fa-fw"></i>  Add Album</a>
        </div>
      </div>
      </sec:authorize>
      
      <!--
      <a href="#" class="w3-padding"><i class="fa fa-eye fa-fw"></i>  Views</a>
      <a href="#" class="w3-padding"><i class="fa fa-users fa-fw"></i>  Traffic</a>
      <a href="#" class="w3-padding"><i class="fa fa-bullseye fa-fw"></i>  Geo</a>
      <a href="#" class="w3-padding"><i class="fa fa-diamond fa-fw"></i>  Orders</a>
      <a href="#" class="w3-padding"><i class="fa fa-bell fa-fw"></i>  News</a>
      <a href="#" class="w3-padding"><i class="fa fa-bank fa-fw"></i>  General</a>
      <a href="#" class="w3-padding"><i class="fa fa-history fa-fw"></i>  History</a>
      -->
      <a href="#" onclick="logoutFormSubmit();" class="w3-padding"><i class="fa fa-sign-out fa-fw"></i>  Logout</a><br><br>
      
      <form action="<c:url value="/j_spring_security_logout" />" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      </form>
    </nav>


    <!-- Overlay effect when opening sidenav on small screens -->
    <div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

    <!-- !PAGE CONTENT! -->
    <div class="w3-main" style="margin-left:300px;margin-top:43px;">