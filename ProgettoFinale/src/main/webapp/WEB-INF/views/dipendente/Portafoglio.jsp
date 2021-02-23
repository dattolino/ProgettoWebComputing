<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Portafoglio</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"></link>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="resources/css/bootstrap.min.homepage.css">
    <link rel="stylesheet" href="resources/font/font-awesome.min.css">
    <link rel="stylesheet" href="resources/font/ionicons.min.css">
    <link rel="stylesheet" href="resources/css/styles.min.homepage.css">
    <link rel="stylesheet" href="resources/css/Portafoglio.css">
    <script type="text/javascript">
window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light1", // "light2", "dark1", "dark2"
	animationEnabled: false, // change to true		
	title:{
		text: "Il tuo andamento"
	},
	data: [
	{
		// Change type to "bar", "area", "spline", "pie",etc.
		type: "column",
		dataPoints: [
			{ label: "Ordini Accettati",  y: ${accettati}  },
			{ label: "Ordini Rifiutati", y: ${rifiutati}  },
			{ label: "Bonus", y: ${bonus}  },
			{ label: "Ammonizione",  y: ${ammonizioni}  },
		]
	}
	]
});
chart.render();

}
</script>
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
                        <li id="indietro" class="nav-item"><a class="nav-link" id="link" href="Profilo">Indietro</a></li>
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
	  
		   <div id="datiPortafoglio" class="container">
  				<h2 class="text" id="heading" >Portafoglio</h2>
  			 
  			
		  
			  <h3 id="heading">Stipendio : ${stipendio}</h3>
			  <h3 id="heading">Lavori Accettati : ${accettati}</h3>
			  <h3 id="heading">Lavori Rifiutati : ${rifiutati}</h3>
			  <h3 id="heading">Bonus : ${bonus}</h3>
			  <h3 id="heading">Ammonizioni : ${ammonizioni}</h3>
		  </div>
	  </div>
  
  
   <div class="col-xl-4">
	    <div id="pannello1" class="panel panel-default">
	  		<div  class="panel-body">
	 			<h2 class="text" id="heading"><a href="Portafoglio">I tuoi dati</a></h2>
         		<canvas width="300px" height="200px" id="chart-pie" class="chart-canvas">		
         		</canvas>
	  		</div>
	  	</div>
   </div>
    
    <div class="col-xl-4">
  		<div  id ="pannello2"class="panel panel-default">
	 		<div  class="panel-body">
	 			<div id="chartContainer" style="height: 370px; width: 100%;"></div>
				<script src="https://canvasjs.com/assets/script/canvasjs.min.js"> </script>
	  		</div>
    	</div>
    </div>
</div>
   
   <script >
  var canvas = document.getElementById("chart-pie");
  var ctx = canvas.getContext("2d");
  var lastend = 0;
  var data = [${rifiutati},${accettati},${bonus},${ammonizioni}];
  var myTotal = 0;
  var myColor = ['orange', 'green','blue','red'];
  var labels = ['Rif.', 'Acc.', 'Bo.','Am.'];

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