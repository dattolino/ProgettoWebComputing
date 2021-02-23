<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>UnicalDelivery - Richiedi una consegna!</title>
     <link rel="stylesheet" href="resources/css/bootstrap.min.homepage.css">
    <link rel="stylesheet" href="resources/css/styles.min.richiediconsegna.css">
    <link rel="icon" href="resources/img/logoCircolare.jpg">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <script>
    	function checkField(){
    			if(document.getElementById('name').value == ""){
    				swal("Errore!","Devi inserire un nome valido","error");
    				document.getElementById('name').style.backgroundColor = "#f09e94";
    				return false;
    			}else{
    				document.getElementById('name').style.backgroundColor = "white";
    			}
   
    			
    			if(document.getElementById('email').value == ""){
    				swal("Errore!","Devi inserire un e-mail valida","error");
    				document.getElementById('email').style.backgroundColor = "#f09e94";
    				return false;
    			}else{
    				document.getElementById('email').style.backgroundColor = "white";
    			}
    			
    			if(document.getElementById('da').value=="SelezionaCitta'"){
    				swal("Errore!","Devi inserire una nome di città valido","error");
    				document.getElementById('da').style.backgroundColor = "#f09e94";
    				return false;
    			}else{
    				document.getElementById('da').style.backgroundColor = "white";
    			}
    			
    			if(document.getElementById('a').value=="SelezionaCitta'"){
    				swal("Errore!","Inserisci una destinazione valida","error");
    				document.getElementById('a').style.backgroundColor = "#f09e94";
    				return false;
    			}else{
    				document.getElementById('a').style.backgroundColor = "white";
    			}
    			
    			if(document.getElementById('via').value==""){
    				swal("Errore!","Inserisci una via valida","error");
    				document.getElementById('via').style.backgroundColor = "#f09e94";
    				return false;
    			}else{
    				document.getElementById('via').style.backgroundColor = "white";
    			}
    			
    			if(document.getElementById('ruolo').value=="TipoLavoro"){
    				swal("Errore!","Devi inserire un ruolo valido","error");
    				return false;
    				document.getElementById('ruolo').style.backgroundColor = "#f09e94";
    			}else{
    				document.getElementById('ruolo').style.backgroundColor = "white";
    			}
    			if(document.getElementById('richiesta').value==""){
    				swal("Errore!","Inserisci una richiesta valida","error");
    				document.getElementById('richiesta').style.backgroundColor = "#f09e94";
    				return false;
    			}else{
    				document.getElementById('richiesta').style.backgroundColor = "white";
    			}
    	 }
    
    
    </script>
</head>

<body id="body">
    <div class="container-fluid" id="navbarContainer">
        <nav class="navbar navbar-light navbar-expand-md" id="mynavbar">
            <div class="container-fluid"><a class="navbar-brand" id="mybrand" href="#">UnicalDelivery - Website</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div
                    class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item"><a class="nav-link" id="link" href="/">Homepage</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="chisiamo">Chi siamo</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="lavoraconnoi">Lavora con noi</a></li>
                        <li class="nav-item"><a class="nav-link active" id="link" href="richiediconsegna">Ordina</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="recensioni">Su di noi</a>
                    </ul>
            </div>
    </div>
    </nav>
    </div>
    <div id="backgroundblock" class="register-photo">
        <div id="mydiv" class="form-container">
            <div class="text-center" id="mydiv" style="background: url(&quot;assets/img/mappaFin.jpg&quot;), url(&quot;https://cdn.bootstrapstudio.io/placeholders/1400x800.png&quot;);"></div>
            
            <form action="metodipagamento" method="post" onsubmit="return checkField()">
                <h2 class="text-center" id="headingText"><strong>Richiedi una consegna!</strong></h2>
                <div class="form-group">
                    <p>Inserisci nome completo:</p><input class="form-control" type="text" id="name" name="nome"></div>
                <div class="form-group">
                    <p>Inserisci email:</p><input class="form-control" type="email" id="email" name="email"></div>
                <div class="form-group">
                    <p>Da:</p>
                    <select id="da" name="da" class="custom-select">
					    <option selected>SelezionaCitta'</option>
					    <option value="Roma">Roma</option>
					  </select>
				</div>
                <div class="form-group">
                    <p>A:&nbsp;</p>
                    <select id="a" name="a" class="custom-select">
					    <option selected>Seleziona una città di destinazione</option>
					    	<c:forEach var="tappa" items="${listaPartenze}">
								<option value="tappa">${tappa}</option>
							</c:forEach>
					    <!--  <option value="Palermo">Palermo</option>
					    <option value="Genova">Genova</option>-->
					  </select>
				</div>
        <div class="form-group">
        <details>
        	<summary style="background-color:black;font-weight:bold;color:white">Vuoi essere sicuro che il tuo indirizzo venga localizzato? </summary>
        	<p style="background-color:grey;font-weight:bold;color:white"> Utilizza la : <br/>
        	<a style="color:maroon;font-weight:bold" href="visualizzaMap" target="_blank">UnicalDelivery Maps - Clicca qua</a></p>
        </details>
            <p>Indirizzo:</p><input class="form-control" type="text" id="via" name="via" placeholder="Via Roma, 89"></div>
    <div class="form-group" id="modalita">
        <p>Modalita' di consegna:</p>
        <select id="ruolo" name="ruolo" class="custom-select">
					    <option selected>TipoLavoro </option>
					    <option value="ConsegnaTerrena">ConsegnaTerrena</option>
					    <option value="ConsegnaAerea">ConsegnaAerea</option>
					  </select>
	</div>
    <div class="form-group">
        <p>Inserisci richiesta:&nbsp;</p><textarea class="form-control" id="richiesta" name="richiesta"></textarea></div>
        <div class="form-group"><button class="btn btn-primary btn-block" id="mybutton" type="submit">Procedi alla modalita' di pagamento</button></div>
        <a id="link2" class="already" href="/">Vuoi ritornare alla homepage? Clicca qua</a></form>
        </div>
        </div>
        <!-- <script src="resources/js/jquery.min.richiediconsegna.js"></script>
        <script src="resources/js/bootstrap.min.richiediconsegna.js"></script>-->
</body>

</html>