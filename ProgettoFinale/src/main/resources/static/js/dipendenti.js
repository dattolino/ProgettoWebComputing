window.addEventListener("load",function(){
	registraEventi();

});

function registraEventi(){
	var licenziaBtn = document.getElementById("licenziaBtn");
	var valutaBtn = document.getElementById("valutaBtn");

	
	valutaBtn.addEventListener("click",valutaDipendente);
	
	licenziaBtn.addEventListener("click",licenziaDipendente);
	
}

function cancellaDaTabella(indexDaCancellare){
	var table = document.querySelector(".table"); 
	var row = table.rows[indexDaCancellare+1];
	row.remove();
}


function cancellaDipendente(){
	var myTableArray = [];

	$("table#cartGrid tr").each(function() {
	    var arrayOfThisRow = [];
	    var tableData = $(this).find('td');
	    if (tableData.length > 0) {
	        tableData.each(function() { arrayOfThisRow.push($(this).text()); });
	        myTableArray.push(arrayOfThisRow);
	    }
	});


	var radio = document.querySelector('input:checked');
	//alert(radio.value);
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
function valutaDipendente(){
	swal("Ciao");
}

function licenziaDipendente(){
	
	var radio = document.querySelector('input:checked');
	
	if(radio==null){
		swal("Errore!","Devi selezionare un dipendente prima di ogni operazione","error");
		return false;
	}
	
	var conferma = confirm("Sei sicuro di questa operazione?");
	if(conferma==true)
		{
			$.ajax({
				url: "licenziaDipendente",
			method: "POST",
				data: {cf : radio.value},
				success: cancellaDipendente(),
				fail: swal("Perfetto!","Stiamo inviando un email all'ex dipendente","success");
		});
//	}
//	var bottoneOk = false;
//	swal("Sei sicuro di questa operazione?",{
//		buttons: {
//			cancel: "Annulla!",
//			catch: {
//				text: "Conferma operazione!",
//				value: "catch",
//			},
//		},
//	})
//	.then((value)=>{
//		switch(value){
//		case "catch":
//			swal("Perfetto!","Hai confermato l'operazione, stiamo proseguendo..","success");
//			bottoneOk = true;
//			break;
//			
//		default:
//			swal("Info!","Hai annullato l'operazione","info");
//		}
//		
//	});
//	
//	if(bottoneOk==true){
//		$.ajax({
//			url: "licenziaDipendente",
//			method: "POST",
//				data: {cf : radio.value},
//				success: cancellaDipendente(),
//				fail: swal("Perfetto!","Stiamo inviando un email all'ex dipendente","success");
//			});
//	}
	
}
//
//function valutaDipendente(){
//	alert("Ciao");
//}
////	if(document.getElementById("riferimentoInput").textContent == "Nessun dipendente selezionato, inserire tu il codice fiscale"){
////		
////	
////		
////		var codiceFiscale = document.getElementById("riferimento").value;
////		var motivazione = document.getElementById("motivazione").value;
////		
////		if(codiceFiscale == ""){
////			swal("Errore!","Devi inserire un codice fiscale valido","success");
////			document.getElementById("riferimento").style.backgroundColor = "#f09e94";
////			return false;
////		}else{
////			var myTableArray = [];
////			var trovato = false;
////
////			$("table#cartGrid tr").each(function() {
////			    var arrayOfThisRow = [];
////			    var tableData = $(this).find('td');
////			    if (tableData.length > 0) {
////			        tableData.each(function() { arrayOfThisRow.push($(this).text()); });
////			        myTableArray.push(arrayOfThisRow);
////			    }
////			});
////			
////			var i,j;
////			
////			for(i=0;i<myTableArray.length;i++){
////				for(j=0;j<myTableArray.length;j++){
////					if(myTableArray[i][j] == codiceFiscale){
////						trovato = true;
////					}
////				}
////			}
////			
////			if(trovato==false){
////				swal("Errore!","Non esiste un dipendente con questo codice fiscale, controlla nella tabella","error");
////				document.getElementById("riferimento").style.backgroundColor = "#f09e94";
////				return false;
////			}
////		}
////		
////		document.getElementById("riferimento").style.backgroundColor = "white";
////		
////		if(motivazione == "Motivazione"){
////			swal("Errore!","Inserisci una motivazione","error");
////			document.getElementById("motivazione").style.backgroundColor ="#f09e94";
////			return false;
////		}
////		
////		
////		document.getElementById("motivazione").style.backgroundColor = "white";
////		/*url: "rifiutaRichiesta",
////		method: "POST",
////		data: {check : codiceFiscale},
////		success: cancellaRichiesta(),
////		fail: alert("Elemento eliminato con successo")*/
////		$.ajax({
////			url : "valutaDipendente",
////			method: "POST",
////			data: {cf : codiceFiscale, motivazione: motivazione},
////			success: alert("A"),
////			success: alert("A")
////		});
////	}else{
////		
////		var motivazione = document.getElementById("motivazione").value;
////		
////		if(motivazione == "Motivazione"){
////			swal("Errore!","Inserisci una motivazione","error");
////			document.getElementById("motivazione").style.backgroundColor = "#f09e94";
////			return false;
////		}
////		
////		document.getElementById("motivazione").style.backgroundColor = "white";
////		
////		var codiceFiscale = document.getElementById("riferimentoInput").textContent;
////		
////		$.ajax({
////			url : "valutaDipendente",
////			method: "POST",
////			data: {cf : codiceFiscale, motivazione: motivazione},
////			success: alert("A"),
////			success: alert("A")
////		});
////		
////		
////	}
//
//
