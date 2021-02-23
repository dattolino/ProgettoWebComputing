<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Ordini</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/css/bootstrap.min.homepage.css">
    <link rel="stylesheet" href="resources/font/font-awesome.min.css">
    <link rel="stylesheet" href="resources/font/ionicons.min.css">
    <link rel="stylesheet" href="resources/css/styles.min.homepage.css">
    <link rel="stylesheet" href="resources/css/ListaOrdini.css">
    <script src="resources/js/listaOrdini.js"></script>
    <style type="text/css">
    #tuodiv{
    width: 100%;
  	height: 100%;
  	top: 0;
  	left: 0;
     background: url(resources/img/sfondo3.jpg) no-repeat center top;
  	 position: fixed;
  	 z-index: -1;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
    }
    </style>
</head>
<body>
 <div class="container" id="logoContainer"><img id="logo" src="resources/img/logoHTML.jpg"></div>
    <div class="container-fluid" id="navbarContainer">
        <nav class="navbar navbar-light navbar-expand-md" id="mynavbar">
            <div class="container-fluid"><a class="navbar-brand" id="mybrand" href="#">UnicalDelivery - Website</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item"><a class="nav-link active" id="link" href="ricaricaHomepage">Homepage</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="listaOrdiniInAttesa">Richieste Ordini</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="Profilo">Profilo</a></li>
                         <li id="settings" class="nav-item"><a class="nav-link" id="link" href="Settings">Settings</a></li>
                        <li id="indietro" class="nav-item"><a class="nav-link" id="link" href="doLogout">Logout</a></li>
                        
                    </ul>
           		</div>
    		</div>
        </nav>
    </div> 
 <div id="tuodiv"></div>

<div class="row">
		<div class="col-xl-2"> 
		</div>
		<div id="pannelloTabella" class="col-xl-8" > 
  		<h2 class="text" id="heading">Richieste Ordine</h2>
  		<p hidden=true id=cf>${cf}</p>
  		<div class="btn-group">
			<form class ="container">
		    <button type="button" class="btn btn-primary" id="inattesabutton1">In attesa</button>
		    </form>
		    <form class ="container">
		    <button type="button" class="btn btn-primary" id="intransitobutton1">In transito</button>
		    </form>
		    <form class ="container">
		    <button type="button" class="btn btn-primary" id="consegnatibutton1">Consegnati</button>
		    </form>
		    <form class ="container">
		    <button type="button" class="btn btn-primary" id="pdf" data-toggle="modal" data-target="#myModal">Scarica la lista degli ordini in formato pdf</button>
		    </form>
  		</div>
  
  
  	<div class="table-responsive ">
  		
	  
	  
	  <table class="styled-table" id="ordinitable">
	 <thead>
	      <tr>
	      	<th>Seleziona</th>
	        <th>Nome</th>
	        <th>Email</th>
	        <th>Da</th>
	        <th>A</th>
	        <th>Via</th>
	        <th>Modalità</th>
	        <th>Richiesta</th> 
	      </tr>
	      
	      
    </thead>
    
    <tbody>
    	<c:forEach var= "ordine"  items="${listaOrdini}">
		<tr>
		
				<td>
      				<div class="form-check">
    					<input id="${ordine.richiesta.value}" type="checkbox" class="radio" name="id" value="${ordine.richiesta.value}">

    					
    					<script>
					 		
					 		$("input:checkbox").on('click', function() {
					   			var $box = $(this);
					   			if ($box.is(":checked")) {
					     		var group = "input:checkbox[name='" + $box.attr("name") + "']";
					    		$(group).prop("checked", false);
					     		$box.prop("checked", true);
					   			} else {
					     			$box.prop("checked", false);
					   			}
					 		});
    					</script>
  					</div>
    			</td>
    			
				<td>${ordine.name.value}</td>
				<td>${ordine.email.value}</td>
				<td>${ordine.da.value}</td>
				<td>${ordine.a.value}</td>
				<td>${ordine.via.value}</td>
				<td>${ordine.modalita.value}</td>
				<td>${ordine.richiesta.value}</td>
				
		</tr>
	</c:forEach>
    </tbody>
   
  </table>
    
    <div class="btn-group">
    	<form class ="container">
    	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="analizza">Analizza</button>
    	</form>
    	<form class ="container">
    	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="button1">Accetta</button>
		</form>
		<form class ="container">
    	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" id="button2">Rifiuta</button>
		</form>
    	  	<!-- The Modal -->
			  <div class="modal fade" id="myModal">
			    <div class="modal-dialog modal-lg">
			    
			      <div class="modal-content">
			      
			        <!-- Modal Header -->
			        <div class="modal-header">
			          <h4 class="modal-title" id="modaltitle">Errore! Assicurati di aver selezionato un ordine per analizzarlo.</h4>
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			        </div>
			        
			        <!-- Modal body -->
			        <div class="modal-body">
			          <form>
			          	<div class="form-group">
			          		<p id="nomeordine"></p>	          		
			          	</div>
			          	<div class="form-group">
			          		<p id="email"></p>
			          	</div>
			          	<div class="form-group">
			          		<p id="da"></p>
			          	</div>
			          	<div class="form-group">
			          		<p id="a"></p>
			          	</div>
			          	<div class="form-group">
			          		<p id="via"></p>
			          	</div>
			          	<div class="form-group">
			          		<p id="modalita"></p>
			          	</div>
			          	<div class="form-group">
			          		<p id="richiesta"></p>
			          	</div>
			          	<div class="form-group">
			          		<p id="tempoconsegna"></p>
			          	</div>
			          	<div class="form-group">
			          		<p id="stato"></p>
			          	</div>
			          </form>
			        </div>
			        
			        <!-- Modal footer -->
			        <div class="modal-footer">
			          <button type="button" class="btn btn-danger" data-dismiss="modal">Chiudi</button>
		            </div>
		        
		         </div>
		       </div>
  			
  		</div>
  		
  		</div>
   </div>
   
</div>
</div>

<div class="col-xl-2"> 
</div>

 		
  
  
		
</body>
</html>