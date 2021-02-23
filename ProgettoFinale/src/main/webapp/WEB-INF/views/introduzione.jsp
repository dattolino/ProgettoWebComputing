<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>UnicalDelivery - WebSite</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.introduction.css">
  
    <link rel="stylesheet" href="resources/fonts/ionicons.min.css">
    <link rel="stylesheet" href="resources/css/styles.min.introduction.css">
    <link rel="icon" href="resources/img/logoCircolare.jpg">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <script>
    function checkField(){
    	
    		if(document.getElementById("email").value == ""){
    			swal("Errore!","Devi inserire un email fiscale per poter accedere","error");
    			document.getElementById("email").style.backgroundColor = "#f09e94";
    			return false;
    		}else{
    			document.getElementById("email").style.backgroundColor = "white";
    		}
    		
    		if(document.getElementById("password").value == ""){
    			swal("Errore!","Devi inserire una password valida","error");
    			document.getElementById("password").style.backgroundColor = "#f09e94";
    			return false;
    		}else{
    			document.getElementById("password").style.backgroundColor = "white";
    		}
    }
    
    </script>
</head>

<body>
    <div id="block" class="login-clean">
    	
        <form id="form" method="post" action="doLogin" onsubmit="return checkField()">
            
            <div class="illustration"><img class="img-fluid" src="resources/img/logoCircolare.jpg"></i></div><center><a style="color:maroon;font-weight:bold" href="relazione" target="_blank">Leggi la nostra relazione cliccando qua!</a></center><center><p style="color:red">${messaggio}</p></center><button class="btn btn-primary" id="button" type="button"><a href="homepageCliente" style = "color:white">Usufruisci dei servizi UnicalDelivery</a></button>
            
            <div><a class="btn btn-primary btn-lg" role="button" data-toggle="modal" id="button" href="#myModal">Fai parte della UnicalDelivery? Accedi</a>
            
                <div class="modal fade" role="dialog" tabindex="-1" id="myModal">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4>Inserisci le tue credenziali per accedere!</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"></span></button></div>
                            	
                            <div class="modal-body">
                            		<a style="color:maroon" href="FAQ" target="_blank">Per i professori: cliccami per avere le credenziali d'accesso!</a>
        							<h5>${tentativiAccesso} tentativi rimanenti</h5>
                               
                                    <div class="form-group">
                                        <p>Email:</p><input class="form-control" type="email" id="email" name="email"></div>
                                    <div class="form-group">
                                        <p>Password:</p><input class="form-control" type="password" id="password" name="password"></div>
                                    <div class="form-group">
                                        <div class="form-check"><input type="checkbox" id="formCheck-1" name="checkboxValue"><label class="form-check-label" for="formCheck-1">Vuoi rimanere autenticato?</label></div>
                                    </div>
                                    <div class="form-group">
                                       <a href="recuperoPassword">Hai smarrito la password? Clicca qua</a>
                                    </div>
                              
                            </div>
                            <div class="modal-footer">
                            <button class="btn btn-light" id="closebtn" data-dismiss="modal" type="button">Close</button>
                            <input type="submit" id="button" value="Login"></input></div>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <script src="resources/js/jquery.min.introduction.js"></script>
   	<script src="resources/js/bootstrap.min.introduction.js"></script>
   
</body>

</html>