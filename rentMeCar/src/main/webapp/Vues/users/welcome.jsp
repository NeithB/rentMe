<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<link rel="stylesheet" type="text/css" href="CSS/style.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
</head>
<body>

	<header class="text-white bg-dark p-3" id="">
			<div class="d-flex">
					<div>	
						<h5 class="btn btn-outline" style="margin-left:500px;margin-right:150px;">								
							<i class="fa-solid fa-house text-danger" ></i>					
							<a class="text-danger"  href="${pageContext.request.contextPath}/MembreController">Home</a>										
								
						</h5>
					</div>
					
					<div>		
						<a class="btn btn-outline-light" id="" href="${pageContext.request.contextPath}/MembreController?action=compte">Mon Compte</a>	
					</div>	
					&nbsp;&nbsp;&nbsp;
					<div class="l2">
						<a class=" btn btn-outline-light" href="#"><i class="fa-solid fa-phone"></i> Contactez nous</a>
					</div>	
					
				
			</div>				
	</header>
<main id="welc">
	<div class="container" >		
		<div class="text-center mb-2">
			<h1 class=" text-white wlc">Welcome</h1>
			<h4 class="text-white rent">- rent<spam class="text-danger">Me</spam>-</h4>	
		</div>
		<div id="fondT">
			<p class="text-white">Lorem ipsum dolor sit amet,
			  consectetur adipisicing elit. Quae velit veritatis ab
			  accusantium sapiente quas et ut a totam illum similique eius 
			  animi aliquam fugiat esse! Consequatur unde aperiam et!
			  Lorem ipsum dolor sit amet,
			  consectetur adipisicing elit. Quae velit veritatis ab
			  accusantium sapiente quas et ut a totam illum similique eius 
			  animi aliquam fugiat esse! Consequatur unde aperiam et!
			  Lorem ipsum dolor sit amet,
			  consectetur adipisicing elit. Quae velit veritatis ab
			  accusantium sapiente quas et ut a totam illum similique eius 
			  animi aliquam fugiat esse! Consequatur unde aperiam et!*
			  Lorem ipsum dolor sit amet,
			  consectetur adipisicing elit. Quae velit veritatis ab
			  accusantium sapiente quas et ut a totam illum similique eius 
			  animi aliquam fugiat esse! Consequatur unde aperiam et!
			  Lorem ipsum dolor sit amet,
			  consectetur adipisicing elit. Quae velit veritatis ab
			  accusantium sapiente quas et ut a totam illum similique eius 
			  animi aliquam fugiat esse! Consequatur unde aperiam et!</p>
		</div>
		
	</div>
</main>
</body>
</html>