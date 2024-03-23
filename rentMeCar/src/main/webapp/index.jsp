<%@ include file="Vues/_header.jsp"%>

<main id="principal_insc" class="">

	<div class="container " >

		<div class="d-flex text-center text-white " id="princip">
					
			<div class="" style="width:60%;">
			
				<h3 class="log" id="">Logon<i class="fa-solid fa-user"></i></h3>
				<form action="${pageContext.request.contextPath}/MembreController" method="post" id="myform">
					
					<c:if test="${verifie }">
						<span class="p-3 text-warning"><em>L'utilisateur existe deja! changez le login</em></span>
					</c:if>				
						
						<div class="mb-1 row">
							<div class="col-6">
								<div class="mb-2">
									<input type="text" class="form-control inputVerif" value="<c:out value="${user.prenom }" />" name="prenom" placeholder="Votre Prenom" minlength="2" maxlength="15">
								</div>
								<div class="mb-2">
									<input type="text" class="form-control inputVerif" value="<c:out value="${user.nom }" />" name="nom" placeholder="Votre Nom" minlength="2" maxlength="15">
								</div>
								<div class="mb-2">
									<input type="text" class="form-control inputVerif" name="login" placeholder="Votre Login" minlength="4" maxlength="8">
								</div>
								
								<div class="mb-2">
									<input type="password" class="form-control inputVerif" value="<c:out value="${user.mdp }" />" name="mdp" placeholder="Votre Mot de Passe" minlength="4" maxlength="8">
								</div>
								<div class="mb-2">
									<input type="text" class="form-control inpuTel" value="<c:out value="${user.tel}" />" min="0" name="tel" placeholder="Votre Telephone">
								</div>
								<div hidden class="" id="">
									<div class="form-check-inline">
										<input type="radio" class="form-check-input" value="client" name="statut"> <label class="form-check-label" for="client"><em>Client</em></label>
									</div>
									<div class="form-check-inline">
										<input type="radio" class="form-check-input" value="admin" name="statut"> <label class="form-check-label" for="admin"><em>Admin</em></label>
									</div>
								</div>
							</div>
							<div class="col-6">
								<div class="mb-2">
									<input type="email" class="form-control " value="<c:out value="${user.email }" />" name="email" placeholder="Votre Adresse Email" minlength="2" maxlength="50">
								</div>
								<div class="mb-2">
									<input type="number" class="form-control " value="<c:out value="${user.cp }" />" name="cp" placeholder="Votre Code postal">
								</div>
								<div class="mb-2">
									<input type="text" class="form-control inputVerif" value="<c:out value="${user.ville }" />" name="ville" placeholder="Votre Ville" minlength="2" maxlength="15">
								</div>
								<div class="mb-2">        	
									<input type="date" class="form-control " id="date-in" value=""  name="dateM" placeholder="Indiquer la date Inscription " min="" required="required">
							    </div>
								<div class="">
									<input type="text" class="form-control" name="adresse"  value="<c:out value="${user.adresse }" />" placeholder="Votre adresse" minlength="2" maxlength="15">
								</div>
							</div>
						</div>
						<div class="form-group d-grid gap-2">
							<button type="submit" class="form-control btn btn-success inputSubmit" id="" value="inscription" name="action">S'inscrire</button>
						</div>

				</form>
			</div>
			<div class="" style="margin:0px 20px;"></div>
			
			<div  class="" style="width:40%;">			

				<form action="${pageContext.request.contextPath}/MembreController" method="post">
				
					<h3 class="log" id=""><i class="fa-solid fa-right-to-bracket"></i>Login</h3>
					<div>
						<c:if test="${verifie }">
							<span class="p-3 text-warning"><em>L'utilisateur existe deja! changez le login</em></span>
						</c:if>
						<div class="  mb-2">
							<input type="text" class="form-control inputVerif" name="login" placeholder="Votre Login" minlength="2" maxlength="15">
						</div>
						<div class="mb-2">
							<input type="password" class="form-control inputVerif" value="<c:out value="${user.mdp }" />" name="mdp" placeholder="Votre Mot de Passe" minlength="4" maxlength="8">
						</div>
					</div>
						<div class="form-group d-grid gap-2">						
							<button type="submit" class="form-control btn btn-success inputSubmit" id="" value="connecter" name="action">Se connecter</button>
						</div>
					
				</form>
			</div>
		</div>
	</div>
</main>



<%@ include file="Vues/_footer.jsp"%>