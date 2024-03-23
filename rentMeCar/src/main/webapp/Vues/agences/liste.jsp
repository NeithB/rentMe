<%@ include file="../_header.jsp"%>

<div class="container-fluid">
<h1 class="log text-light text-center">Liste/Agences</h1>
<hr class="text-light" />
	
	
			<a  class="btn btn-outline-success mb-2" href="${pageContext.request.contextPath}/AgenceController?action=addAgence">AJouter Une Agence</a>			
		
	<table class="table table-striped table-hover">
		<thead>
			<tr class="table-dark text-center">
				<th scope="col">Images</th>
				<th scope="col">ID Agence</th>
				<th scope="col">Nom</th>
				<th scope="col">Telephone</th>
				<th scope="col">Email</th>
				<th scope="col">Adresse</th>
				<th scope="col">Code Postal</th>
				<th scope="col">Ville</th>
				<th scope="col">Action</th>				
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listes}" var="liste">
				<tr class="text-center">				
					<th class="ligne" style="padding:0px; margin:0px;" >
						<img src="./img/${liste.image}" alt="logo" class="border border-dark img-fluid rounded imge" style="padding:4px; margin:2px; width:100px;"/>
					</th>	
				
					<td class="text-light"><c:out value="${liste.idA}"/></td>	
					<td class="text-light"><c:out value="${liste.nom}"/></td>	
					<td class="text-light"><c:out value="${liste.tel}"/></td>	
					<td class="text-light"><c:out value="${liste.email}"/></td>	
					<td class="text-light"><c:out value="${liste.adresse}"/></td>	
					<td class="text-light"><c:out value="${liste.cp}"/></td>	
					<td class="text-light"><c:out value="${liste.ville}"/></td>			
					<td>
					<a  href="${pageContext.request.contextPath}/AgenceController?action=supprimer&idAg=${liste.idA}" id="sup"><i  class="fa-solid fa-trash text-danger"></i></a>
					&nbsp;
					<a  href="${pageContext.request.contextPath}/AgenceController?action=modifier&idAg=${liste.idA}"><i class="fa-solid fa-pen"></i></a>
				</td>
				</tr>
			 </c:forEach>	
		</tbody>
	</table>
	

	
</div>
</body>
</html>