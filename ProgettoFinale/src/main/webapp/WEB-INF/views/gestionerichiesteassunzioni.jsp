<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UnicalDelivery LeaderVersion - Gestione richieste d'assunzione</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" href="resources/css/bootstrap.min.homepageCapo.css">
    <link rel="stylesheet" href="resources/css/styles.min.homepageCapo.css">
    <link rel="stylesheet" href="resources/css/richiestebutton.css">
    <link rel="icon" href="resources/img/logoCircolare.jpg">
	<script src="resources/js/prova.js"></script>
	
</head>
<body>
<div><img id="logo" style="margin-left:350px" src="resources/img/logoHTML.jpg"></div>
    <nav class="navbar navbar-light navbar-expand-md navigation-clean-button" id="navbar">
        <div class="container"><a class="navbar-brand" id="brandNav" href="#">Unical Delivery</a><button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1"><span class="sr-only">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
            <div
                class="collapse navbar-collapse" id="navcol-1">
                <ul class="nav navbar-nav mr-auto">
                <li class="nav-item"><a class="nav-link" id="link" href="homepageCapo">Dashboard</a></li>
                    <li class="nav-item"><a class="nav-link" id="link" href="richiesteAssunzione">Richieste d'assunzione</a></li>
                    <li class="nav-item"><a class="nav-link" id="link" href="dipendenti">I miei dipendenti</a></li>
                    <li class="nav-item"><a class="nav-link" id="link" href="RichiesteOrdine">Richieste d'ordine</a></li>
                </ul>
                <span class="navbar-text actions"> <a class="btn btn-light action-button" role="button" id="logout" href="doLogout">Logout</a></span></div>
        </div>
    </nav>
   
<div class="card"><img class="card-img w-100 d-block" src="resources/img/lentesfondo2.jpg">
        <div class="card-img-overlay">
            <h4>Ricerca veloce nella tabella</h4><input type="text" id="myInput" onkeyup="myFunction()" placeholder="Cerca in base al codice fiscale" title="Type in a name"><input type="text" id="myInput2" onkeyup="myFunction2()" placeholder="Cerca in base all'email" title="Type in a name" style="margin-left:50px"></div>
    </div>
<div class="table-responsive">

<div class="table-responsive">
<table id="cartGrid" class="table table-striped table-bordered table-hover table-sm">
	<thead>
		<tr style="background-color:gray">
			<th></th>
			<th>Codice fiscale</th>
			<th>Nome</th>
			<th>Cognome</th>
			<th>Ruolo</th>
			<th>Email</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="richiesta" items="${listaRichiesteAssunzione}">
		<tr>
			<td><input type="radio" id="${richiesta.getCf().getValue()}" name="check" value="${richiesta.getCf().getValue()}"></td>
			<c:choose>
					<c:when test = "${richiesta.getRole().getValue().equals('ConsegnaTerrena') }">
						<td style= "background-color:#dc3912" id="check">${richiesta.getCf().getValue()}</td>
						<td style= "background-color:#dc3912">${richiesta.getName().getValue()}</td>
						<td style= "background-color:#dc3912">${richiesta.getSurname().getValue()}</td>
						<td style= "background-color:#dc3912">${richiesta.getRole().getValue()}</td>
						<td style= "background-color:#dc3912">${richiesta.getEmail().getValue()}</td>
					</c:when>
					<c:otherwise>
						<td style= "background-color:#3366cc">${richiesta.getCf().getValue()}</td>
						<td style= "background-color:#3366cc">${richiesta.getSurname().getValue()}</td>
						<td style= "background-color:#3366cc">${richiesta.getSurname().getValue()}</td>
						<td style= "background-color:#3366cc">${richiesta.getRole().getValue()}</td>
						<td style= "background-color:#3366cc">${richiesta.getEmail().getValue()}</td>
					</c:otherwise>
				</c:choose>
		</tr>
		</c:forEach>
			</tbody>
	
</table>
<script>
function myFunction() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput");
  filter = input.value.toUpperCase();
  table = document.getElementById("cartGrid");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[1];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
<script>
function myFunction2() {
  var input, filter, table, tr, td, i, txtValue;
  input = document.getElementById("myInput2");
  filter = input.value.toUpperCase();
  table = document.getElementById("cartGrid");
  tr = table.getElementsByTagName("tr");
  for (i = 0; i < tr.length; i++) {
    td = tr[i].getElementsByTagName("td")[5];
    if (td) {
      txtValue = td.textContent || td.innerText;
      if (txtValue.toUpperCase().indexOf(filter) > -1) {
        tr[i].style.display = "";
      } else {
        tr[i].style.display = "none";
      }
    }       
  }
}
</script>
	
</div>
	<button id="rifiutaBtn" type="button" class="btn btn-primary btn-lg">Rifiuta</button>
	<button id="accettaBtn" type="button" class="btn btn-primary btn-lg">Accetta</button>

</body>
</html>