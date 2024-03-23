<%@ include file="../_header.jsp"%>
<main id="principal_inscr">

	<h1 class="log" id="">Logon</h1>
	
	<div class="container " id="">

		<form action="${pageContext.request.contextPath}/MembreController" method="post" id="myform" >
			
			<c:if test="${verifie }">
				<span class="p-3 text-warning"><em>L'utilisateur existe deja! changez le login</em></span>
			</c:if>
			
			<div class="" id="bloc">	
				<div class="row" >
			
					<div class="col-6" id="bloc1">			
						<div class="mb-2">				
							<input type="text" class="form-control inputVerif"  value="<c:out value="${user.prenom }" />"  name="prenom" placeholder="Votre Prenom" minlength="2" maxlength="15">
						</div>
						
						<div class="mb-2">	
							<input type="text" class="form-control inputVerif" value="<c:out value="${user.nom }" />"  name="nom" placeholder="Votre Nom" minlength="2" maxlength="15">
						</div>
						
						<div class="text-warning" id="error"></div>
						
						<div class="mb-2">
							<input type="text" class="form-control inputVerif"   name="login" placeholder="Votre Login" minlength="4" maxlength="8">
						</div>
						
						<div class="text-warning" id="error"></div>
						
						<div class="mb-2">
							<input type="password" class="form-control inputVerif" value="<c:out value="${user.mdp }" />"  name="mdp" placeholder="Votre Mot de Passe" minlength="4" maxlength="8">
						</div>
						
						<div class="mb-2">
							<input type="text" class="form-control inpuTel" value="<c:out value="${user.tel}" />"  name="tel" placeholder="Votre Telephone" >
						</div>
						<div hidden class="" id="">
			  	
						  	  <div class="form-check-inline">
							    <input type="radio" class="form-check-input" value="client" name="statut" >
							    <label class="form-check-label" for="client"><em>Client</em></label>
							  </div>
							  <div class="form-check-inline">
							    <input type="radio" class="form-check-input" value="admin" name="statut"  >
							    <label class="form-check-label" for="admin"><em>Admin</em></label>
							  </div>
				  		</div>	
														
					</div>
					
					<div class="col-6" id="bloc1">	
				        <div class="mb-2">
							<input type="email" class="form-control " value="<c:out value="${user.email }" />"  name="email" placeholder="Votre Adresse Email" minlength="2" maxlength="50">
						</div>
					
						<div class="mb-2">				
							<input type="number" class="form-control "  value="<c:out value="${user.cp }" />" name="cp" placeholder="Votre Code postal" >
						</div>
						
						<div class="mb-2">	
							<input type="text" class="form-control inputVerif"  value="<c:out value="${user.ville }" />" name="ville" placeholder="Votre Ville" minlength="2" maxlength="15">
						</div>
						<div class="mb-2">	
							<input type="datetime-local" class="form-control "  name="dateM" placeholder="Votre date d'inscription" required="required">
						</div>
						<div class="">
							<input type="text" class="form-control" name="adresse" value="<c:out value="${user.adresse }" />" placeholder="Votre adresse" minlength="2" maxlength="15">
						</div>
									
					</div>
			 </div>
			
				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-primary inputSubmit" id="inscr" value="inscription" name="action">S'inscrire</button>
				</div>
			
			</div>
					
	
		</form>
	</div>
</main>

<script>
	var myforms=document.getElementById("myform");
	var inputElems=document.getElementsByClassName('inputVerif');
	
	var elem = document.createElement("div");
	elem.classList.add("text-warning");
	
	
	for(let i=0; i<inputElems.length; i++){			
		inputElems[i].addEventListener("blur", verify);
	}
	
	function verify(even){
		var inp = even.target.value;
		var min = even.target.getAttribute('minlength');
		var max = even.target.getAttribute('maxlength');

		
		if( verif(inp, min, max) ){
			elem.innerHTML = "La longueur mini est de " + min +" caracteres !";
			even.target.classList.add("border-danger");
			even.target.after(elem);
		}else{
			even.target.classList.remove("border-danger");
			even.target.classList.add("border-success");
			 elem.remove();
		}
	}
	
	function verif(value, min, max){
		if( value.length < min || value.length > max ){
			return true;
		}
		return false;
	}
	
	
	
		myforms.addEventListener('submit', function(e){
			
			for(let i=0; i<inputElems.length; i++){			
				if(inputElems[i].value.trim()==""){				
					e.preventDefault();								
				}
				}		
	});
	
	
		
		
</script>

</body>
</html>