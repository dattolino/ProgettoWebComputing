<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<meta charset="ISO-8859-1">
<title>Profilo</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="resources/css/bootstrap.min.homepage.css">
    <link rel="stylesheet" href="resources/font/font-awesome.min.css">
    <link rel="stylesheet" href="resources/font/ionicons.min.css">
    <link rel="stylesheet" href="resources/css/styles.min.homepage.css">
    <link rel="stylesheet" href="resources/css/Profilo.css">
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
	  <div class="col-xl-4">
	  
		  <div id="testo" class="panel panel-default">
		  	<h2 class="text" id="heading" >Profilo</h2>
		 
		  
		  
		  
		  <h3 id="heading">Nome : ${name}</h3>
		  <h3 id="heading">Cognome : ${surname}</h3>
		  <h3 id="heading">Email : ${email}</h3>
		  <h3 id="heading">TipoLavoro : ${role}</h3>
		  <h3 id="heading">Codice Fiscale : ${cf}</h3>
		  </div>
	</div>
	 
  
  
   <div class="col-xl-4">
	    <div id="pannello1" class="panel panel-default">
	  		<div  class="panel-body">
	 			<h3 class="text" id="heading"> <a href="Portafoglio">Portafoglio</a></h3>
	  			<p class="text" id="heading">Qui puoi vedere il tuo operato con noi.  </p>
	  		</div>
	  	</div>
   </div>
    
    <div class="col-xl-4">
  		<div  id ="pannello2"class="panel panel-default">
	 		<div  class="panel-body">
	 			<h3 class="text" id="heading"> <a href="Chiarimenti">Chiarimenti</a></h3>
	  			<p class="text" id="heading">Se hai qualcosa da chiedere al capo.  </p>
	  		</div>
    	</div>
    </div>
</div>



</body>
</html>