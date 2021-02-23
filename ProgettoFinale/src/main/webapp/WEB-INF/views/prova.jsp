<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>UnicalDelivery ClientVersion - Recensioni dei nostri clienti</title>
     <link rel="stylesheet" href="resources/css/bootstrap.min.scriptEmail.css">
    <link rel="stylesheet" href="resources/css/styles.min.recensione.css">
    <link rel="stylesheet" href="resources/css/bootstrap.min.homepage.css">
    <link rel="stylesheet" href="resources/font/font-awesome.min.css">
    <link rel="stylesheet" href="resources/font/ionicons.min.css">
    <link rel="stylesheet" href="resources/css/styles.min.homepage.css">
    <link rel="icon" href="resources/img/logoCircolare.jpg">
    
</head>
<body>
<div class="container" id="logoContainer"><img id="logo" src="resources/img/logoHTML.jpg"></div>
    <div class="container-fluid" id="navbarContainer">
        <nav class="navbar navbar-light navbar-expand-md" id="mynavbar">
            <div class="container-fluid"><a class="navbar-brand" id="mybrand" href="#">UnicalDelivery - Website</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navcol-1">
                    <ul class="nav navbar-nav">
                        <li class="nav-item"><a class="nav-link" id="link" href="homepageCliente">Homepage</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="chisiamo">Chi siamo</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="lavoraconnoi">Lavora con noi</a></li>
                        <li class="nav-item"><a class="nav-link" id="link" href="richiediconsegna">Ordina</a></li>
                        <li class="nav-item"><a class="nav-link active" id="link" href="prova">Su di noi</a></li>
                    </ul>
                    
            </div>
    </div>
    </nav>
    </div>
    <c:choose>
					<c:when test = "${size == 0}">
					<center><h1>Al momento nessun cliente ha rilasciato una sua recensione.</h1></center>
					</c:when>
					<c:otherwise>
					<c:forEach var="persona" items="${listaRecensioni}">
		 <section>
        <div class="container">
            <div class="photo-card">
                <div class="photo-background" style="background: url(&quot;${persona.getImmagine()}&quot;) center / contain no-repeat;"></div>
                <div class="photo-details">
                    <h1>${persona.getMotivazione()}</h1>
                    <p>${persona.getDescrizione()}&nbsp; </p>
                    <div class="photo-tags">
                        <ul></ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
	</c:forEach>
		</c:otherwise>
	</c:choose>
	
	
    <!-- <script src="resources/js/jquery.min.recensione.js"></script>
    <script src="resources/js/bootstrap.min.recensione.js"></script>-->
</body>

</html>