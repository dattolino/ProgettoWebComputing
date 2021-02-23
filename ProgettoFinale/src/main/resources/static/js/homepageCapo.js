window.addEventListener("load",function(){
	registraEventi();
	var jQueryScript = document.createElement('script');
	jQueryScript.setAttribute('src','https://unpkg.com/sweetalert/dist/sweetalert.min.js');
	document.head.appendChild(jQueryScript);
})

function registraEventi(){
	var modificaBtn = document.getElementById("modificaBtn");
	
	
	modificaBtn.addEventListener("click",modificaProfilo);
}

function modificaProfilo(){
	
	var nuovaEmail = document.getElementById("nuovaEmail");
	var nuovaPassword = document.getElementById("nuovaPassword");
	var vecchiaPassword = document.getElementById("vecchiaPassword");
	
	if(vecchiaPassword.value == ""){
		swal("Errore!","Devi inserire la tua password attuale per poter effettuare un operazione","error");
		vecchiaPassword.style.backgroundColor = "#f09e94";
		return false;
	}else{
		vecchiaPassword.style.backgroundColor = "white";
	}
	
	if(nuovaEmail.value == "" && nuovaPassword.value == ""){
		swal("Errore!","'Cliccami', ha la soluzione che cerchi","info");
		nuovaEmail.style.backgroundColor = "#f09e94";
		nuovaPassword.style.backgroundColor = "#f09e94";
		return false;
	}else{
		nuovaEmail.style.backgroundColor = "white";
		nuovaPassword.style.backgroundColor = "white";
	}
	
	var conferma = confirm("Sei sicuro di questa operazione?");
	if(conferma == true){
		
		$.ajax({
			url : "modificaProfilo",
			method : "POST",
			data : {oldPw : vecchiaPassword.value, newPw : nuovaPassword.value, newEmail : nuovaEmail.value},
			success: function(){
				swal("Alla grande!","Modifica del profilo riuscita","success");
				if(nuovaEmail.value!="")
				document.getElementById("emailAttuale").innerHTML = "Email attuale:" + nuovaEmail.value;
			},
			fail : null
		});
		
	}
}

