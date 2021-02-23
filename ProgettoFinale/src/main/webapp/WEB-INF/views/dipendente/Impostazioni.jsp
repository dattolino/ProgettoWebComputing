<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Impostazioni</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="resources/css/bootstrap.min.homepage.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/font/font-awesome.min.css">
    <link rel="stylesheet" href="resources/font/ionicons.min.css">
    <link rel="stylesheet" href="resources/css/styles.min.homepage.css">
    <link rel="stylesheet" href="/resources/css/homepageDipendente.css">
    <script src="resources/js/homepageCapo.js"></script>
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
    
    #mydiv{
	width: 100%;
	background-color:  #c0c0c0;
		text-align: center;
	
}
    </style>
    
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
<div id="i" class="container" id="logoContainer"><img id="logo" src="resources/img/logoHTML.jpg"></div>
    <div class="container-fluid" id="navbarContainer">
        <nav class="navbar navbar-light navbar-expand-md" id="mynavbar">
            <div class="container-fluid"><a class="navbar-brand" id="mybrand" href="#">UnicalDelivery - Website</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item"><a class="nav-link active" id="link" href="ricaricaHomepage">Homepage</a></li>
                        <li class="nav-item" ><a class="nav-link" id="link" href="listaOrdiniInAttesa" >Richieste Ordini</a></li>
                        
                        <li id="profilo" class="nav-item"><a class="nav-link" id="link" href="Profilo">Profilo</a></li>
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
     <div id="mydiv" class="col-xl-8">
     	
     			<div class="form-group">
                    <h3 class="heading">Email Attuale:</h3><output id="emailAttuale" class="heading" > ${emailat}</output>
                  </div>
                 <div class="form-group">
                    <h3 class="heading">Inserisci la vecchia password:</h3><input class="form-control" type="password" id="vecchiaPassword" name="vecchiaPassword">
                 </div>
                 <div class="form-group">
                    <h3 class="heading">Inserisci la nuova password:</h3><input class="form-control" type="password" id="nuovaPassword" name="nuovaPassword">
                 </div>
                 <div class="form-group">
                    <h3 class="heading">*Inserisci la nuova email:</h3><input class="form-control" type="email" id="nuovaEmail" name="nuovaEmail">
                 </div>
             
                <button type="button" class="btn btn-primary" id="modificaBtn">Effettua modifica</button>
          
       </div>
    
    
    <div>
   <h4>*Opzionale</h4> 
    </div>
    <div class="col-xl-2"> 
</div>
    
   </div>


    

</body>
</html>