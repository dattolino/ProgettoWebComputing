<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Richieste Ordine</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/css/bootstrap.min.homepageCapo.css">
    <link rel="stylesheet" href="resources/font/font-awesome.min.css">
    <link rel="stylesheet" href="resources/font/ionicons.min.css">
    <link rel="stylesheet" href="resources/css/styles.min.homepageCapo.css">
    <link rel="stylesheet" href="resources/css/RichiesteCapo.css">
     <script src="resources/js/RichiesteCapo.js"></script>
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
                    <li class="nav-item"><a class="nav-link" id="link" href="dipendenti">I miei dipendenti</a></li>
                    <li class="nav-item"><a class="nav-link active" id="link" href="RichiesteOrdine">Richieste d'ordine</a></li>
                </ul>
                <span class="navbar-text actions"> <a class="btn btn-light action-button" role="button" id="logout" href="doLogout">Logout</a></span></div>
        </div>
    </nav> 
   
    
   <div class="row">
		<div class="col-xl-2"> 
		</div>
		<div class="col-xl-8"> 
  		<h2 class="text" id="heading">Richieste Ordine</h2>
  		<p></p>
  
  
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
	        <th>Modalit�</th>
	        <th>Richiesta</th> 
	      </tr>
	      
	      
    </thead>
    
    <tbody>
    	<c:forEach var= "ordine"  items="${listaRichieste}">
		<tr>
		
				<td>
      				<div class="form-check">
    					<input id="${ordine.richiesta.value}" type="checkbox" class="radio" name="id" value="${ordine.modalita.value}">

    					
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
    	<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal2" id="inoltra"> Inoltra</button>
		</form>
    	  	<!-- The Modal -->
			  <div class="modal fade" id="myModal">
			    <div class="modal-dialog modal-lg">
			    
			      <div class="modal-content">
			      
			        <!-- Modal Header -->
			        <div class="modal-header">
			          <h4 class="modal-title" id="modaltitle">Errore! Assicurati di aver selezionato  per analizzarlo.</h4>
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			        </div>
			        
			        <!-- Modal body -->
			        <div class="modal-body">
			          <form>
			          	<div class="form-group">
			          		<p>Nome ordine: </p> <p id="nomeordine"></p>	          		
			          	</div>
			          	<div class="form-group">
			          		<p>Email: </p> <p id="email"></p>
			          	</div>
			          	<div class="form-group">
			          		<p>Da: </p> <p id="da"></p>
			          	</div>
			          	<div class="form-group">
			          		<p>A: </p> <p id="a"></p>
			          	</div>
			          	<div class="form-group">
			          		<p>Via: </p> <p id="via"></p>
			          	</div>
			          	<div class="form-group">
			          		<p>Modalit�: </p> <p id="modalita"></p>
			          	</div>
			          	<div class="form-group">
			          		<p>Richiesta: </p> <p id="richiesta"></p>
			          	</div>
			          	<div class="form-group">
			          		<p>Tempo di consegna: </p> <p id="tempoconsegna"></p>
			          	</div>
			          	<div class="form-group">
			          		<p>Stato: </p> <p id="stato"></p>
			          	</div>
			          </form>
			        </div>
			        
			        <!-- Modal footer -->
			        <div class="modal-footer">
			          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		            </div>
		        
		         </div>
		       </div>
  			
  			</div>
  			
  			<!-- The Modal -->
			  <div class="modal fade" id="myModal2">
			    <div class="modal-dialog modal-lg">
			    
			      <div class="modal-content">
			      
			        <!-- Modal Header -->
			        <div class="modal-header">
			          <h4 class="modal-title" id="modaltitle">Lista dipendenti disponibili.</h4>
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			        </div>
			        
			        <!-- Modal body -->
			        <div class="modal-body">
			          <form>
			          	<div class="table-responsive ">
  							<table class="styled-table" id="dipendentitable">
	 							<thead>
								      <tr>
								      <th>Seleziona</th>
								      	<th>Nome</th>
								        <th>Email</th>
								        <th>Codice Fiscale</th>
								      </tr>  
							    </thead>
    
   								 <tbody>
   								 <tr>
   								 </tr>
   								 </tbody>
   							</table>
   							</div>		     
			          </form>
			        </div>
			        
			        <!-- Modal footer -->
			        <div class="modal-footer">
			        	<button type="button" class="btn btn-primary" id="conferma">Conferma</button>
			          <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
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