<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PRODUCTOS</title>
</head>
<body style="background-image: url(http://sf.co.ua/14/01/wallpaper-58172.jpg);" >

<!-- 	<body style="background-color: DARKSALMON;" >-->


<div class="container mt-3">
  <h2>Hola, ${user}</h2>
  <br>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs">
    <li class="nav-item">
      <a class="nav-link active" data-toggle="tab" href="#Categorias"><h3 style="color:black;">Productos</h3></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="Categoria.jsp"><h3 style="color:black;">Selecionar otra Categoria</h3></a>
    </li>
    <li class="nav-item">
      <a class="nav-link" data-toggle="tab" href="miCarrito.jsp" > <h3 style="color:black;"></h3><img alt="Carrito" src="https://st.depositphotos.com/1187563/2405/i/950/depositphotos_24059541-stock-photo-red-shopping-cart-icon.jpg" width=40 >MiCarrito</h3></a>
    </li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div id="home" class="container tab-pane active"><br>
      <h3>PRODUCTOS</h3>
      <p>
       <!-- AQUI COMIENZA EL MENU PROPIO DE LA CATEGORIA ELEGIDA -->
      <br>
<br>
<h1 style="text-align:center;">${descripcion}</h1></th>
	   <table class="table" style="width:100%">
	  	  <thead class="thead-dark">
  			<tr>
  			 <th><h2 style="text-align:left;">Descripcion</h2></th>
  	 		 <th><h2 style="text-align:left;">Precio</h2></th> 
 	   		 <th><h2 style="text-align:left;" >Stock</h2></th>
 	   	   </tr>
 	  	 </thead>
 	   <tr>
		<c:forEach var="p" items="${productos}">
 
    	<td><h3>${p.descripcion}</h3></td>
  	    <td><h3 >${p.precio}</h3></td> 
 	    <td><h3 >${p.stock}</h3></td>
 	     <td><a class="btn btn-danger" data-dismiss="modal" href="S_Carrito?id_producto=${p.id_producto}">Añadir al carrito</a></td>
 	 </tr>
	</c:forEach>
	
	 </table>
<h3><a class="btn btn-outline-primary" href="Categoria.jsp"> Volver</a></h3><br>

      </p>

  </div>
</div>


</body>
</html>