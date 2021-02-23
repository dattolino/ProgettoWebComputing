window.addEventListener("load", function(){
	registraEventi();
});

var oggetto = "";
var testo = "";
var emailMittente = "";

function registraEventi(){

        var btnInviaEmail = document.getElementById("sendemail");
        btnInviaEmail.addEventListener("click", function() {
		inviaEmail();
	});

}

function inviaEmail(){
        oggetto = document.getElementById("oggettoemail").value;
        testo = document.getElementById("testoemail").value;
        emailMittente = document.getElementById("emailmittente").textContent;
        
        document.getElementById("modaltitle").innerHTML = "Attendere...";

        $.ajax({
		url: "emailSender",
		method: "POST",
		
		data: {oggetto: oggetto, testo: testo, emailMittente: emailMittente},
		success: function(response){		
			
                        if(response === "SUCCESS"){
                                document.getElementById("modaltitle").innerHTML = "Email inoltrata con successo!";
                        }else{
                                document.getElementById("modaltitle").innerHTML = "Errore! Non è stato possibile inoltrare con successo l'email.";
                        }
			
		},
		fail: function( jqXHR, textStatus ) {
  			alert( "Request failed: " + textStatus );
		}
			
		});
        document.getElementById("oggettoemail").value = "";
        document.getElementById("testoemail").value = "";
}