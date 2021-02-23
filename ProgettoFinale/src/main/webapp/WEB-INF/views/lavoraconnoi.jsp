<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>UnicalDelivery - Noi vogliamo te!</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.min.homepage.css">
    <link rel="stylesheet" href="/resources/css/styles.min.lavoraconnoi.css">
    <link rel="icon" href="resources/img/logoCircolare.jpg">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <script>
    	function checkField(){
    	
    		if(document.getElementById('codiceFiscale').value == ""){
    			swal("Errore!","Devi inserire un codice fiscale valido","error");
    				document.getElementById('codiceFiscale').style.backgroundColor = "#f09e94";
    				return false;
    			}else{
    				document.getElementById('codiceFiscale').style.backgroundColor = "white";
    			}
    			
    		if(document.getElementById('nome').value == ""){
    			swal("Errore!","Devi inserire un nome valido","error");
    				document.getElementById('nome').style.backgroundColor = "#f09e94";
    				return false;
    			}else{
    				document.getElementById('nome').style.backgroundColor = "white";
    			}
    			
    		if(document.getElementById('cognome').value == ""){
    			swal("Errore!","Devi inserire un cognome valido","error");
    				document.getElementById('cognome').style.backgroundColor = "#f09e94";
    				return false;
    			}else{
    				document.getElementById('cognome').style.backgroundColor = "white";
    			}
    			
    		if(document.getElementById('email').value == ""){
    				alert('Inserisci un e-mail valida: esempio (pierpaolosestito@gmail.com)');
    				document.getElementById('email').style.backgroundColor = "#f09e94";
    				return false;
    			}else{
    				document.getElementById('email').style.backgroundColor = "white";
    			}
    			
    		
    		
    		if(document.getElementById('ruolo').value == "TipoLavoro"){
    			swal("Errore!","Devi inserire un ruolo valido","error");
    				document.getElementById('ruolo').style.backgroundColor = "#f09e94";
    				return false;
    			}else{
    				document.getElementById('ruolo').style.backgroundColor = "white";
    			}
    			
    		  	
    	}
    </script>
</head>

<body>
    <div class="container-fluid" id="navbarContainer">
        <nav class="navbar navbar-light navbar-expand-md" id="mynavbar">
            <div class="container-fluid"><a class="navbar-brand" id="mybrand" href="#">UnicalDelivery - Website</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div
                    class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav">
                       <li class="nav-item"><a class="nav-link" id="link" href="/">Homepage</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="chisiamo">Chi siamo</a></li>
                        <li class="nav-item"><a class="nav-link active" id="link" href="lavoraconnoi">Lavora con noi</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="richiediconsegna">Ordina</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="recensioni">Su di noi</a>
                    </ul>
            </div>
    </div>
    </nav>
    </div>
    <div id="block" class="register-photo">
        <div id="div" class="form-container">
            <div id="div" style="margin: 0px;"></div>
          <form action="riepilogoDati" method="post" onsubmit="return checkField()">
                <h2 class="text-center" id="headingText"><strong>Lavora con la UnicalDelivery!</strong></h2>
                <h5 id="errore"></h5>
                <div class="form-group">
                    <p>Codice fiscale aspirante dipendente:&nbsp;</p><input class="form-control" type="text" id="codiceFiscale" name="codiceFiscale"></div>
                <div class="form-group">
                    <p>Nome aspirante dipendente:</p><input class="form-control" type="text" id="nome" name="nome"></div>
                <div class="form-group">
                    <p>Cognome aspirante dipendente:</p><input class="form-control" type="text" id="cognome" name="cognome"></div>
                <div class="form-group">
                    <p>Email aspirante dipendente:</p><input class="form-control" type="email" id="email" name="email"></div>
                <div class="form-group">
				
				
					  <select id="ruolo" name="ruolo" class="custom-select">
					    <option selected>TipoLavoro </option>
					    <option value="ConsegnaTerrena">ConsegnaTerrena</option>
					    <option value="ConsegnaAerea">ConsegnaAerea</option>
					  </select>

			
			</div>
                <div class="form-group"><button class="btn btn-primary btn-block" id="mybutton" type="submit">Procedi al riepilogo</button></div>
                <a id="link2" class="already" href="homepageCliente">Vuoi ritornare alla homepage? Clicca qua.</a></form>
                </form>
        </div>
    </div>
    <!-- <script src="resources/js/jquery.min.lavoraconnoi.js"></script>
    <script src="resources/js/bootstrap.min.lavoraconnoi.js"></script>-->
</body>

</html>