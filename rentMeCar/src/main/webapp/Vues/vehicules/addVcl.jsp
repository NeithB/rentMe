<%@ include file="../_header.jsp"%>
<main id="principal_inscr" style="height:74vh;">

	<h1 class="log" id="">AJouter/Vehicules</h1>
	
	<div class="container ">
	
	<hr class="text-white" style=""/>
	
		<div class="mt-4"></div>
		
		
		
		<c:if test="${verifie }">
				<span class="p-3 text-warning"><em>Le Vehicule existe deja! changez la marque</em></span>
			</c:if>
		
		<form action="${pageContext.request.contextPath}/VehiculeController" method="post" id="myform" enctype="multipart/form-data">
			
			
			<div class="row" >
					<div class="col-6">			
										
							<div class="mb-2">
					   		 	  <label for="" class="text-white font-weight-bold txt">Votre Image</label>
					   		 	  <input type="file" onchange="visualiserImg(this.files)" accept="image/*" class="form-control inputVerif" name="photo" >
							</div>											
							<div class="mb-2">	
								<input type="text" class="form-control inputVerif" value="<c:out value="${vehicule.marque }" />"  name="marque" placeholder="Veillez indiquer la marque" minlength="2" maxlength="15">
							</div>
						
							<div class="mb-2">
								<input type="text" class="form-control inputVerif" value="<c:out value="${vehicule.modele }" />"  name="modele" placeholder="Veillez indiquer le modele" minlength="2" maxlength="15">
							</div>
						</div>					
						<div class="col-6">
							<div class="mb-2">	
								<label for="" class="text-white font-weight-bold txt">Selectionner une Agence</label>		
								<select name="agence" id="" class="form-select">
									<c:forEach items="${requestScope.listes}" var="liste">
										<option value="${liste.idA }" <c:if test="${liste.idA == vehicule.agence.idA}">selected</c:if>>					
											<c:out value="${liste.nom}"  />
										</option>
									</c:forEach>
								</select>					
							</div>			
					        <div class="mb-2">
								<input type="text" class="form-control inputVerif" value="<c:out value="${vehicule.description }" />"  name="description" placeholder="Veillez indiquer la description" minlength="2" maxlength="50">
							</div>
							<div class="mb-2">
								<input type="number" class="form-control inputPrix" value="<c:out value="${vehicule.prixJ}" />" min="0" name="prix" placeholder="Veillez indiquer le prix Journalier" >
							</div>
						</div>						
					</div>
					<div class="">
							<button type="submit" class="btn btn-primary inputSubmit form-control" id="insc" value="addVcl" name="action">Ajouter/Vehicule</button>
					</div>
			</div>
		</form>	
			
					
				
	</div>
</main>

<%@ include file="../_footer.jsp"%>