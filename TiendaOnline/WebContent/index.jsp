<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>WELCOME</title>
</head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<%String mensaje="";%>
<%
%>>

<body style="background-image: url(http://sf.co.ua/14/01/wallpaper-58172.jpg);" >

 	 <%@ page import="java.util.Date" %>
  
	<% Date fecha =new java.util.Date(); %>
	
	
	<!-- 
	
	prueba
	 -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

  <style>
  
  /* Make the image fully responsive */
  .carousel-inner img {
      width: 100%;
      height: 100%;
  }
  </style>
  
  <div id="demo" class="carousel slide ; container" data-ride="carousel" style="down;">>

  <!-- Indicators -->
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  
  <!-- The slideshow -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="http://ofertas.claropr.com/wp-content/uploads/2018/10/ROTATOR-OCT-IPHONE6-40.jpg" alt="Los Angeles" width="50" height="50">
    </div>
    <div class="carousel-item">
      <img src="https://www.actualidadiphone.com/wp-content/uploads/2017/11/iphone-x-yoigo-mas-barato.png" alt="Chicago" width="50" height="50">
    </div>
    <div class="carousel-item">
      <img src="http://ofertas.claropr.com/wp-content/uploads/2018/12/CLARO-ROTATOR-2PLAY-NUEVO.jpg" alt="New York" width="50" height="50">
    </div>
  </div>
  
  <!-- Left and right controls -->
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>


</head>
<body>

	<!--
	antes
	-->
	<br><br><div class="container";"  >
	<form class="form-signin" id="cv" name="cv" method="post" action="S_index">
	
			<span class="badge badge-pill badge-Usuario"><FONT SIZE=5>ENTRAR</FONT></span>
			
			<br> <h1></h1><span class="badge badge-pill badge-user"><FONT SIZE=3>Usuario</FONT></span></h1>:
			 	 <input type="text" class="form-control" placeholder="user" name="user" id="user" />
			<br> 
			<span class="badge badge-pill badge-password"><FONT SIZE=3>Password</span></span>:
				<input type="password" class="form-control"     placeholder="password" name="password" id="password" />
			<br> 
			
			 <br>
			 <input type="checkbox" name="remenber" value="Bike" >Recordar datos<br>
			 <input class="btn btn-lg btn-primary btn-block" type="submit" name="enviar" value="ENVIAR"> 
			 <input class="btn btn-lg btn-primary btn-block" type="reset" name="reset" value="RESET">
			 <br>
			 <div class="container";" >
			<% mensaje=(String)request.getAttribute("mensaje");
				if(mensaje!=null)out.print(mensaje);
				%>
			</div>
			<a class="enlace" href="registro.jsp">REGISTRATE</a>
		<!--  	 <%!int contadorVisitas=0;%>
		<span class="badge badge-pill badge-ha visitado esta pagina">ha visitado esta pagina</span>: <%=++contadorVisitas %>
		-->
	</form>
	</body>
	</div>
	
</body>
</html>