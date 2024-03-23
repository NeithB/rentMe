<footer class="bg-dark p-4">
<div class=" text-center text-white">-- © rentMe --</div>
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
	function verifier(value){
		if( value>=0){
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
	
		myforms.addEventListener('submit', function(e){
			var inp = document.getElementsByClassName('inputPrix').value;
			var inpt=parseInt(inp);
				if(verifier(inpt)){
					e.preventDefault();	
				}
				
		});
		
		var today=new Date().toISOString().split('T')[0];
		document.getElementById("date-input").setAttribute("min",today);
		
		var today=new Date().toISOString().split('T')[0];
		document.getElementById("date-inputF").setAttribute("min",today);
		
		var today=new Date().toISOString().split('T')[0];
		document.getElementById("date-in").setAttribute("min",today);
		
		
</script>
</footer>
</body>
</html>