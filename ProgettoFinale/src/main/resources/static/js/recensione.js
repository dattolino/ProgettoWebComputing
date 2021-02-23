window.addEventListener("load",function(){
	registraEventi();
	var jQueryScript = document.createElement('script');
	jQueryScript.setAttribute('src','https://unpkg.com/sweetalert/dist/sweetalert.min.js');
	document.head.appendChild(jQueryScript);
})

function registraEventi(){
	var recensioneBtn = document.getElementById("recensioneBtn");
	
	recensioneBtn.addEventListener("click",recensisci);
}

function recensisci(){
	
	var motivazione = document.getElementById("motivazione");
	var descrizione = document.getElementById("descrizione");
	
	if(motivazione.value == "Inserisci motivazione"){
		swal("Errore!","Devi inserire una motivazione","error");
		motivazione.style.backgroundColor = "#f09e94";
		return false;
	}
	motivazione.style.backgroundColor = "white";
	if(descrizione.value == ""){
		swal("Errore!","Devi inserire una descrizione","error");
		descrizione.style.backgroundColor = "#f09e94";
		return false;
	}
		descrizione.style.backgroundColor = "white";
		
		swal("Sei sicuro di questa operazione?",{
			buttons: {
				cancel: "Annulla!",
				catch: {
				text: "Conferma operazione!",
					value: "catch",
				},
			},
		})
		.then((value)=>{
			switch(value){
			case "catch":
				$.ajax({
					url: "inserisciRecensione",
					method: "POST",
					data: {motivazione : motivazione.value, descrizione : descrizione.value},
					success: swal("Perfetto!","La tua recensione e' stata inserita con successo","success"),
					fail: null
						});
				break;
				
			default:
				swal("Info!","Hai annullato l'operazione","info");
			}
			
		});

}