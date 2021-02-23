<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>UnicalDelivery - Frequently Asked Question</title>
    
    
    <link rel="stylesheet" href="resources/css/bootstrap.min.faq.css">
    <link rel="stylesheet" href="resources/css/bootstrap.min.gestionidipendentiprova.css">
    
    <link rel="stylesheet" href="resources/font/font-awesome.min.css">
    <link rel="stylesheet" href="resources/css/styles.min.faq.css">
    <link rel="stylesheet" href="resources/css/styles.min.gestionedipendentiprova.css">
    <link rel="icon" href="resources/img/logoCircolare.jpg">
    <script src="resources/js/faq.js"></script>
</head>

<body>
    <div id="block" class="features-blue">
        <div class="container">
            <div class="intro">
                <h2 class="text-center" id="titolo">Unical Delivery - FAQ</h2>
                <p class="text-center" id="sottotitolo">Frequently asked questions</p>
            </div>
            <div class="row features">
                <div class="col-sm-6 col-md-4 item"><i class="fa fa-map-marker icon"></i>
                    <h3 class="name">Per i professori</h3>
                    <p>Abbiamo creato per voi delle credenziali d'accesso che vengono inizializzate al primo avvio della web-app. Ecco a voi le credenziali per accedere come capo o come dipendente:</p>
                    <details>
										<summary id="summary">Clicca qua per avere le credenziali!</summary>
										<p style="background-color:gray">Per entrare come capo dell'azienda:<br/>
										<strong>email:</strong>esamewebcomputing@capo.it<br/>
										<strong>password:</strong>unicaldelivery<br/>
										Per entrare come dipendente dell'azienda:<br/>
										<strong>email:</strong>esamewebcomputing@dipendente.it<br/>
										<strong>password:</strong>defaultpassword<br/></p>
									</details>
                </div>
                <div class="col-sm-6 col-md-4 item"><i class="fa fa-clock-o icon"></i>
                    <h3 class="name">Hai esaurito i tentativi di login?</h3>
                    <p class="description">Sei stato rimandato su questa pagina perche' hai esaurito i tentativi d'accesso. Controlla eventuale licenziamento da parte dell'azienda oppure mettiti in contatto con il capo.&nbsp;</p>
                </div>
                <div class="col-sm-6 col-md-4 item"><i class="fa fa-phone-square icon"></i>
                    <h3 class="name">Come contattare l'azienda all'esterno del sito?</h3>
                    <p class="description">L'email dell'Unical Delivery S.p.A e' : unicaldeliveryspa@gmail.com<br><br>E' possibile inoltre contattare su WhatsApp i nostri sviluppatori scannerizzando il codice QR sulla pagina <br/>
                    <a style="color:yellow" href="chisiamo">UnicalDelivery - Chi siamo!</a>&nbsp;</p>
                    <a class="btn btn-primary btn-lg" role="button" data-toggle="modal" href="#myModal-1">Contatta</a>
                </div>
                <div class="col-sm-6 col-md-4 item"><i class="fa fa-map-o icon"></i>
                    <h3 class="name">UnicalDelivery Maps</h3>
                    <p class="description">La UnicalDelivery Maps e' un applicativo integrato nel sito-web che permette di geolocalizzare le posizioni, e poter tracciare la distanza da due cittÃ  differenti. Viene messo a disposizione dei nostri dipendenti per poter tracciare
                        il loro percorso. E' possibile farlo in bicicletta, in auto, e con mezzi di trasporto alternativi.<br/>
                        <a style="color:yellow" href="visualizzaMap">UnicalDelivery Maps - Clicca qua!</a></p>
                </div>
                <div class="col-sm-6 col-md-4 item"><i class="fa fa-users icon"></i>
                    <h3 class="name">Per gli aspiranti dipendenti</h3>
                    <p class="description">All'accettazione o eventuale rifiuto della vostra richiesta d'assunzione, riceverete un mail sull'indirizzo di posta elettronica fornito al momento della richiesta d'assunzione.
                    Se siete stati reindirizzati qua dopo aver fatto una richiesta d'assunzione vuol dire che lei ha già sottoposto la sua domanda recentemente ed il capo la deve ancora revisionare. 
                    Ricevera' un email con nuove notizie il prima possibile!</p>
                </div>
                <div class="col-sm-6 col-md-4 item"><i class="fa fa-phone icon"></i>
                    <h3 class="name">Per i clienti</h3>
                    <p class="description">Per eventuali informazioni, contattare l'azienda all'indirizzo di posta elettronica sopra elencato.
                    </p>
                </div>
            </div>
        </div>
    </div>
    <div>
        <div class="modal fade" role="dialog" tabindex="-1" id="myModal-1">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4>Contatta l'azienda!</h4><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button></div>
                    <div class="modal-body">
                    <details>
                    <summary style="background-color:blue">Come funziona?</summary>
										<p style="background-color:gray">L'azienda viene contattata da un email-bot che ha i permessi necessari per inviare e-mail da app non sicure(tipo questa, poiché non ha un vero dominio, ma è hostata su un server locale). Facciamo questo per evitare
										di far esporre l'email dei nostri clienti alle app non sicure, perciò utilizzano l'email-bot messa a disposizione da noi. Il capo dell'azienda inoltrerà la risposta all'email fornita in "Email richiedente"</p>
									</details>
                        <section class="td-form">
                            <div class="row td-form-wrapper">
                                <div class="col td-glass">
                                   <!--action="contattaDipendente" method="post"-->
                                        <h1 class="text-center"></h1>
                                        <div class="form-group">
                                            <div class="col-md-12"><label for="email">Email richiedente :</label>
                                                <div class="d-flex"><i class="icon ion-ios-email align-self-center"></i>
												<input class="form-control" id="emailRichiedente" type="email" autocomplete="off" name="to" required="" placeholder="dipendente@unicaldelivery.com" inputmode="email"></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12"><label for="subject">Oggetto :&nbsp;</label>
                                                <div class="d-flex td-input-container"><i class="icon ion-ios-information align-self-center"></i>
												<input class="form-control" id="subject" type="text" autocomplete="off" placeholder="Inserisci l'oggetto della richiesta" name="subject" required=""></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12"><label for="message">Richiesta :</label>
                                                <div class="d-flex td-input-container"><i class="icon ion-android-create align-self-center"></i>
												<textarea id="message" class="form-control" placeholder="Inserisci la richiesta qua!" name="msg" rows="6" cols="50"></textarea></div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-md-12"><button id="contattaUnicalDelivery" class="btn btn-dark float-right" type="button">Invia il messaggio!</button></div>
                                        </div>
                                   
                                </div>
                            </div>
                        </section>
                    </div>
                    <div class="modal-footer"><button class="btn btn-light" data-dismiss="modal" type="button">Chiudi</button></div>
                </div>
            </div>
        </div>
    </div>
   <script src="resources/js/jquery.min.introduction.js"></script>
    <script src="resources/js/bootstrap.min.introduction.js"></script>
    <footer style="background-color: black">
           <central><a style="color:yellow;padding-left:500px;font-weight:bold" href="/">Ritorna alla pagina principale</a></central>
        </footer>
</body>

</html>