<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>UnicalDelivery - Riepilogo dati ordine</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.riepilogoordine.css">
    <link rel="stylesheet" href="resources/css/styles.min.riepilogoordine.css">
    <link rel="icon" href="resources/img/logoCircolare.jpg">
</head>

<body>
    <div id="block" class="login-clean">
        <form action="conferma" method="get">
            <h2 class="sr-only">Riepilogo:</h2>
            <div class="table-responsive" id="table" style="background: url(&quot;resources/img/logoOpaco.jpg&quot;);">
                <table class="table">
                    <thead>
                        <tr>
                            <th id="tableheader">Riepilogo dati richiesta ordine:</th>
                            <th id="tableheader">I tuoi dati:</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td id="tablerow">Nome completo richiedente:</td>
                            <td id="data">${nome}</td>
                        </tr>
                        <tr>
                            <td id="tablerow">Email richiedente:</td>
                            <td id="data">${email}</td>
                        </tr>
                        <tr>
                            <td id="tablerow">Da:</td>
                            <td id="data">${da}</td>
                        </tr>
                        <tr>
                            <td id="tablerow" class="tablerow">A:</td>
                            <td id="data">${a}</td>
                        </tr>
                        <tr>
                            <td id="tablerow">Via:</td>
                            <td id="data">${via}</td>
                        </tr>
                        <tr>
                            <td id="tablerow">Modalita':</td>
                            <td id="data">${modalita}</td>
                        </tr>
                        <tr>
                            <td id="tablerow">Richiesta</td>
                            <td id="data">${richiesta}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="table-responsive" id="tablepayment">
                <table class="table">
                    <thead>
                        <tr>
                            <th id="tableheader">Metodo di pagamento</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td id="tablerow">Numero carta:</td>
                            <td id="data">${numeroCarta}</td>
                        </tr>
                        <tr>
                            <td id="tablerow">CVV:</td>
                            <td id="data">${CVV}</td>
                        </tr>
                        <tr>
                            <td id="tablerow">Scadenza:</td>
                            <td id="data">${scadenzaCarta}</td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="form-group"><button class="btn btn-primary btn-block" id="myButton" type="submit">Conferma ordine&nbsp;</button></div>
            <a id="linkleft" href="/richiediconsegna">Non sei sicuro? Fai una nuova richiesta!</a>
            <a id="linkright" href="/">Torna all'homepage</a></form>
    </div>
    
</body>

</html>