<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>UnicalDelivery - Pagamento sportello online</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.homepage.css">
    <link rel="stylesheet" href="resources/css/styles.min.pagamentoonline.css">
    <link rel="icon" href="resources/img/logoCircolare.jpg">
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    
    <script>
    	function checkPagamento(){
    		var numeroCarta = document.getElementById('numeroCarta');
 			if(numeroCarta.value.length!=13 && numeroCarta.value.length!=16){
 				swal("Errore!","Devi inserire un numero di carta valido","error");
    			numeroCarta.style.backgroundColor = "#EB5255";
    			return false;
 			}
 			var numeroCVV = document.getElementById('CVV');
 			if(numeroCVV.value.length!=3){
 				swal("Errore!","Devi inserire un CVV valido","error");
    			numeroCVV.style.backgroundColor = "#EB5255";
    			return false;
 			}
 			var scadenza = document.getElementById('scadenzaCarta');
 			if(scadenza.value==""){
 				swal("Errore!","Devi inserire una scadenza valida","error");
    			scadenza.style.backgroundColor = "#EB5255";
    			return false;
 			}
    	}
    
    </script>
</head>

<body>
    <div class="container-fluid" id="navbarContainer">
        <nav class="navbar navbar-light navbar-expand-md" id="mynavbar">
            <div class="container-fluid"><a class="navbar-brand" id="mybrand" href="#">UnicalDelivery - Website</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div
                    class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item"><a class="nav-link" id="link" href="/">Homepage</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="chisiamo">Chi siamo</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="lavoraconnoi">Lavora con noi</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="richiediconsegna">Ordina</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="prova">Su di noi</a>
                    </ul>
            </div>
    </div>
    </nav>
    </div>
    <h3 class="text-center" id="heading">Inserisci i tuoi dati:</h3>
    <center><label>Importo da pagare: ${prezzoDaPagare}</label></center>
    <div class="container"><img id="immagineCarta" src="resources/img/carta%20di%20credito.png">
        <form action="riepilogoOnline" method="post" onsubmit="return checkPagamento()">
            <div class="form-group">
                <p id="text">Numero carta:</p><input class="form-control" type="number" id="numeroCarta" name="numeroCarta"></div>
            <div class="form-group">
                <p id="text">CVV:</p><input class="form-control" type="number" id="CVV" name="CVV"></div>
            <div class="form-group">
                <p id="text">Scadenza:</p><input class="form-control form-control-lg" type="month" id="scadenzaCarta" name="scadenzaCarta"></div>
            <div class="form-group"><button class="btn btn-primary" id="button" type="submit">Conferma pagamento</button></div>
        </form>
    </div>
    <!-- <script src="resources/js/jquery.min.pagamentoonline.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.pagamentoonline.js"></script> -->
</body>

</html>