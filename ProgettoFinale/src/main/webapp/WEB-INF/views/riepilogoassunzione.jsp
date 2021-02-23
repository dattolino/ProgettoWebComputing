<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>UnicalDelivery - Riepilogo dati assunzione</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.riepilogoassunzione.css">
    <link rel="stylesheet" href="resources/css/styles.min.riepilogoassunzione.css">
    <link rel="icon" href="resources/img/logoCircolare.jpg">
</head>

<body>
    <div id="block" class="login-clean">
        <form action="confermaDati" method="get">
            <h2 class="sr-only">Riepilogo:</h2>
            <div class="table-responsive" id="table" style="background: url(&quot;resources/img/logoOpaco.jpg&quot;);">
                <table class="table">
                    <thead>
                        <tr>
                            <th id="tableheader">Riepilogo dati assunzione:</th>
                            <th id="tableheader">I tuoi dati:</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td id="tablerow">Codice fiscale</td>
                            <td>${codiceFiscale}</td>
                        </tr>
                        <tr>
                            <td id="tablerow">Nome</td>
                            <td>${nome}</td>
                        </tr>
                        <tr>
                            <td id="tablerow">Cognome</td>
                            <td>${cognome}</td>
                        </tr>
                        <tr>
                            <td id="tablerow" class="tablerow">Email</td>
                            <td>${email}</td>
                        </tr>
                        <tr>
                            <td id="tablerow">Ruolo</td>
                            <td>${ruolo}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="form-group"><button class="btn btn-primary btn-block" id="myButton" type="submit">Conferma dati</button>
            </div><a id="linkleft" href="lavoraconnoi">Non sei sicuro? Fai una nuova richiesta!</a>
            <a id="linkright" href="/">Torna all'homepage</a></form>
    </div>
   
</body>

</html>