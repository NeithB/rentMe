<%@ include file="../_header.jsp"%>

<main class="bg-dark" id="prinEs">
	<div class="container">
		<h1 class="log text-dark"> Espace Membre</h1>
		<hr />
	
	
				
		<div class="row" style="padding:30px;">
	
			<c:forEach items="${locs }" var="dispo">
				
					<div class="card col-3" id="cared" style="width: 14rem; margin:0px 10px;">
						<div>
							<img src="./img/${dispo.vehicule.image}" class="card-img-top" alt="logo" style="padding:3px 0px; height:100px;">
						</div>	
						<div class="card-body p-0 m-0">
							
							<p class="card-title text-white m-0 p-0">Marque: <spam class="text-primary"> <em><c:out value="${dispo.vehicule.marque}"/></em></spam></p>							
							<p class="card-title text-white m-0 p-0 ">Modele: <spam class="text-primary"><em><c:out value="${dispo.vehicule.modele}"/></em></spam></p>	
							<p class="card-title text-white m-0 p-0 ">Description: <spam class="text-primary"><em> <c:out value="${dispo.vehicule.description}"/></em></spam></p>	
							<p class="card-title text-white m-0 p-0 ">Agence: <spam class="text-warning"><em> <c:out value="${dispo.vehicule.agence.nom}"/></em></spam></p>	
							<p class="text-center m-0 d-grid gap-2">
								<a href="${pageContext.request.contextPath}/LocationController?action=reserver&idV=${dispo.vehicule.idV }" class="btn btn-success m-2">Louer vehicule</a>					
							</p>
						</div>
					</div>
				
			</c:forEach>
		</div>	
	</div>
</main>
</body>
</html>