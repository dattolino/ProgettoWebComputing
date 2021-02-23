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
    	function checkEmail(){
    		var email = document.getElementById("email");
    		
    		if(email.value == ""){
    			swal("Errore!","Devi inserire un email valida","error");
    			email.style.backgroundColor = "#EB5255";
    			return false;
    		}
    	}
    </script>
</head>

<body>
    <div id="block" class="login-clean">
    	
        <form id="form" action="invioMailConfermaCodice" method="post" onsubmit="return checkEmail()">
            <h2 class="sr-only">Login Form</h2>
            <div class="illustration">
    		<img class="img-fluid" src="resources/img/logoCircolare.jpg"></i>
    	</div>
            <div class="form-group">
                <p>Inserire email :</p><input class="form-control" type="email" id="email" name="email" placeholder="Email"></div>
            <div class="form-group">
            <details>
            	<summary>Il ruolo e' facoltativo</summary>
            	<p> Facilita la ricerca all'interno degli utenti </p>
            </details>
                <p>Inserire ruolo:</p><input class="form-control" name="ruolo" type="text" placeholder="Ruolo"></div>
            <div class="form-group"><button id="button" class="btn btn-primary btn-block" type="submit">Richiedi codice</button></div><a class="forgot" href="/">Torna alla pagina precedente.</a></form>
    </div>
    <!-- <script src="resources/js/jquery.min.introduction.js"></script>
    <script src="resources/js/bootstrap.min.introduction.js"></script>-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.introduction.js"></script>
</body>

</html>