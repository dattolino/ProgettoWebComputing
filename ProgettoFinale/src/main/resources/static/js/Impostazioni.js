window.addEventListener("load", registraEventi);

function registraEventi(){
	var cambiaP = document.getElementById("CambiaPassword");
	cambiaP.addEventListener("click", analizzaOrdine);
}

function cambiaPassword(){
	
	
	if(checkbox != null){
		$.ajax({
			url: "Analizza",
			method: "POST",
			data: {richiesta: richiesta},
			success: function(response){
				
			},
			fail: function( jqXHR, textStatus ) {
	  			alert( "Request failed: " + textStatus );
			}
				
			});
		return true;
	} else{
		alert('Seleziona un ordine!');
		return false;
	}