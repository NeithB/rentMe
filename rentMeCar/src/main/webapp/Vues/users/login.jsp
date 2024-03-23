<%@ include file="../_header.jsp"%>
<main id="principal_inscr">

	<h1 class="log" id="">Login</h1>
	
	<div class="container ">
	
		<div id="form" class="text-center">	
		
			<form action="${pageContext.request.contextPath}/MembreController" method="post">

					<c:if test="${verifie }">
						<span class="p-3 text-warning"><em>L'utilisateur existe deja! changez le login</em></span>
					</c:if>									
					<div class="form-group col-6 mb-2">				
						<input type="text" class="form-control inputVerif"   name="login" placeholder="Votre Login" minlength="2" maxlength="15">
					</div>
							
					<div class="form-group col-6 mb-2">
						<input type="password" class="form-control inputVerif" value="<c:out value="${user.mdp }" />"  name="mdp" placeholder="Votre Mot de Passe" minlength="4" maxlength="8">
					</div>
							
					<div class="form-group col-6 d-grid gap-2">
						<button type="submit" class="btn btn-success inputSubmit" id="" value="connecter" name="action">Se connecter</button>
					</div>	
								
		
			</form>
		</div>
	</div>
</main>


</body>
</html>