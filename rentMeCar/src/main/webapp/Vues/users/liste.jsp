<%@ include file="../_header.jsp"%>

<div class="container-fluid">
	<h1 class="log text-light">Liste des Membres</h1>
	
	<hr class="text-white"/>	
	<a class="btn btn-outline-success" href="${pageContext.request.contextPath}/MembreController?action=ajouter">AJouter Un Membre</a>
	<div class="mt-2"></div>
	<table class="table table-striped">
		<thead>
			<tr class="table-dark text-center">
				<th scope="col">ID Membre</th>
				<th scope="col">Login</th>
				<th scope="col">Prenom</th>
				<th scope="col">Nom</th>
				<th scope="col">Telephone</th>
				<th scope="col">Email</th>
				<th scope="col">Adresse</th>
				<th scope="col">Code Postal</th>
				<th scope="col">Ville</th>
				<th scope="col">Statut</th>
				<th scope="col">Date Inscription</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listes}" var="liste">
				<tr class="text-center">
					<th class="text-light"><c:out value="${liste.idM}" /></th>
					<td class="text-success"><c:out value="${liste.login}" /></td>
					<td class="text-light"><c:out value="${liste.prenom}" /></td>
					<td class="text-light"><c:out value="${liste.nom}" /></td>
					<td class="text-light"><c:out value="${liste.tel}" /></td>
					<td class="text-light"><c:out value="${liste.email}" /></td>
					<td class="text-light"><c:out value="${liste.adresse}" /></td>
					<td class="text-light"><c:out value="${liste.cp}" /></td>
					<td class="text-light"><c:out value="${liste.ville}" /></td>
					<td class="text-light"><c:out value="${liste.statut}" /></td>
					<td class="text-light"><c:out value="${liste.date_inscr}" /></td>
					<td><a
						href="${pageContext.request.contextPath}/MembreController?action=supprimer&idUser=${liste.idM }"><i
							class="fa-solid fa-trash text-danger"></i></a> &nbsp; <a
						href="${pageContext.request.contextPath}/MembreController?action=modifier&idUser=${liste.idM }"><i
							class="fa-solid fa-pen"></i></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>
</body>
</html>