<%@ include file="../_header.jsp"%>

<div class="container-fluid">
<h1 class="log text-white">Reservation en cours</h1>

<span class="text-success"><c:out value="${msg }"></c:out></span>
	
			
		
<div class="mt-4"></div>
	<table class="table table-striped">
		<thead>
			<tr class="table-dark text-center text-success">
			
				<th class="text-white" scope="col">Logo Agence</th>
				<th class="text-white" scope="col">Nom Agence</th>
				<th class="text-white" scope="col">ID Location</th>
				<th class="text-white" scope="col">Marque Vehicule</th>
				<th class="text-white" scope="col">Modele Vehicule</th>
				<th scope="col">Date de debut de reservation</th>
				<th class="text-white" scope="col">Logo Vehicule</th>
				<th scope="col">Date de fin de reservation</th>
				<th class="text-white" scope="col">Total</th>
				<th scope="col">Date de reservation</th>			
				<th class="text-white" scope="col">Action</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${locations}" var="liste">
				
				<tr class="text-center">
					
					<th class="ligne" style="padding:0px; margin:0px;" >
						<img src="./img/${liste.vehicule.agence.image}" alt="logo" class="border border-success img-fluid rounded imge" style="padding:4px; margin:2px; width:100px;"/>
					</th>
					<th class="text-white"><c:out value="${liste.vehicule.agence.nom}"/></th>					
					<th class="text-white"><c:out value="${liste.idL}"/></th>					
					<td class="text-white"><c:out value="${liste.vehicule.marque}"/></td>								
					<td class="text-white"><c:out value="${liste.vehicule.modele}"/></td>					
					<td class="text-success"><c:out value="${liste.dateDebut}"/></td>
					<th class="ligne" style="padding:0px; margin:0px;" >
						<img src="./img/${liste.vehicule.image}" alt="logo" class="border border-success img-fluid rounded imge" style="padding:4px; margin:2px; width:100px;"/>
					</th>					
					<td class="text-success"><c:out value="${liste.dateFin}"/></td>					
					<td class="text-white"><c:out value="${liste.total}"/>$</td>	
					<td class="text-success font-weight-bold"><c:out value="${liste.dateReservation}"/></td>					
					<td>
						<a class="btn btn-danger" href="${pageContext.request.contextPath}/LocationController?action=supprimer&idLo=${liste.idL}&idVehicule=${liste.vehicule.idV}">Annuler</a>						
					</td>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>


</div>
</body>
</html>