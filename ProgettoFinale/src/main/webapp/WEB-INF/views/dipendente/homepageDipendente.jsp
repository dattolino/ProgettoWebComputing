<!DOCTYPE html>

<html>

<head>
<meta charset="ISO-8859-1">
	<title>Homepage</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="resources/css/bootstrap.min.homepage.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="resources/font/font-awesome.min.css">
    <link rel="stylesheet" href="resources/font/ionicons.min.css">
    <link rel="stylesheet" href="resources/css/styles.min.homepage.css">
    <link rel="stylesheet" href="resources/css/homepageDipendente.css">
    <script src="resources/js/homepageDipendente.js"></script>
    
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
 <div id="pagina" >  
 <div id="i" class="container" id="logoContainer"><img id="logo" src="resources/img/logoHTML.jpg"></div>
    <div class="container-fluid" id="navbarContainer">
        <nav class="navbar navbar-light navbar-expand-md" id="mynavbar">
            <div class="container-fluid"><a class="navbar-brand" id="mybrand" href="#">UnicalDelivery - Website</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul  class="nav navbar-nav">
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
 
  <div class="col-xl-4"> 
  <div id="pannelloIntro" class="panel panel-default">
  			<div class="intro">
                <h1 class="text" id="heading"  >Benvenuto ${nome}, questa è la tua homepage!</h1>
                <figure>
				<img src="resources/img/${CT}.jpg" width="350px" />
				<figcaption></figcaption>
				</figure>
            </div>
		</div>
  </div>
  
    <div class="col-xl-4">            
  		<div id="pannelloNotifiche" class="panel panel-default">
  			<header class="panel-heading">
  				 <h1 class="panel-title" id="heading">Notifiche</h1>
  			</header>
  		
  			<div class="intro">
                <h2 id="heading" ><a href="listaOrdiniInAttesa">Hai ${inattesa} ordini inoltrati da accettare</a></h2>
                <h2 id="heading" ><a href="listaOrdiniInAttesa">Hai ${intransito} ordini accettati da consegnare</a></h2>
                <h2 id="heading" ><a href="listaOrdiniInAttesa">Hai ${consegnato} ordini consegnati da archiviare</a></h2>
            </div>
    	</div>
    		
	</div>
				


  <div class="col-xl-4">
  		<div id="pannelloGrafico" class="panel panel-default">
  		 	
  		 		 <h1 class="text" id="heading">Statistiche</h1>
                <h2 class="text" id="heading"><a href="Portafoglio">Ecco le tue statistiche aggiornate</a></h2>
         		<canvas width="400px" height="200px" id="chart-pie" class="chart-canvas">		
         		</canvas>
     	</div>  
  </div>
  
  	</div>
  	
	
 
  


  
   
<!--   <div id="footer" class="footer-basic"> -->
<!--         <footer> -->
<!--             <ul class="list-inline"> -->
<!--                 <li class="list-inline-item"><a href="#">Contatti</a></li> -->
                
<!--                 <li class="list-inline-item"><a href="#">Privacy Policy</a></li> -->
<!--             </ul> -->
<!--             <p id="paragrafoUnical" class="copyright">Unical Delivery Â© 2021</p> -->
<!--         </footer> -->
<!--     </div> -->
  
</div>
  <script >
  var canvas = document.getElementById("chart-pie");
  var ctx = canvas.getContext("2d");
  var lastend = 0;
  var data = [60,210,90];
  var myTotal = 0;
  var myColor = ['#afcc4c', '#95b524','#c1dd54'];
  var labels = ['', '', ''];

  for(var e = 0; e < data.length; e++)
  {
    myTotal += data[e];
  }

  // make the chart 10 px smaller to fit on canvas
  var off = 10
  var w = (canvas.width - off) / 2
  var h = (canvas.height - off) / 2
  for (var i = 0; i < data.length; i++) {
    ctx.fillStyle = myColor[i];
    ctx.strokeStyle ='white';
    ctx.lineWidth = 2;
    ctx.beginPath();
    ctx.moveTo(w,h);
    var len =  (data[i]/myTotal) * 2 * Math.PI
    var r = h - off / 2
    ctx.arc(w , h, r, lastend,lastend + len,false);
    ctx.lineTo(w,h);
    ctx.fill();
    ctx.stroke();
    ctx.fillStyle ='white';
    ctx.font = "20px Arial";
    ctx.textAlign = "center";
    ctx.textBaseline = "middle";
    var mid = lastend + len / 2
    ctx.fillText(labels[i],w + Math.cos(mid) * (r/2) , h + Math.sin(mid) * (r/2));
    lastend += Math.PI*2*(data[i]/myTotal);
  }
  </script> 
    
    

</body>
</html>