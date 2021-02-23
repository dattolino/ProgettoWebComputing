<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>UnicalDelivery - PasswordRecovery</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.introduction.css">
    <link rel="stylesheet" href="resources/css/styles.min.introduction.css">
    <link rel="icon" href="resources/img/logoCircolare.jpg">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <script>
    function checkCode(){
    	var codice = document.getElementById("codice");
    	if(codice.value == ""){
    		swal("Errore!","Devi inserire una codice valido","error");
			codice.style.backgroundColor = "#EB5255";
			return false;
    	}
    }
    </script>
</head>
	


<body>
    <div id="block" class="login-clean">
        <form id="form" action="confermaCodice" method="post" onsubmit="return checkCode()">
        <h2>Verifica del codice</h2>
            <div class="illustration">
    		<img class="img-fluid" src="resources/img/logoCircolare.jpg"></i>
    	</div>
    	<p>Abbiamo appena inviato un email a: ${emailPersona} <br/> L'email contiene un codice, inseriscilo qua:</p>
            <div class="form-group">
                <p>Inserire il codice :</p><input class="form-control" id="codice" name="codice" type="number"></div>
            <div class="form-group"><button id="button" class="btn btn-primary btn-block" type="submit">Conferma</button></div><a class="forgot" href="#">Torna alla pagina precedente.</a></form>
    </div>
    <!-- <script src="resources/js/jquery.min.introduction.js"></script>
    <script src="resources/js/bootstrap.min.introduction.js"></script>-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.introduction.js"></script>
</body>

</html>