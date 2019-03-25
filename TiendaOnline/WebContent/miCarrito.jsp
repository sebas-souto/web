<!DOCTYPE html>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <meta charset="utf-8">
 <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<html>
<head>
<meta charset="ISO-8859-1">
<title>MiCarrito</title>
</head>
<%@ page import="java.util.Vector" %>
<%@ page import="beans.Categoria" %>
<!--

-->
<body style="background-image: url(http://sf.co.ua/14/01/wallpaper-58172.jpg);" >

<!-- 	<body style="background-color: DARKSALMON;" >-->
<h1  style="color:black; text-align:center;"> ${user}, estas a un paso de finalizar la compra!</h1>
<h2  style="color:black; text-align:center;"> Mi Carrito</h2>
<div class="container" style="text-align:left;">
	<%String mensaje=(String)request.getAttribute("mensaje"); %>
	<%String men=""; %>
	   <table class="table" style="width:100%">
	  	  <thead class="thead-dark">
  		<tr>
  			 <th><h2 style="text-align:left;">Descripcion</h2></th>
  			 <th><h2 style="text-align:left;">Precio unidad</h2></th>
  			<th><h2 style="text-align:left;">Cantidad</h2></th>
  			
 	   	 </tr>
 	   </thead>
 	   
 	  <c:forEach var="p" items="${miCarrito}">
 	   <tr>
 	   	<td><h3 style="text-align:left;"><a>${p.producto.descripcion}</a></h3></td> 		 
 	 
 	
 	   	<td><h3 style="text-align:left;"><a>${p.producto.precio} EUROS</a></h3></td> 		 
 	
 	 
 	   	<td><h3 style="text-align:left;"><a >${p.cantidad}</a></h3></td> 	
 	   	
 	   	<td><p style="text-align:right;"><a class="btn btn-danger" href="S_VerCarrito?id_producto=${p.producto.id_producto}">X</a></p></td> 
 	   		
 	 </tr>
 	  	</c:forEach>
 	  	 
	
	 </table>
	 
	<h3 style="text-align:right;"><a class="btn btn-success" href="S_comprar"> REALIZAR PEDIDO</a></h3>
	  <h3 style="text-align:center;"><a >TOTAL: ${total} EUROS</a></h3>
	 <h3><a class="btn btn-outline-primary" href="Categoria.jsp"> Volver</a></h3><br>
	 </div>
	 
	
	 
		
	<br>
	
	
	
</body>
</html>

