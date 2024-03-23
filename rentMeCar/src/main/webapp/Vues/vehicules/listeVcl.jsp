<%@ include file="../_header.jsp"%>

<div class="container-fluid">
<h1 class="log text-light text-center">Liste/Vehicules</h1>
<hr class="text-light" />

<span class="text-success"><c:out value="${msg }"></c:out></span>
				
<a class="btn btn-outline-success" id="" href="${pageContext.request.contextPath}/VehiculeController?action=addVcl">Ajouter Vehicule</a>	
<div class="mt-2"></div>
	<table class="table table-dark table-bordered table-striped">
		<thead>
			<tr class="table-dark  text-center">
			
				<th  scope="col"></th>
				<th class="text-primary" scope="col">ID Vehicule</th>
				<th class="text-primary" scope="col">Marque</th>
				<th class="text-primary" scope="col">Model</th>
				<th class="text-primary" scope="col">Prix Journalier</th>
				<th class="text-primary" scope="col">Description</th>
				<th class="text-primary" scope="col">Nom Agence</th>
				
				<th class="text-primary" scope="col">Action</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listesV}" var="liste">
				<tr class="text-center">	
					<th class="ligne" style="padding:0px; margin:0px;" >
						<img src="./img/${liste.image}" alt="logo" class="border border-dark img-fluid rounded imge" style="padding:4px; margin:2px; width:100px;"/>
					</th>			
					<th class="text-light"><c:out value="${liste.idV}"/></th>		
					<td class="text-light"><c:out value="${liste.marque}"/></td>	
					<td class="text-light"><c:out value="${liste.modele}"/></td>	
					<td class="text-light"><c:out value="${liste.prixJ}"/></td>	
					<td class="text-light"><c:out value="${liste.description}"/></td>	
					<td class="text-light"><c:out value="${liste.agence.nom}"/></td>		
					<td>
						<a href="${pageContext.request.contextPath}/VehiculeController?action=supprimer&idV=${liste.idV }"><i class="fa-solid fa-trash text-danger"></i></a>
						&nbsp;
						<a  href="${pageContext.request.contextPath}/VehiculeController?action=modifier&idV=${liste.idV }"><i class="fa-solid fa-pen"></i></a>
				</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>