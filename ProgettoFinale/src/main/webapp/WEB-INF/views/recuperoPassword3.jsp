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
    	function checkPassword(){
    		var password = document.getElementById("password");
    		if(password.value == ""){
    			swal("Errore!","Devi inserire una password valida","error");
				password.style.backgroundColor = "#EB5255";
				return false;
   
    		}
    	}
    </script>
</head>

<body>
    <div id="block" class="login-clean">
        <form id="form" action= "cambiaUfficialmentePassword" method="post" onsubmit="return checkPassword()">
            <h2 class="sr-only">Login Form</h2>
            <div class="illustration">
    		<img class="img-fluid" src="resources/img/logoCircolare.jpg"></i>
    	</div>
            <div class="form-group">
                <p>Email :</p>
                <p>${emailPersona}</p>
            </div>
            <div class="form-group"><input class="form-control" id="password" type="password" name="passwordNuova" placeholder="Inserisci password"></div>
            <div class="form-group"><button id= "button" class="btn btn-primary btn-block" type="submit">Cambia password</button></div><a class="forgot" href="#">Torna alla pagina precedente.</a></form>
    </div>
    <!-- <script src="resources/js/jquery.min.introduction.js"></script>
    <script src="resources/js/bootstrap.min.introduction.js"></script>-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.introduction.js"></script>
</body>

</html>