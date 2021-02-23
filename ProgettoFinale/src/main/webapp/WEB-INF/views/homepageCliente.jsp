<!DOCTYPE html>
<html>

<head>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>UnicalDelivery ClientVersion</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.homepage.css">
    <link rel="stylesheet" href="resources/font/font-awesome.min.css">
    <link rel="stylesheet" href="resources/font/ionicons.min.css">
    
    <link rel="stylesheet" href="resources/css/styles.min.homepage.css">
    <link rel="stylesheet" href="resources/css/styles.min.modalrecensione.css">
    
    <link rel="icon" href="resources/img/logoCircolare.jpg">
    <script src="resources/js/recensione.js"></script>
  
</head>

<body>


    <div class="container" id="logoContainer"><img id="logo" src="resources/img/logoHTML.jpg"></div>
    <div class="container-fluid" id="navbarContainer">
        <nav class="navbar navbar-light navbar-expand-md" id="mynavbar">
            <div class="container-fluid"><a class="navbar-brand" id="mybrand" href="#">UnicalDelivery - Website</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item"><a class="nav-link active" id="link" href="/">Homepage</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="chisiamo">Chi siamo</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="lavoraconnoi">Lavora con noi</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="richiediconsegna">Ordina</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="recensioni">Su di noi</a>
                        <li class="nav-item"><div><a style="margin-left:20px" class="btn btn-primary btn-lg" role="button" data-toggle="modal" id="button" href="#myModal">Di' la tua!</a>
        <div class="modal fade" role="dialog" tabindex="-1" id="myModal">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4>Cosa pensi dei servizi UnicalDelivery?</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
                    <div class="modal-body"><img src="resources/img/ba8bce635ccf9ef40c23a169f804a8c5.jpg" style="width: 480px;margin-right: 20px;">
					<select id="motivazione" name="motivazione" class="custom-select">
						<option id="motivazione" selected> Inserisci motivazione </option>
						<option style="background-color:#f09e94"" value="Insoddisfatto, servizio pessimo."> Insoddisfatto, servizio pessimo. </option>
						<option style="background-color:#f09e94" value="Servizio da migliorare, si può fare di meglio."> Servizio da migliorare, si può fare di meglio. </option>
						<option style="background-color:#a0df98" value="Non male, mi sono trovato/a bene."> Non male, mi sono trovato/a bene. </option>
						<option style="background-color:#a0df98" value="Soddisfatto/a, servizio eccellente!"> Soddisfatto/a, servizio eccellente! </option>
						</select>
					<textarea id="descrizione" style="width: 480px;height:100px" placeholder="Inserisci una didascalia..."></textarea></div>
                    <div class="modal-footer"><button class="btn btn-light" data-dismiss="modal" type="button">Annulla</button>
                    <button class="btn btn-primary" id="recensioneBtn" type="button">Invia recensione</button></div>
                </div>
            </div>
        </div>
    </div></li>
                    </ul>
            </div>
    </div>
    </nav>
    </div>
    <div class="article-list">
        <div class="container">
            <div class="intro">
                <h2 class="text-center" id="heading">Benvenuto/a nel nostro sito ufficiale!</h2>
                <p class="text-center" id="paragrafo">Unical Delivery, in qualsiasi momento, al servizio dei propri clienti, pronta a soddisfare qualsiasi esigenza!</p>
            </div>
            <div class="row articles">
                <div class="col-sm-6 col-md-4 item"><a href="#"><img class="img-fluid" src="resources/img/chiSiamoFin.jpg"></a>
                    <h3 id="heading2" class="name">Chi siamo</h3>
                    <p id="testo" class="description">Unical Delivery offre la possibilita' di gestire le tue consegne nel minor tempo possibile, nella modalita' che preferisci, aerea o terrena! Puoi contattarci in qualsiasi momento e la tua richiesta sara' immediatamente presa in carico
                        e portata a termine nel tempo da te richiesto. Allora, cosa aspetti?!</p><a class="link" href="chisiamo">Chi siamo</a>
                </div>
                <div class="col-sm-6 col-md-4 item"><a href="#"><img class="img-fluid" src="resources/img/wewantyouu2.jpg"></a>
                    <h3 id="heading2" class="name">Lavora con noi</h3>
                    <p id="testo" class="description">Unical Delivery e' sempre alla ricerca di personale qualificato e motivato nel svolgere il proprio lavoro, se pensi di poter entrare a farne parte clicca qui (o sopra nella sezione apposita) :</p><a class="link" href="lavoraconnoi">Invia la tua richiesta d'assunzione!</a></div>
                <div
                    class="col-sm-6 col-md-4 item"><a href="#"><img class="img-fluid" src="resources/img/mappaFin.jpg"></a>
                    <h3 id="heading2" class="name">Ordina</h3>
                    <p id="testo" class="description">Affida a noi i tuoi ordini e spedizioni in totale sicurezza! La modalita' la scegli tu, a noi tutto il resto! Clicca qui (o sopra nella sezione apposita) :</p><a class="link" href="richiediconsegna">Invia la tua richiesta d'ordine!</a></div>
        </div>
    </div>
    </div>
    <div class="footer-basic">
        <footer>
            
            <ul class="list-inline">
                <li class="list-inline-item"><a id="link" href="/">Ritorna alla prima pagina</a></li>
                <li class="list-inline-item"><a id="link" href="FAQ">FAQ</a></li>
                <li class="list-inline-item"><a id="link" href="FAQ">Contatta l'azienda!</a></li>
                <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
            </ul>
            <p id="paragrafoUnical" class="copyright">Unical Delivery © 2021</p>
        </footer>
    </div>
    <!-- <script src="resources/js/jquery.min.homepage.js"></script>
    <script src="resources/js/bootstrap.min.homepage.js"></script>-->
    <script src="resources/js/jquery.min.introduction.js"></script>
    <script src="resources/js/bootstrap.min.introduction.js"></script>
    
</body>

</html>