window.addEventListener("load",function(){
	registraEventi();
})

function registraEventi(){
	var emailBtn = document.getElementById("emailBtn");
	
	emailBtn.addEventListener("click",inviaEmail);
}

function inviaEmail(){
//	Email.send({
//		Host: "smtp.gmail.com",
//		Username: "pierpaolo@libero.it",
//		Password: "threat1999",
//		To: "pierpaolo.sestito.1999@gmail.com",
//		From: "pierpaolo@libero.it",
//		Subject : "prova",
//		Body: "Buono",
//	})
//		.then(function (message){
//			alert("Mail inviata");
//		});
	
	alert("ciao");
}