window.addEventListener("load", function(){
	
	registraEventi();
});

//window.onload=function(){
//	alert("partito");
//	registraEventi();
//}


function registraEventi(){
	
	
	var btnAnalizza = document.getElementById("analizza");
	btnAnalizza.addEventListener("click", function() {
		analizzaOrdine();
	});
	
	var btnInoltra = document.getElementById("inoltra");
	btnInoltra.addEventListener("click", function() {
		inoltraRichiesta();
	});
	
	var btnConferma = document.getElementById("conferma");
	btnConferma.addEventListener("click", function() {
		confermaInoltro();
	});
}

function analizzaOrdine(){
	
	var checkbox = document.querySelector('input:checked');
	
	
	if(checkbox != null){
		var richiesta = document.querySelector('input:checked').id;
		$.ajax({
			url: "AnalizzaRichiesta",
			method: "POST",
			data: {richiesta: richiesta},
			success: function(response){
				console.log(response);
				document.getElementById("modaltitle").innerHTML = "Analizza richiesta:";
				document.getElementById("nomeordine").innerHTML = response.name.value;
				document.getElementById("email").innerHTML = response.email.value;
				document.getElementById("da").innerHTML = response.da.value;
				document.getElementById("a").innerHTML = response.a.value;
				document.getElementById("via").innerHTML = response.via.value;
				document.getElementById("modalita").innerHTML = response.modalita.value;
				document.getElementById("richiesta").innerHTML = response.richiesta.value;
				document.getElementById("tempoconsegna").innerHTML = response.durata.value;
				document.getElementById("stato").innerHTML = response.stato.value;
				
			},
			fail: function( jqXHR, textStatus ) {
	  			alert( "Request failed: " + textStatus );
			}
				
			});
		return true;
	} else{
		document.getElementById("modaltitle").innerHTML = "Errore! Assicurati di aver selezionato un ordine per analizzarlo.";
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


function refreshTable(){
	var richieste = new Array();
	$.ajax({
		url: "listaRichiesteRefresh",
		method: "POST",
		
		data: {},
		success: function(response){		
			richieste = response;
			
			svuotaTabella();
			
			richieste.forEach(function (richiesta, index){
				aggiungiRichiestaAllaTabella(richiesta);
			});
			console.log("post for");
		},
		fail: function( jqXHR, textStatus ) {
  			alert( "Request failed: " + textStatus );
		}
			
		});
}

function inoltraRichiesta(){
	
	var checkbox = document.querySelector('input:checked');
	if(checkbox != null){
		var modalita = document.querySelector('input:checked').value;
		var richiesta = document.querySelector('input:checked').id;
		var dipendenti = new Array();
		$.ajax({
			url: "InoltraDipendente",
			method: "POST",
			data:{ modalita:modalita , richiesta:richiesta},
			success: function(response){
				dipendenti = response;
				
				svuotaTabella2();
				
				dipendenti.forEach(function(dipendente,index){
					aggiungiDipendenteAllaTabella(dipendente);
				});
				console.log("post for");
				
				
			},
			fail: function( jqXHR, textStatus ) {
	  			alert( "Request failed: " + textStatus );
			}
				
			});
	}
}


function confermaInoltro(){
	var checkbox = document.querySelector('input:checked');
	if(checkbox != null){
		var riferimento = document.querySelector('input:checked').value;
		$.ajax({
			url: "confermaInoltro",
			method: "POST",
			data:{ riferimento:riferimento},
			success: function(response){
				refreshTable();
				alert(response);
				console.log("post for");
			},
			fail: function( jqXHR, textStatus ) {
	  			alert( "Request failed: " + textStatus );
			}
				
			});
		return true;
	} else{
		alert("non hai selezionato un dipendente");
		return false;
		}
}



function svuotaTabella(){
	var tableHeaderRowCount = 1;
	var table = document.getElementById('ordinitable');
	var rowCount = table.rows.length;
	for (var i = tableHeaderRowCount; i < rowCount; i++) {
	    table.deleteRow(tableHeaderRowCount);
	}
}
function svuotaTabella2(){
	var tableHeaderRowCount = 1;
	var table = document.getElementById('dipendentitable');
	var rowCount = table.rows.length;
	for (var i = tableHeaderRowCount; i < rowCount; i++) {
	    table.deleteRow(tableHeaderRowCount);
	}
}

//function costruisciPrimaRiga(){
//	var table = document.getElementById("ordinitable");
//	
//	var row = table.insertRow(0);
//	var cellNome = row.insertCell(0);
//	cellNome.textContent = "Prova";
//}

function aggiungiRichiestaAllaTabella(richiesta){
	
	console.log("aggiungi");
	var table = document.getElementById("ordinitable").getElementsByTagName("tbody")[0];
	
	var row = table.insertRow(-1);

	var cellCheckbox = row.insertCell(0);
	
	var div = document.createElement("div");
	div.className = "form-check";
	div.appendChild(singleSelectionModeScript());
	
	cellCheckbox.innerHTML= "<input type=\"checkbox\" class=\"radio\" id=\"" + richiesta.richiesta.value +"\" name=\"id\" value=\"" + richiesta.richiesta.value + "\">";
	cellCheckbox.appendChild(div);
	
	var cellNome = row.insertCell(1);
	cellNome.textContent = richiesta.name.value;
	
	var cellEmail = row.insertCell(2);
	cellEmail.textContent = richiesta.email.value;
	
	var cellDa = row.insertCell(3);
	cellDa.textContent = richiesta.da.value;
	
	var cellA = row.insertCell(4);
	cellA.textContent = richiesta.a.value;
	
	var cellVia = row.insertCell(5);
	cellVia.textContent = richiesta.via.value;
	
	var cellModalita = row.insertCell(6);
	cellModalita.textContent = richiesta.modalita.value;
	
	var cellRichiesta = row.insertCell(7);
	cellRichiesta.textContent = richiesta.richiesta.value;
	
}

function aggiungiDipendenteAllaTabella(dipendente){
	
	console.log("aggiungi");
	var table = document.getElementById("dipendentitable").getElementsByTagName("tbody")[0];
	
	var row = table.insertRow(-1);

	var cellCheckbox = row.insertCell(0);
	
	var div = document.createElement("div");
	div.className = "form-check";
	div.appendChild(singleSelectionModeScript());
	
	cellCheckbox.innerHTML= "<input type=\"checkbox\" class=\"radio\" id=\"" + dipendente.cf.value +"\" name=\"id\" value=\"" + dipendente.cf.value + "\">";
	cellCheckbox.appendChild(div);
	
	var cellNome = row.insertCell(1);
	cellNome.textContent = dipendente.name.value;
	
	var cellEmail = row.insertCell(2);
	cellEmail.textContent = dipendente.email.value;
	
	var cellDa = row.insertCell(3);
	cellDa.textContent = dipendente.cf.value;
}

function singleSelectionModeScript(){
	
	var script = document.createElement("script");	
	script.innerHTML ="	$(\"input:checkbox\").on('click', function() { var $box = $(this); if ($box.is(\":checked\")) { var group = \"input:checkbox[name='\" + $box.attr(\"name\") + \"']\"; $(group).prop(\"checked\", false); $box.prop(\"checked\", true); } else { $box.prop(\"checked\", false);}}); ";
	
	return script;
}



	
