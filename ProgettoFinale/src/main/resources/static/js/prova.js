
window.addEventListener("load",function(){
	registraEventi();
	var jQueryScript = document.createElement('script');
	jQueryScript.setAttribute('src','https://unpkg.com/sweetalert/dist/sweetalert.min.js');
	document.head.appendChild(jQueryScript);
});

function registraEventi(){
	var rifiutaBtn = document.getElementById("rifiutaBtn");
	var accettaBtn = document.getElementById("accettaBtn");
	
	
	rifiutaBtn.addEventListener("click",rifiutaRichiesta);
	accettaBtn.addEventListener("click",accettaRichiesta);

}

function cancellaDaTabella(indexDaCancellare){
	var table = document.querySelector(".table"); 
	var row = table.rows[indexDaCancellare+1];
	row.remove();
}

//Elimina solo graficamente
function cancellaRichiesta(){
	var myTableArray = [];

	$("table#cartGrid tr").each(function() {
	    var arrayOfThisRow = [];
	    var tableData = $(this).find('td');
	    if (tableData.length > 0) {
	        tableData.each(function() { arrayOfThisRow.push($(this).text()); });
	        myTableArray.push(arrayOfThisRow);
	    }
	});

//////	alert(myTableArray);
	
	var radio = document.querySelector('input:checked');
////	//alert(radio.value);
	var indexDaCancellare = null;
	var i;
	var j;
	

	if(radio!=null){
		indexDaCancellare = null;
		var codiceFiscale = radio.value;
		for(i=0;i<myTableArray.length;i++){
			for(j=0;j<myTableArray.length;j++){
				if(myTableArray[i][j] == radio.value){
						indexDaCancellare = i;
						
				}
						
					}		//
			}
		}
	
	
	if(radio!=null && myTableArray.length == 1){
		cancellaDaTabella(0); 
	}

	if(indexDaCancellare != null){
		cancellaDaTabella(indexDaCancellare);
	}
}

function rifiutaRichiesta(){
	var button = document.querySelector('input:checked');
	if(button==null){
		swal("Errore!","Devi selezionare una richiesta d'assunzione","error");
		return false;
	}
	
	var codiceFiscale = document.querySelector('input:checked').value;
	
	var motivazione = null;
	swal("Sei sicuro di questa scelta?",{
		buttons: {
			cancel: "Annulla!",
			catch: {
				text: "Conferma scelta!",
				value: "catch",
			},
		},
	})
	.then((value)=>{
		switch(value){
		case "catch":
			motivazione = prompt("Inserisci la motivazione","Qua..");
			$.ajax({
				url: "rifiutaRichiesta",
				method: "POST",
				data: {check : codiceFiscale, motivazione : motivazione},
				success: cancellaRichiesta(),
				fail: swal("Perfetto!","Richiesta eliminata con successo ed e-mail inoltrata con successo","success")
			});
			
			break;
			
		
		default:
			swal("Info!","Hai annullato l'operazione","info");
		}
	});
	
}

function accettaRichiesta(){
	var button = document.querySelector('input:checked');
	if(button==null){
		swal("Errore!","Devi selezionare una richiesta d'assunzione","error");
		return false;
	}
	
	var codiceFiscale = document.querySelector('input:checked').value;
	
	swal("Sei sicuro di questa scelta?",{
		buttons: {
			cancel: "Annulla!",
			catch: {
				text: "Conferma scelta!",
				value: "catch",
			},
		},
	})
	.then((value)=>{
		switch(value){
		case "catch":
			$.ajax({
				url: "accettaRichiesta",
				method: "POST",
				data: {check : codiceFiscale},
				success: cancellaRichiesta(),
				fail: swal("Perfetto!","Richiesta d'assunzione accettata ed eliminata dalla tabella, email con le credenziali inoltrata","success")
			});
			break;
		
		default:
			swal("Info","Hai annullato l'operazione","info");
			
		}
	});
}


	



