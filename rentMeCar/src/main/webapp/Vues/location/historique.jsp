<%@ include file="../_header.jsp"%>

<div class="container-fluid">

	<h1 class="log text-light">Historique des reservations</h1>


<span class="text-success"><c:out value="${msg }"></c:out></span>
	
				
		
<div class="mt-4"></div>
	<table class="table table-striped">
		<thead>
			<tr class="table-dark text-center">
			
				<th scope="col">Image</th>
				<th scope="col">ID Location</th>
				<th scope="col">Marque Vehicule</th>
				<th scope="col">Modele Vehicule</th>
				<th class="text-danger" scope="col">Date de debut de reservation</th>
				<th class="text-danger" scope="col">Date de fin de reservation</th>
				<th scope="col">Total</th>
				<th class="text-danger" scope="col">Date de reservation</th>			
							
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${locations}" var="liste">
				
				<tr class="text-center">
					<th class="ligne" style="padding:0px; margin:0px;" >
						<img src="./img/${liste.vehicule.image}" alt="logo" class="border border-dark img-fluid rounded imge" style="padding:4px; margin:2px; width:100px;"/>
					</th>	
					<th class="text-white"><c:out value="${liste.idL}"/></th>					
					<td class="text-white"><c:out value="${liste.vehicule.marque}"/></td>					
					<td class="text-white"><c:out value="${liste.vehicule.modele}"/></td>					
					<td class="text-danger">
						<c:out value="${liste.dateDebut}"/>
					</td>					
					<td class="text-danger">
						<c:out value="${liste.dateFin}"/>
					</td>					
					<td class="text-white"><c:out value="${liste.total}"/></td>	
					<td class="text-danger">
						<c:out value="${liste.dateReservation}"/>
					</td>					
				</tr>
				
			</c:forEach>
		</tbody>
	</table>

<%-- 	<a class="btn btn-outline-success" id="" href="${pageContext.request.contextPath}/VehiculeController?action=addVcl">Ajouter Vehicule</a> --%>
</div>
</body>
</html>