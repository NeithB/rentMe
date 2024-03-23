<%@ include file="../_header.jsp"%>
<main id="princiDispo">


	<div class="container ">
		
	<h1 class="log mt-4 text-center text-light"  id="">Disponible/Vehicules</h1>
	<hr class="text-white" style=""/>
	
		<div class="mt-4"></div>	
		<c:if test="${verifie }">
				<span class="p-3 text-warning"><em>Le Vehicule est deja disponible!</em></span>
			</c:if>
		
		<form action="${pageContext.request.contextPath}/VehiculeController" method="post" id="myform">
						
						<div class="col-6">
							<div class="mb-2">	
								<label for="" class="text-white font-weight-bold mb-1 txt">Selectionner un Vehicule</label>		
								<select name="vehicule" id="" class="form-select">
									<c:forEach items="${requestScope.listesV}" var="liste">
										<option value="${liste.idV }">					
											<c:out value="${liste.marque}"  />
										</option>
									</c:forEach>
								</select>					
							</div>							     
						</div>						
					
					<div class="col-6">
							<button type="submit" class="btn btn-success form-control inputSubmit form-control" id="insc" value="dispo" name="action">Disponible/Vehicule</button>
					</div>		
		</form>	
			
					
				
	</div>
</main>

<%@ include file="../_footer.jsp"%>