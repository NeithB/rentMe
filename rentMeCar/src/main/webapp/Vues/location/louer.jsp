<%@ include file="../_header.jsp"%>
<main id="principal_in">

	<h1 class="log text-white" id="">Location/Vehicule</h1>
	
	<div class="container " id="">
	
	
		<form action="${pageContext.request.contextPath}/LocationController" method="post" id="myform" >
			
			<c:if test="${verifie }">
				<span class="p-3 text-warning"><em>L'utilisateur existe deja! changez le login</em></span>
			</c:if>
			
			<div class="" id="bloc">
				
				<div class="row" >
				
						<div class="col-6" id="bloc1">			
							<div hidden class="mb-2">				
								<input type="text" class="form-control inputVerif"  value="<c:out value="${sessionScope.user.idM }" />" name="idM">
							</div>
							<div hidden class="mb-2">				
								<input type="text" class="form-control inputVerif"  value="<c:out value="${vehicule.idV }" />"  name="idV">
							</div>
						
					        <div class="mb-2">
					       		 <label for="" class="text-white">Date de Debut</label>
								<input type="date" class="form-control " id="date-input" value=""  name="dateD"   placeholder="Indiquer la date de debut" min="" max="" required="required">
							</div>
					        <div class="mb-3">
					        	<label for="" class="text-white">Date de Fin</label>
								<input type="date" class="form-control " id="date-inputF" value=""  name="dateF" placeholder="Indiquer la date de  Fin" min="" required="required">
							</div>									
					        <div hidden class="mb-2">
								<input type="text" class="form-control " value="${vehicule.prixJ }"  name="prix">
							</div>									
							<div class="">
								<button type="submit" class="btn btn-primary form-control inputSubmit"  value="louer" name="action">Louer/vehicule</button>
							</div>
						</div>
				
				</div>
			</div>
		</form>
	</div>
</main>

<%@ include file="../_footer.jsp"%>