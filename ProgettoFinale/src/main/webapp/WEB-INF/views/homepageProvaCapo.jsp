<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>UnicalDelivery LeaderVersion</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.homepageCapo.css">
    <link rel="stylesheet" href="resources/css/styles.min.homepageCapo.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="icon" href="resources/img/logoCircolare.jpg">
    <script src="resources/js/homepageCapo.js"></script>
    
</head>

<body>
    <div><img id="logo" style="margin-left:350px" src="resources/img/logoHTML.jpg"></div>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-button" id="navbar">
        <div class="container"><a class="navbar-brand" id="brandNav" href="#">Unical Delivery</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav mr-auto">
                
                    <li class="nav-item"><a class="nav-link" id="link" href="richiesteAssunzione">Richieste d'assunzione</a></li>
                    <li class="nav-item"><a class="nav-link" id="link" href="dipendenti">I miei dipendenti</a></li>
                    <li class="nav-item"><a class="nav-link" id="link" href="RichiesteOrdine">Richieste d'ordine</a></li>
                </ul>
                <div><a class="btn btn-primary btn-lg" role="button" id="profiloButton" data-toggle="modal" href="#myModal">Profilo</a>
                    <div class="modal fade" role="dialog" tabindex="-1" id="myModal">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4>Modifica profilo</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"></span></button></div>
                                <div class="modal-body">
                                <div><img id="immagine" style="margin-left:150px"src="resources/img/user.jpg" width="150" height="150"></div>
                                	<details>
										<summary style="background-color:#f09e94">Come funziona?</summary>
										<p style="background-color:gray">Devi inserire la tua password attuale per mostrarci che sei veramente tu a desiderare questa operazione:
											Hai la possibilità di poter cambiare solo l'email o la password (o entrambe). Se lasci uno dei due campi vuoto, il sistema capirà cosa desideri fare; 
											Se li riempi entrambi verranno modificati entrambi gli attributi.</p>
									</details>
                                    <p id="emailAttuale">Email attuale: ${emailAttuale}</p>
                                    <p>Nuova email:</p><input type="email" id="nuovaEmail" name="nuovaEmail">
                                    <p>Vecchia password:</p><input type="password" id="vecchiaPassword" name="vecchiaPassword">
                                    <p>Nuova password:</p><input type="password" id="nuovaPassword" name="nuovaPassword"></div>
                                <div class="modal-footer"><button class="btn btn-light" data-dismiss="modal" type="button">Annulla</button>
                                <button id="modificaBtn" class="btn btn-primary" type="button">Applica</button></div>
                            </div>
                        </div>
                    </div>
                </div><span class="navbar-text actions"> <a class="btn btn-light action-button" role="button" id="logout" href="doLogout">Logout</a></span></div>
        </div>
    </nav>
    
    <c:choose>
    <c:when test="${somma > 0}">
    <div class="card"><img class="card-img w-100 d-block" src="resources/img/notificaaccesa.jpg">
        <div class="card-img-overlay">
            <h4>Da visualizzare:</h4>
            <h3>Richieste assunzione: ${sizeRichiesteAssunzione}</h3>
            <h3>Richieste ordine: ${sizeRichiesteOrdine}</h3>
            </div>
    </div>
    </c:when>
    <c:otherwise>
    <div class="card"><img class="card-img w-100 d-block" src="resources/img/notificaon.jpg">
        <div class="card-img-overlay">
            <h4>Nessuna nuova richiesta assunzione oppure d'ordine da visualizzare</h4>
            </div>
            </div>
    </c:otherwise>
    </c:choose>
    
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Grafo dipendenti</h4>
            <h6 class="text-muted card-subtitle mb-2">Attuale situazione:</h6>
            <div style="margin-left:430px"id="piechartDipendenti"></div>
                        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  var data = google.visualization.arrayToDataTable([
  ['Task', 'Hours per Day'],
  ['ConsegnaAerea', ${dipendentiAerea}],
  ['ConsegnaTerrena', ${dipendentiTerrena}]
]);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'I miei dipendenti', 'width':550, 'height':400};


  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('piechartDipendenti'));
  chart.draw(data, options);
  
}
</script>

			
            <p class="card-text">Il grafo visualizzato sopra rappresenta l'attuale situazione dei dipendenti della <strong style="color:red">Unical Delivery</strong>, direttamente dal sito dell'azienda
            puoi decidere se valutare o licenziare i tuoi dipendenti.</p>
            <button class="btn btn-primary" id="profiloButton"style="margin-left:500px" type="button"><a style="color:white;font-weight:bold"href="dipendenti">Interagisci con i tuoi dipendenti</a></button></div>
    </div>
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Grafo richieste assunzione</h4>
            
            <h6 class="text-muted card-subtitle mb-2">Attuale situazione:</h6>
            <div style="margin-left:430px" id="piechartAssunzioni" ></div>
            

<script type="text/javascript">
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  var data = google.visualization.arrayToDataTable([
  ['Task', 'Hours per Day'],
  ['ConsegnaAerea', ${assunzioneAerea}],
  ['ConsegnaTerrena', ${assunzioneTerrena}]
]);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'Richieste assunzione', 'width':550, 'height':400};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('piechartAssunzioni'));
  chart.draw(data, options);
}
</script>
            <p class="card-text">Il grafo visualizzato sopra rappresenta l'attuale situazione delle richieste d'assunzione rivolte alla <strong style="color:red">Unical Delivery</strong>, direttamente dal sito dell'azienda
            puoi gestire l'assunzione di nuovi dipendenti o l'eventuale rifiuto della richiesta d'assunzione.</p>
   
            <button class="btn btn-primary" id="profiloButton" style="margin-left:500px" type="button"><a style="color:white;font-weight:bold" href="richiesteAssunzione">Gestisci richieste assunzione</a></button></div>
    </div>
    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Grafo lavori azienda</h4>
            <h6 class="text-muted card-subtitle mb-2">Attuale situazione</h6>
            <div style="margin-left:430px" id="piechartRichieste"></div>
            <script type="text/javascript">
// Load google charts
google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

// Draw the chart and set the chart values
function drawChart() {
  var data = google.visualization.arrayToDataTable([
  ['Task', 'Hours per Day'],
  ['ConsegnaAerea', ${richiesteAerea}],
  ['ConsegnaTerrena', ${richiesteTerrena}]
]);

  // Optional; add a title and set the width and height of the chart
  var options = {'title':'Richieste ordine', 'width':550, 'height':400};

  // Display the chart inside the <div> element with id="piechart"
  var chart = new google.visualization.PieChart(document.getElementById('piechartRichieste'));
  chart.draw(data, options);
}
</script>
            
            <p class="card-text">Il grafo visualizzato sopra rappresenta l'attuale situazione delle richieste d'ordine rivolte alla <strong style="color:red">Unical Delivery</strong>, direttamente dal sito dell'azienda
            puoi gestire l'accettazione di tali ordini e demandarli al dipendente desiderato; se la richiesta risulta essere insoddisfabile potrai semplicemente rifiutarla</p>
            <button class="btn btn-primary" id="profiloButton" style="margin-left:500px"type="button"><a style="color:white;font-weight:bold" href="dipendenti">Gestisci le richieste d'ordine</a></button></div>
    </div>
    
     <script src="resources/js/jquery.min.introduction.js"></script>
     <script src="resources/js/bootstrap.min.introduction.js"></script>
   
    <script src="resources/js/script.min.homepageCapo.js"></script>
                
</body>

</html>