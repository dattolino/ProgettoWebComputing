<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UnicalDelivery LeaderVersion - Gestione dipendenti</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="resources/css/bootstrap.min.homepageCapo.css">
    <link rel="stylesheet" href="resources/css/styles.min.homepageCapo.css">
    
    <link rel="stylesheet" href="resources/css/bootstrap.min.gestionedipendentiprova.css">
    
    
   	<link rel="stylesheet" href="resources/css/dipendentibutton.css">
    <link rel="icon" href="resources/img/logoCircolare.jpg">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
   
    <script src="resources/js/dipendenti2.js"></script>
    
    
    <script>
    	function initFeedback(){
    		var radio = document.querySelector('input:checked');
    		
    		if(radio!=null){
    			document.getElementById("riferimentoInput").innerHTML = radio.value;
    			document.getElementById("riferimentoInput").style.backgroundColor = "#a0df98";
    			
    			document.getElementById("riferimento").disabled = true;
    			
    		
    		}
    	}
    	
    	function initEmail(){
    		var emailDestinatario = document.getElementById("emailDestinatario");
    		var subject = document.getElementById("subject");
    		var message = document.getElementById("message");
    		
    		if(emailDestinatario.value == ""){
    			swal("Info!","Devi inserire l'email sulla quale vorrai ricevere risposta","info");
    			emailDestinatario.style.backgroundColor = "#f09e94";
    			return false;
    		}else{
    			var myTableArray = [];
    			var trovato = false;

    			$("table#cartGrid tr").each(function() {
    			    var arrayOfThisRow = [];
    			    var tableData = $(this).find('td');
    			    if (tableData.length > 0) {
    			        tableData.each(function() { arrayOfThisRow.push($(this).text()); });
    			        myTableArray.push(arrayOfThisRow);
    			    }
    			});
    			
    			var i,j;
    			
    			for(i=0;i<myTableArray.length;i++){
    				for(j=0;j<myTableArray.length;j++){
    					if(myTableArray[i][j] == emailDestinatario.value)
    						trovato=true;
    				}
    			}
    			
    			if(trovato==false){
    				swal("Errore!","Non abbiamo dipendenti con questa email","error");
    				emailDestinatario.style.backgroundColor = "#f09e94";
        			return false;
    			}
    		}
		
    		emailDestinatario.style.backgroundColor = "white";

    		if(subject.value == ""){
    			swal("Info!","Devi inserire un oggetto di messaggio","info");
    			subject.style.backgroundColor = "#f09e94";
    			return false;
    		}

    		subject.style.backgroundColor = "white";

    		if(message.value == ""){
    			swal("Info!","Devi inserire un messaggio","info");
    			message.style.backgroundColor= "#f09e94";
    			return false;
    		}

    		message.style.backgroundColor = "white";
    		
    		
    	}
    </script>
	
</head>
<body>
<div><img id="logo" style="margin-left:350px" src="resources/img/logoHTML.jpg"></div>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-button" id="navbar">
        <div class="container"><a class="navbar-brand" id="brandNav" href="#">Unical Delivery</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav mr-auto">
                	<li class="nav-item"><a class="nav-link" id="link" href="homepageCapo">Dashboard</a></li>
                    <li class="nav-item"><a class="nav-link " id="link" href="richiesteAssunzione">Richieste d'assunzione</a></li>
                    <li class="nav-item"><a class="nav-link active" id="link" href="dipendenti">I miei dipendenti</a></li>
                    <li class="nav-item"><a class="nav-link" id="link" href="RichiesteOrdine">Richieste d'ordine</a></li>
                </ul>
                <span class="navbar-text actions"> <a class="btn btn-light action-button" role="button" id="logout" href="doLogout">Logout</a></span></div>
        </div>
    </nav>
    <div class="card"><img class="card-img w-100 d-block" src="resources/img/lentesfondo2.jpg">
        <div class="card-img-overlay">
            <h4>Ricerca veloce nella tabella</h4><input type="text" id="myInput" onkeyup="myFunction()" placeholder="Cerca in base al codice fiscale" title="Type in a name"><input type="text" id="myInput2" onkeyup="myFunction2()" placeholder="Cerca in base all'email" title="Type in a name" style="margin-left:50px"></div>
    </div>


<div class="table-responsive">
<table id="cartGrid" class="table table-striped table-bordered table-hover table-sm">
	<thead>
		<tr style="background-color:gray">
			<th></th>
			<th>Codice fiscale</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Ruolo</th>
			<th>Email</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach var="persona" items="${listaDipendenti}">
			<tr>
				<td><input type="radio" id="${persona.getCf().getValue()}" name="check" value="${persona.getCf().getValue()}"></td>
				<c:choose>
					<c:when test = "${persona.getRole().getValue().equals('ConsegnaTerrena') }">
						<td style= "background-color:#dc3912">${persona.getCf().getValue()}</td>
						<td style= "background-color:#dc3912">${persona.getName().getValue()}</td>
						<td style= "background-color:#dc3912">${persona.getSurname().getValue()}</td>
						<td style= "background-color:#dc3912">${persona.getRole().getValue()}</td>
						<td style= "background-color:#dc3912">${persona.getEmail().getValue()}</td>
					
						
					</c:when>
					<c:otherwise>
						<td style= "background-color:#3366cc">${persona.getCf().getValue()}</td>
						<td style= "background-color:#3366cc">${persona.getSurname().getValue()}</td>
						<td style= "background-color:#3366cc">${persona.getSurname().getValue()}</td>
						<td style= "background-color:#3366cc">${persona.getRole().getValue()}</td>
						<td style= "background-color:#3366cc">${persona.getEmail().getValue()}</td>
					</c:otherwise>
				</c:choose>
				
			</tr>
		</c:forEach>	
	</tbody>
	
</table>
<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("cartGrid");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}

</script>
<script>

function myFunction2() {
	  var input, filter, table, tr, td, i, txtValue;
	  input = document.getElementById("myInput2");
	  filter = input.value.toUpperCase();
	  table = document.getElementById("cartGrid");
	  tr = table.getElementsByTagName("tr");
	  for (i = 0; i < tr.length; i++) {
	    td = tr[i].getElementsByTagName("td")[5];
	    if (td) {
	      txtValue = td.textContent || td.innerText;
	      if (txtValue.toUpperCase().indexOf(filter) > -1) {
	        tr[i].style.display = "";
	      } else {
	        tr[i].style.display = "none";
	      }
	    }       
	  }
	}
</script>



<div><a class="btn btn-primary btn-lg" id="button" role="button" data-toggle="modal" href="#myModal" onclick="return initFeedback()">Valutazione</a><a id="button1" class="btn btn-primary btn-lg" role="button" data-toggle="modal" href="#myModal-1">Contatta</a><button id="licenziaBtn" class="btn btn-primary btn-lg">Licenzia Dipendente</button>
        <div class="modal fade" role="dialog" tabindex="-1"
            id="myModal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4>Valuta dipendente</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"></span></button></div>
                    <div class="modal-body">
                        <div><img id="immagine" src="resources/img/feedback.jpg" style="width: 480px;margin-right: 20px;"></div>
                      	 <!-- action="recensisciDipendente" method=post"-->
                            <div class="form-group">
                                <p>Codice fiscale del dipendente :</p>
                                <p id="riferimentoInput"><strong>Nessun dipendente selezionato, inserire tu il codice fiscale</strong></p>
                                <input class="form-control" id="riferimento" type="text"></div>
								<!--Da aggiungere il menù a tendina con le varie motivazioni-->
								<div class="form-group">
				
				
					  <select id="motivazione" name="motivazione" class="custom-select">
					    <option selected>Motivazione </option>
					    <option style ="background-color:#f09e94" value="Consegna mancata">Consegna mancata</option>
					    <option style ="background-color:#f09e94" value="Consegna in ritardo">Consegna in ritardo</option>
					    <option style ="background-color:#a0df98" value="Consegna in anticipo">Consegna in anticipo</option>
					    <option style ="background-color:#a0df98" value="Consegna in largo anticipo">Consegna in largo anticipo</option>
					  </select>

			
			</div>
                        
                    </div>
                    <div class="modal-footer"><button class="btn btn-light" data-dismiss="modal" type="button">Annulla</button>
					<button id="valutaBtn" class="btn btn-primary" type="button">Invia valutazione</button></div>
                </div>
            </div>
        </div>
    </div>
    <div>
        <div class="modal fade" role="dialog" tabindex="-1" id="myModal-1">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4>Contatta dipendente</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
                    <div class="modal-body">
                        <section class="td-form">
                            <div class="row td-form-wrapper">
                                <div class="col td-glass">
                                    <form action="inviaEmailDaJSP" method="post" class="td-form-wrapper"> <!--action="contattaDipendente" method="post"-->
                                        <h1 class="text-center"></h1>
                                        <div class="form-group">
                                        	<p id="emailInput"></p>
                                            <div class="col-md-12"><label for="email">Email destinatario :</label>
                                                <div class="d-flex"><i class="icon ion-ios-email align-self-center"></i>
												<input class="form-control" id="emailDestinatario" type="email" autocomplete="off" name="to" required="" placeholder="dipendente@unicaldelivery.com" inputmode="email"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12"><label for="subject">Oggetto :&nbsp;</label>
                                                <div class="d-flex td-input-container"><i class="icon ion-ios-information align-self-center"></i>
												<input class="form-control" id="subject" type="text" autocomplete="off" placeholder="Inserisci l'oggetto della richiesta" name="subject" required=""></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12"><label for="message">Richiesta :</label>
                                                <div class="d-flex td-input-container"><i class="icon ion-android-create align-self-center"></i>
												<textarea class="form-control"id="message" placeholder="Inserisci la richiesta qua!" name="msg" rows="6" cols="50"></textarea></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12"><button class="btn btn-dark float-right" type="submit" onclick="return initEmail()">Invia il messaggio!</button></div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </section>
                    </div>
                    <div class="modal-footer"><button class="btn btn-light" data-dismiss="modal" type="button">Chiudi</button></div>
                </div>
            </div>
        </div>
    </div>
   	<script src="resources/js/jquery.min.introduction.js"></script>
    <!-- <script src="resources/js/jquery.min.gestionedipendentiprova.js"></script>-->
    <script src="resources/js/bootstrap.min.introduction.js"></script>
</body>
</html>