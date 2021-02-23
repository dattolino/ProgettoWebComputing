window.addEventListener("load",function(){
	registraEventi();
	var jQueryScript = document.createElement('script');
	jQueryScript.setAttribute('src','https://unpkg.com/sweetalert/dist/sweetalert.min.js');
	document.head.appendChild(jQueryScript);
});

function registraEventi(){
	var contattaUnicalDelivery = document.getElementById("contattaUnicalDelivery");
	
	contattaUnicalDelivery.addEventListener("click",contatta);

}

function contatta(){


	var emailRichiedente = document.getElementById("emailRichiedente");
	var subject = document.getElementById("subject");
	var message = document.getElementById("message");

	if(emailRichiedente.value == ""){
		swal("Info!","Inserisci l'email sulla quale vorrai ricevere risposta","info");
		emailRichiedente.style.backgroundColor = "#f09e94";
		return false;
	}

	emailRichiedente.style.backgroundColor = "white";

	if(subject.value == ""){
		alert("Errore!","Devi inserire un oggetto di messaggio","error");
		subject.style.backgroundColor = "#f09e94";
		return false;
	}

	subject.style.backgroundColor = "white";

	if(message.value == ""){
		alert("Errore!","Devi inserire un oggetto di messaggio","error");
		message.style.backgroundColor= "#f09e94";
		return false;
	}

	message.style.backgroundColor = "white";

	var emailRichiedenteValue = emailRichiedente.value;
	var subjectValue = subject.value;
	var messageValue = message.value;
	
	$.ajax({
		url: "contattaAzienda",
		method: "POST",
		data: {emailRichiedente : emailRichiedenteValue, subject : subjectValue, message : messageValue},
		success: alert("A"),
		fail: swal("Perfetto!","Email inviata","success")
	});

	
}
