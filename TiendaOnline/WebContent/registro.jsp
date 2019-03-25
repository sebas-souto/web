<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     			   <!--  REGISTRARSE -->
     			   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
     			   
 <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>REGISTRO</title>
</head>
<!-- Bootstrap CSS -->

<!-- ***********************************************************************************************************
							SINTAXIS LINK 
****************************************************************************************************************
SE ABRE RECURSO CON <link Y SE HA DE INDICAR DOS PARAMETROS(REL Y HREF) COMO MINIMO.

*****<link> especifica la relación entre el documento actual y un recurso externo. 
Los usos posibles de este elemento incluyen la definición de un marco relacional para navegación. 
Este elemento es más frecuentemente usado para enlazar hojas de estilos.

*****rel: describe la relación que mantiene el documento de destino con el documento presente (el que enlaza).

*****href: Este atributo especifica la URL del recurso enlazado. La URL debe ser absoluta o relativa.

*****integrity: Contiene información de metadatos que es usada por el user agent 
del navegador para verificar el recurso captado fue entregado libre de manipulación inesperada

*****crossorigin:Elementos normales script pasan información mínima al window.onerror para scripts que no pasan las revisiones del estándar CORS.
Para permitir registrar errores en los sitios que usan dominios separados para recursos estáticos, usar este atributo.

SCRIPT PRECISA PRINCIPALMENTE UN PARAMETRO, SRC

*****<script>: se utiliza para insertar o hacer referencia a un script ejecutable dentro de un documento HTML o XHTML.

*****src: Este atributo especifica la URI del script externo; este puede ser usado como alternativa a scripts embebidos directamente
en el documento. Si el script tiene el atributo src, no debería tener código dentro de la etiqueta.

****************************************************************************************************************
****************************************************************************************************************
 -->

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<!-- CAPTCHA -->

<script src='https://www.google.com/recaptcha/api.js'></script>
<script src='https://www.google.com/recaptcha/api.js?hl=es'></script>

<!--
****************************************************************************************************************
						SINTAXIS: BODY, FORM,INPUT,BR,SPAN 
****************************************************************************************************************

##BODY:representa el contenido de un documento HTML. Sólo puede haber un elemento <body> en un documento.

##FORM:representa una sección de un documento que contiene controles interactivos que permiten a un usuario enviar información
a un servidor web.

##INPUT:se usa para crear controles interactivos para formularios basados en la web, que reciban datos del usuario. 
La forma en que <input> funciona varía considerablemente dependiendo del valor de su atributo type.

##BR: <br> indica salto de linea. Se posiciona igual al \n de java.Este deberá ser el siguiente elemento de un <html> elemento.

##SPAN: Es un contenedor en línea. Sirve para aplicar estilo al texto o agrupar elementos en línea.

****************************************************************************************************************
				ATRIBUTOS: CLASS,ID,NAME,METHOD, ACTION, TYPE, VALUE.
****************************************************************************************************************
##CLASS:El atributo global class es una lista de las clases del elemento separada por espacios .
Las clases permiten a CSS y Javascript seleccionar y acceder a elementos específicos a través 
de los selectores de clase o funciones como el método document.getElementsByClassName del DOM.

##ID
##NAME
##METHOD
##ACTION
##TYPE
##VALUE

****************************************************************************************************************
<%String mensaje="";%>

-->
<body style="background-image: url(http://sf.co.ua/14/01/wallpaper-58172.jpg);" >

<div class="container register-form">
	<form class="form-signin" id="cv" name="cv" method="post" action="S_registro">
		 <div class="note">
		 	 <span class="badge badge-pill badge-User" >NUEVO USUARIO</span>
		 </div><br><br>
			<span class="badge badge-pill badge-User" >User</span>:
			 	 <input type="text" class="form-control" placeholder="user" name="user" id="user" value='${user}' />
			<br> 
			<span class="badge badge-pill badge-Password">Password</span>:
				<input  type="password"  class="form-control" placeholder="password" name="password" id="password"  />
			<br> 
			
			 <span class="badge badge-pill badge-email">EMAIL</span>:
			
			<input type="text" class="form-control" placeholder="email" name="email" id="email" value='${email}' /> <br>
		
			
			 <br>
			 <input class="btn btn-lg btn-primary btn-block" type="submit" name="enviar" value="ENVIAR"> 
			 <input class="btn btn-lg btn-primary btn-block" type="reset" name="reset" value="RESET">
			 <br>
			
				<% mensaje=(String)request.getAttribute("mensaje");
				if(mensaje!=null)out.print(mensaje); mensaje="";
				%>
				
					
				<a class="enlace" href="index.jsp"> Volver</a>
			
	 </form>
	</div>
		
</body>
</html>