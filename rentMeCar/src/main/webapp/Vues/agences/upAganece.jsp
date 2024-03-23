<%@ include file="../_header.jsp"%>
<main id="principal_inscr" style="height:74vh;">

	<h1 class="log" id="">Modifier/Agence</h1>
	
	<div class="container " id="">

		
		<form action="${pageContext.request.contextPath}/AgenceController" method="post" id="myform" enctype="multipart/form-data">
			
			<c:if test="${verifie }">
				<span class="p-3 text-warning"><em>L'agence existe deja! changez le nom/email</em></span>
			</c:if>
			
			<div class="" id="bloc">	
				<div class="row" >
			
					<div class="col-6" id="bloc1">			
						
						<div hidden class="mb-2">	
							<input type="text" class="form-control inputVerif" value="<c:out value="${agence.idA}" />"  name="idA" placeholder="Veillez indiquer le nom" minlength="2" maxlength="15">
						</div>
						<div class="mb-2">	
							<input type="text" class="form-control inputVerif" value="<c:out value="${agence.nom}" />"  name="nom" placeholder="Veillez indiquer le nom" minlength="2" maxlength="15">
						</div>
						
						<div class="text-warning" id="error"></div>
				
						<div class="mb-2">
							<input type="text" class="form-control inpuTel" value="<c:out value="${agence.tel}" />"  name="tel" placeholder="Votre Telephone" >
						</div>							
				        <div class="mb-2">
							<input type="email" class="form-control " value="<c:out value="" />"  name="email" placeholder="Votre Adresse Email" minlength="2" maxlength="50">
						</div>
						<div class="mb-2">
				   		 	  <input type="file" onchange="visualiserImg(this.files)" accept="image/*" class="form-control inputVerif" name="photo" >
						</div>
					</div>
					
					<div class="col-6" id="bloc1">	
					
						<div class="mb-2">				
							<input type="number" class="form-control "  value="<c:out value="${agence.cp}" />" name="cp" placeholder="Votre Code postal" >
						</div>
						
						<div class="mb-2">	
							<input type="text" class="form-control inputVerif"  value="<c:out value="${agence.ville}" />" name="ville" placeholder="Votre Ville" minlength="2" maxlength="15">
						</div>
		
						<div class="">
							<input type="text" class="form-control" name="adresse" value="<c:out value="${agence.adresse}" />" placeholder="Votre adresse" minlength="2" maxlength="15">
						</div>
									
					</div>
			 </div>
			
				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-primary inputSubmit" id="inscr" value="upAgence" name="action">Ajouter</button>
				</div>
			
			</div>
					
	
		</form>
	</div>
</main>

<%@ include file="../_footer.jsp"%>
