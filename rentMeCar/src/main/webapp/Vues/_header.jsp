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
	<header class="text-center bg-dark p-3">
				
		<c:choose>
				<c:when test="${!empty sessionScope.user}">
				
					<div  class="d-flex" id="cove">
							
							<div>	
										<h5 class="btn btn-outline" style="margin-right:70px;">								
											<i class="fa-solid fa-house text-danger" ></i>					
											<a class="text-danger"  href="${pageContext.request.contextPath}/MembreController">Home</a>										
												
										</h5>
									</div>
							
							<c:if test="${sessionScope.user.statut=='ADMIN'}">					
								<div class="">
									<a class="text-white btn btn-outline" id="" href="${pageContext.request.contextPath}/MembreController?action=listeMbre">Membres</a>
									<a class="text-white btn btn-outline" id="" href="${pageContext.request.contextPath}/AgenceController?action=listeAgence">Agences</a>		
									<a class="text-white btn btn-outline" id="" href="${pageContext.request.contextPath}/VehiculeController?action=listeVcl">Vehicule</a>	
								
								</div>
								<div class="l2">
									<a class="text-white btn btn-outline" href="VehiculeController?action=dispo">Disponible <i class="fa-solid fa-gear"></i></a>
								</div>
								<div class="l2">
									<a class=" btn btn-outline" href="${pageContext.request.contextPath}/MembreController?action=deconnexion"><spam class="text-danger"><i class="fa-solid fa-power-off"></i></spam></a>
								</div>
							</c:if>
							<c:if test="${sessionScope.user.statut=='CLIENT'}">
									
									<div class="dropdown">
										  
										  <a class="text-white btn btn-outline dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
										  <i class="fa-solid fa-user text-white"></i> 
										  </a>
										  <ul class="dropdown-menu" style="padding:4px;">
											    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/LocationController?action=historique&id=${sessionScope.user.idM}">Consulter l'historique des Locations</a></li>
											    <li><hr style="margin:0px;padding:0px;"/>
											    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/LocationController?action=encours&id=${sessionScope.user.idM}">Consulter les locations en cours</a></li>				   
											    <li><hr style="margin:0px;padding:0px;"/></li>
											    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/MembreController?action=deconnexion">Deconnexion</a></li>
										 					 
										  </ul>										  
									</div>
									<div class="l2">
										<a class="text-white btn btn-outline" href="#">Contactez-nous <i class="fa-solid fa-phone"></i></a>
									</div>					
									</c:if>
									<div>								
										 <form  class="d-flex" role="search">
										        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
										        <button class="btn btn-outline-success" type="submit">Search</button>
										 </form>						
									</div>
									<div>
										<p class=" btn btn-outline text-white">
											<i class="fa-solid fa-globe text-success"></i>
											<em class=""><c:out  value="${sessionScope.user.prenom} ${sessionScope.user.nom}"/></em>
										</p>								
									</div>
					</div>
				</c:when>
				<c:otherwise>
										
						<div style="margin:0px; padding:0px;">	
							<h5 style="margin:0px; padding:0px;" >	
									<img src="./img/logo.png" alt="" heigth="100px" width="100px" style="margin-left:-150px; padding:0px;" />																							
							</h5>
						</div>
					
				
				</c:otherwise>			
		</c:choose>
	</header>
	
	