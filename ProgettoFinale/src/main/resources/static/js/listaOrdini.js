window.addEventListener("load", function(){
	statoOrdine="in attesa";
	registraEventi();
});

var statoOrdine="in attesa";

function action() {
	actionButton1(statoOrdine);
}

function action2() {
	actionButton2(statoOrdine);
}


function registraEventi(){
	
	var btnAnalizza = document.getElementById("analizza");
	btnAnalizza.addEventListener("click", function() {
		analizzaOrdine(statoOrdine);
	});
	
	var btn1 = document.getElementById("button1");
	btn1.addEventListener("click", action);
	
	var btn2 = document.getElementById("button2");
	btn2.addEventListener("click", action2);
	
	var btnPdf = document.getElementById("pdf");
	btnPdf.addEventListener("click", downloadPdf);
	
	var btnInAttesa = document.getElementById("inattesabutton1");
	btnInAttesa.addEventListener("click", function () {
		
		btn1.removeEventListener("click", action);
		btn2.removeEventListener("click", action2);
		statoOrdine="in attesa";
		btn1.addEventListener("click", action);
		btn2.addEventListener("click", action2);
		
		btn1.innerHTML = "Accetta";	
		btn2.innerHTML = "Rifiuta";
		
		refreshTable(statoOrdine);
	});
	
	var btnInTransito = document.getElementById("intransitobutton1");
	btnInTransito.addEventListener("click", function() {
		
		btn1.removeEventListener("click", action);
		btn2.removeEventListener("click", action2);
		statoOrdine="in transito";
		btn1.addEventListener("click", action);
		btn2.addEventListener("click", action2);
		
		btn1.innerHTML = "Consegnato";
		btn2.innerHTML = "Non consegnato";
		
		refreshTable(statoOrdine);
	});
	
	var btnConsegnati = document.getElementById("consegnatibutton1");
	btnConsegnati.addEventListener("click", function() {
				
		btn1.removeEventListener("click", action);
		btn2.removeEventListener("click", action2);
		statoOrdine="consegnato";
		btn1.addEventListener("click", action);
		btn2.addEventListener("click", action2);
		
		btn1.innerHTML = "Elimina ordine";
		btn2.innerHTML = "Elimina tutti gli ordini";
		
		refreshTable(statoOrdine);
	});
}

function downloadPdf(){
	var cf1 = document.getElementById("cf").textContent;
	console.log(cf1);
	$.ajax({
		url: "downloadListaOrdini",
		method: "POST",
		
		data: {cf1: cf1},
		success: function(response){		
			
			if(response === "SUCCESS"){
				document.getElementById("modaltitle").innerHTML = "Lista ordini scaricata in formato pdf.";
				document.getElementById("nomeordine").innerHTML = "";
				document.getElementById("email").innerHTML = "";
				document.getElementById("da").innerHTML = "";
				document.getElementById("a").innerHTML = "";
				document.getElementById("via").innerHTML = "";
				document.getElementById("modalita").innerHTML = "";
				document.getElementById("richiesta").innerHTML = "";
				document.getElementById("tempoconsegna").innerHTML = "";
				document.getElementById("stato").innerHTML = "";
			}else{
				document.getElementById("modaltitle").innerHTML = "Errore! Qualcosa è andato storto.";
				document.getElementById("nomeordine").innerHTML = "";
				document.getElementById("email").innerHTML = "";
				document.getElementById("da").innerHTML = "";
				document.getElementById("a").innerHTML = "";
				document.getElementById("via").innerHTML = "";
				document.getElementById("modalita").innerHTML = "";
				document.getElementById("richiesta").innerHTML = "";
				document.getElementById("tempoconsegna").innerHTML = "";
				document.getElementById("stato").innerHTML = "";
			}
			
		},
		fail: function( jqXHR, textStatus ) {
  			alert( "Request failed: " + textStatus );
		}
			
		});
}

function analizzaOrdine(stato){
	
	var checkbox = document.querySelector('input:checked');
	
	if(checkbox != null){
		var richiesta = document.querySelector('input:checked').value;
		$.ajax({
			url: "Analizza",
			method: "POST",
			data: {richiesta: richiesta, statoOrdine: statoOrdine},
			success: function(response){
				if(response === null){
					alert('ERRORE');
					return;
				}
				console.log(response);
				document.getElementById("modaltitle").innerHTML = "Analizza ordine:";
				document.getElementById("nomeordine").innerHTML = "Nome ordine: " + response.name.value;
				document.getElementById("email").innerHTML = "Email: " + response.email.value;
				document.getElementById("da").innerHTML = "Da: " + response.da.value;
				document.getElementById("a").innerHTML = "A: " + response.a.value;
				document.getElementById("via").innerHTML = "Via: " + response.via.value;
				document.getElementById("modalita").innerHTML = "Modalità: " + response.modalita.value;
				document.getElementById("richiesta").innerHTML = "Richiesta: " + response.richiesta.value;
				document.getElementById("tempoconsegna").innerHTML = "Durata: " + response.durata.value;
				document.getElementById("stato").innerHTML = "Stato ordine: " + response.stato.value;
				
			},
			fail: function( jqXHR, textStatus ) {
	  			alert( "Request failed: " + textStatus );
			}
				
			});
		return true;
	} else{
		document.getElementById("modaltitle").innerHTML = "Attenzione! Assicurati di aver selezionato un ordine per analizzarlo.";
		document.getElementById("nomeordine").innerHTML = "";
		document.getElementById("email").innerHTML = "";
		document.getElementById("da").innerHTML = "";
		document.getElementById("a").innerHTML = "";
		document.getElementById("via").innerHTML = "";
		document.getElementById("modalita").innerHTML = "";
		document.getElementById("richiesta").innerHTML = "";
		document.getElementById("tempoconsegna").innerHTML = "";
		document.getElementById("stato").innerHTML = "";
		return false;
	}

}


function refreshTable(stato){
	var ordini = new Array();
	$.ajax({
		url: "listaOrdiniRefresh",
		method: "POST",
		
		data: {stato: stato},
		success: function(response){		
			ordini = response;
			
			svuotaTabella();
			
			ordini.forEach(function (ordine, index){
				aggiungiOrdineAllaTabella(ordine);
			});
			
		},
		fail: function( jqXHR, textStatus ) {
  			alert( "Request failed: " + textStatus );
		}
			
		});
}

function svuotaTabella(){
	var tableHeaderRowCount = 1;
	var table = document.getElementById('ordinitable');
	var rowCount = table.rows.length;
	for (var i = tableHeaderRowCount; i < rowCount; i++) {
	    table.deleteRow(tableHeaderRowCount);
	}
}

function aggiungiOrdineAllaTabella(ordine){
	
	var table = document.getElementById("ordinitable").getElementsByTagName("tbody")[0];
	
	var row = table.insertRow(-1);

	var cellCheckbox = row.insertCell(0);
	
	var div = document.createElement("div");
	div.className = "form-check";
	div.appendChild(singleSelectionModeScript());
	
	cellCheckbox.innerHTML= "<input type=\"checkbox\" class=\"radio\" id=\"" + ordine.richiesta.value +"\" name=\"id\" value=\"" + ordine.richiesta.value + "\">";
	cellCheckbox.appendChild(div);
	
	var cellNome = row.insertCell(1);
	cellNome.textContent = ordine.name.value;
	
	var cellEmail = row.insertCell(2);
	cellEmail.textContent = ordine.email.value;
	
	var cellDa = row.insertCell(3);
	cellDa.textContent = ordine.da.value;
	
	var cellA = row.insertCell(4);
	cellA.textContent = ordine.a.value;
	
	var cellVia = row.insertCell(5);
	cellVia.textContent = ordine.via.value;
	
	var cellModalita = row.insertCell(6);
	cellModalita.textContent = ordine.modalita.value;
	
	var cellRichiesta = row.insertCell(7);
	cellRichiesta.textContent = ordine.richiesta.value;
	
}

function singleSelectionModeScript(){
	
	var script = document.createElement("script");	
	script.innerHTML ="	$(\"input:checkbox\").on('click', function() { var $box = $(this); if ($box.is(\":checked\")) { var group = \"input:checkbox[name='\" + $box.attr(\"name\") + \"']\"; $(group).prop(\"checked\", false); $box.prop(\"checked\", true); } else { $box.prop(\"checked\", false);}}); ";
	
	return script;
}

function actionButton1(stato){
	
	var checkbox = document.querySelector('input:checked');
	var richiesta = "";
	var nuovoStato = "";
	if(checkbox != null){
		richiesta = checkbox.value;
			
			if(stato === "in attesa"){
				nuovoStato = "in transito"; 
			}
			else if(stato === "in transito"){
				nuovoStato = "consegnato";
            }
            else{
                nuovoStato = "nessuno";
            }
			
			$.ajax({
				url: "gestisciOrdine1",
				method: "POST",
				data: {richiesta: richiesta, stato: stato, nuovoStato: nuovoStato},
				success: function(response){
					if(response === "FAIL"){
						alert('ERRORE');
						return;
					}
					if(response === "OK" || response === "ELIMINATO"){
						document.getElementById("modaltitle").innerHTML = "Operazione riuscita! Le liste degli ordini saranno aggiornate in automatico.";
						document.getElementById("nomeordine").innerHTML = "";
						document.getElementById("email").innerHTML = "";
						document.getElementById("da").innerHTML = "";
						document.getElementById("a").innerHTML = "";
						document.getElementById("via").innerHTML = "";
						document.getElementById("modalita").innerHTML = "";
						document.getElementById("richiesta").innerHTML = "";
						document.getElementById("tempoconsegna").innerHTML = "";
						document.getElementById("stato").innerHTML = "";
						$("input[type=checkbox]:checked").closest("tr").remove();
						return;
					}
					if(response === "BONUS OK"){
						document.getElementById("modaltitle").innerHTML = "Complimenti! Ti è stato attribuito un bonus per la consegna anticipata! <br> Le liste degli ordini saranno aggiornate in automatico.";
						document.getElementById("nomeordine").innerHTML = "";
						document.getElementById("email").innerHTML = "";
						document.getElementById("da").innerHTML = "";
						document.getElementById("a").innerHTML = "";
						document.getElementById("via").innerHTML = "";
						document.getElementById("modalita").innerHTML = "";
						document.getElementById("richiesta").innerHTML = "";
						document.getElementById("tempoconsegna").innerHTML = "";
						document.getElementById("stato").innerHTML = "";
						$("input[type=checkbox]:checked").closest("tr").remove();
						return;
					}
					if(response === "BONUS FAIL"){
						document.getElementById("modaltitle").innerHTML = "Attenzione! Ti è stata attribuita un'ammonizione per la consegna in ritardo! <br> Le liste degli ordini saranno aggiornate in automatico.";
						document.getElementById("nomeordine").innerHTML = "";
						document.getElementById("email").innerHTML = "";
						document.getElementById("da").innerHTML = "";
						document.getElementById("a").innerHTML = "";
						document.getElementById("via").innerHTML = "";
						document.getElementById("modalita").innerHTML = "";
						document.getElementById("richiesta").innerHTML = "";
						document.getElementById("tempoconsegna").innerHTML = "";
						document.getElementById("stato").innerHTML = "";
						$("input[type=checkbox]:checked").closest("tr").remove();
						return;
                    }
                    //f(response === "ELIMINATO"){
                        
                    //}
				},
				fail: function( jqXHR, textStatus ) {
		  			alert( "Request failed: " + textStatus );
				}
					
				});
		
	}
	else{
		document.getElementById("modaltitle").innerHTML = "Attenzione! Assicurati di aver selezionato un ordine.";
		document.getElementById("nomeordine").innerHTML = "";
		document.getElementById("email").innerHTML = "";
		document.getElementById("da").innerHTML = "";
		document.getElementById("a").innerHTML = "";
		document.getElementById("via").innerHTML = "";
		document.getElementById("modalita").innerHTML = "";
		document.getElementById("richiesta").innerHTML = "";
		document.getElementById("tempoconsegna").innerHTML = "";
		document.getElementById("stato").innerHTML = "";
		return false;
	}
}

function actionButton2(stato){
	var btn2 = document.getElementById("button2");
	if(btn2.innerHTML === "Elimina tutti gli ordini"){
		$.ajax({
			url: "eliminaOrdiniConsegnati",
			method: "GET",
			
			success: function(response){
	            
	                document.getElementById("modaltitle").innerHTML = "Storico ordini svuotato!";
	                document.getElementById("nomeordine").innerHTML = "";
	                document.getElementById("email").innerHTML = "";
	                document.getElementById("da").innerHTML = "";
	                document.getElementById("a").innerHTML = "";
	                document.getElementById("via").innerHTML = "";
	                document.getElementById("modalita").innerHTML = "";
	                document.getElementById("richiesta").innerHTML = "";
	                document.getElementById("tempoconsegna").innerHTML = "";
	                document.getElementById("stato").innerHTML = "";
	                svuotaTabella();
	                return;
			},
			fail: function( jqXHR, textStatus ) {
	  			alert( "Request failed: " + textStatus );
			}
				
	    });
		return;
	}
	var checkbox = document.querySelector('input:checked');
	var richiesta = "";
	var nuovoStato = "";
	
	if(checkbox != null){
		richiesta = checkbox.value;
		if(stato === "in attesa"){
            nuovoStato = "rifiutato"; 
        }
        else if(stato === "in transito"){
            nuovoStato = "in attesa";
        }
        else{
            nuovoStato = "nessuno";
        }
		console.log(stato);
		$.ajax({
			url: "gestisciOrdine2",
			method: "POST",
			
			data: {richiesta: richiesta, stato: stato, nuovoStato: nuovoStato},
			success: function(response){
                if(response === "FAIL"){
                    alert('ERRORE');
					return;
                }		
				else{
                    document.getElementById("modaltitle").innerHTML = "Operazione riuscita! Le liste degli ordini saranno aggiornate in automatico.";
                    document.getElementById("nomeordine").innerHTML = "";
                    document.getElementById("email").innerHTML = "";
                    document.getElementById("da").innerHTML = "";
                    document.getElementById("a").innerHTML = "";
                    document.getElementById("via").innerHTML = "";
                    document.getElementById("modalita").innerHTML = "";
                    document.getElementById("richiesta").innerHTML = "";
                    document.getElementById("tempoconsegna").innerHTML = "";
                    document.getElementById("stato").innerHTML = "";
                    $("input[type=checkbox]:checked").closest("tr").remove();
                    return;
                }
			},
			fail: function( jqXHR, textStatus ) {
	  			alert( "Request failed: " + textStatus );
			}
				
        });
        
	}
	else{
		document.getElementById("modaltitle").innerHTML = "Attenzione! Assicurati di aver selezionato un ordine.";
		document.getElementById("nomeordine").innerHTML = "";
		document.getElementById("email").innerHTML = "";
		document.getElementById("da").innerHTML = "";
		document.getElementById("a").innerHTML = "";
		document.getElementById("via").innerHTML = "";
		document.getElementById("modalita").innerHTML = "";
		document.getElementById("richiesta").innerHTML = "";
		document.getElementById("tempoconsegna").innerHTML = "";
		document.getElementById("stato").innerHTML = "";
		return false;
	}
}
