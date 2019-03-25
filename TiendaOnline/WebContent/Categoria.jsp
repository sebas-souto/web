<<!DOCTYPE html>
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
<title>WELCOME</title>
</head>
<%@ page import="java.util.Vector" %>
<%@ page import="beans.Categoria" %>
<!--
***************************TABLA***************************************************
<table>	Definición de una tabla.
<th>	Definición de cabecera de tabla.
<tr>	Define una fila en la tabla.
<td>	Define una celda en la tabla.
<caption>	Define el nombre o título de la tabla.
<colgroup>	Especifica un grupo de una o más columnas para aplicar formato.
<col>	Especifica las propiedades de una columna de las columnas definidas en
un elemento colgroup
<thead>	Define la cabecera de la tabla.
<tbody>	Define el cuerpo de la tabla
<tfoot>	Define el pie de la tabla
<body>
***********************************************************************************

-->
<body style="background-image: url(http://sf.co.ua/14/01/wallpaper-58172.jpg);" >
<div class="container" style="text-align:left;">

<!-- 	<body style="background-color: DARKSALMON;" >-->
<h1  style="color:black;">Buenos dias, ${user}, COMIENZA TU DIA REALIZANDO LAS MEJORES COMPRAS!!!</h1>
	<%String mensaje=(String)request.getAttribute("mensaje"); %>
	<%String men=""; %>
	   <table class="table" style="width:100%">
	  	  <thead class="thead-dark">
  		<tr>
  			 <th><h2 style="text-align:left;">CATEGORIAS</h2></th>
 	   	 </tr>
 	   </thead>
 	   
 	  <c:forEach var="p" items="${categorias}">
 	   <tr>
 	   	<td><h3 style="text-align:left;"><a class="enlace" href="S_categoria?descripcion=${p.descripcion}">${p.descripcion}</a></h3></td> 		 
 	 </tr>
 	  	</c:forEach>
	
	 </table>
	
	<br>
	      <a class="nav-link" data-toggle="tab" href="miCarrito.jsp" > <h3 style="color:black;"></h3><img alt="Carrtito" src="https://st.depositphotos.com/1187563/2405/i/950/depositphotos_24059541-stock-photo-red-shopping-cart-icon.jpg" width=40 >Ver MiCarrito</h3></a>
	
	</div>
	
</body>
</html>