<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="resources/css/bootstrap.min.homepage.css">
    <link rel="stylesheet" href="resources/font/font-awesome.min.css">
    <link rel="stylesheet" href="resources/font/ionicons.min.css">
    <link rel="stylesheet" href="resources/css/styles.min.homepage.css">
    <link rel="stylesheet" href="/resources/css/Profilo.css">
    <script src="resources/JS/chiarimenti.js"></script>
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
    
    #mandaEmail{
    width:100%;
 		background-color: #c0c0c0;
 			text-align: center;
 		
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
                    	<li id="indietro" class="nav-item"><a class="nav-link" id="link" href="Profilo">Indietro</a></li>
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
		<div id="mandaEmail" class="col-xl-8"> 
  		<h2 class="text">Contatta capo.</h2>
  		<form action="riepilogoDati">
  				<p hidden=true id=emailmittente>${email}</p>
                <div class="form-group">
                    <p>Oggetto:</p> <br> <input class="form-control" type="text" id="oggettoemail" name="oggettoemail"></div>
                <div class="form-group">
                    <p>Testo:</p> <br> <textarea class="form-control" rows="5" cols="50" id="testoemail" name="testoemail"> </textarea>
                </div>
                
                <div class="form-group">
                	<button class="btn btn-primary btn-block" id="sendemail" type="button" data-toggle="modal" data-target="#myModal">Invia email</button>
                </div>
                	<a id="link2" class="already" href="ricaricaHomepage">Vuoi ritornare alla homepage? Clicca qua.</a>
                </form>
  		</div>
  	</div>


<!-- The Modal -->
			  <div class="modal fade" id="myModal">
			    <div class="modal-dialog modal-lg">
			    
			      <div class="modal-content">
			      
			        <!-- Modal Header -->
			        <div class="modal-header">
			          <h4 class="modal-title" id="modaltitle">Attendere...</h4>
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			        </div>
			        
			        <!-- Modal body -->
			        <div class="modal-body">
			     
			        </div>
			        
			        <!-- Modal footer -->
			        <div class="modal-footer">
			          <button type="button" class="btn btn-danger" data-dismiss="modal">Ok</button>
		            </div>
		        
		         </div>
		       </div>
  			
  		</div>

</body>
</html>