<%@ page import = "java.io.*,java.util.*,javax.mail.*"%>
<%@ page import = "javax.mail.internet.*,javax.activation.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "it.unicaldelivery.controller.*" %>

<%
   String result;
   
   String msg = EmailJSPController.msg;
   String to = EmailJSPController.to;
   String subject = EmailJSPController.subject;
   
   String inviato = "ciao";
  


   // Sender's email ID needs to be mentioned
   String from = "unicaldeliveryspa@gmail.com";

   // Assuming you are sending email from localhost
   String host = "smtp.gmail.com";

   // Get system properties object
   Properties properties = System.getProperties();

   // Setup mail server
   properties.setProperty("mail.smtp.host", host);
   properties.put("mail.smtp.port","587");
   properties.put("mail.smtp.starttls.enable","true");
   properties.put("mail.debug","true");

   // Get the default Session object.
   Session mailSession = Session.getDefaultInstance(properties);

   try {
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(mailSession);
      
      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));
      
      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));
      // Set Subject: header field
      message.setSubject(subject);
      
      // Now set the actual message
      message.setText(msg);
      
      // Send message
      Transport transport = mailSession.getTransport("smtp");
      transport.connect(from,"unicaldelivery");
      transport.sendMessage(message,message.getAllRecipients());
      result = "Sent message successfully....";
      System.out.println("Ciao");
      inviato = "true";
   } catch (MessagingException mex) {
      mex.printStackTrace();
      result = "Error: unable to send message....";
      System.out.println("Qua");
   }
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
   <head>
      <title>UnicalDelivery - Invio email da JSP</title>
      <link rel="icon" href="resources/img/logoCircolare.jpg">
        <link rel="stylesheet" href="resources/css/bootstrap.min.emailscript.css">
    <link rel="stylesheet" href="resources/css/styles.min.emailscript.css">
   </head>
   
   <body>
      
      <c:choose>
      	<c:when test = "result.equals('Sent message successfully....')">
      		<!-- resources/img/success.png resources/img/error.png -->
      		<section>
        <div class="container">
            <div class="photo-card">
                <div class="photo-background" style="background: url(&quot;resources/img/success.png&quot;) center / contain no-repeat;"></div>
                <div class="photo-details">
                	<p style="color:white;font-weight:bold">Email destinatario: </p>
                    <h1 name="to"><strong style="color:red">${to}</strong></h1>
                    <p style="color:white;font-weight:bold">Oggetto: </p>
                    <h1 name="subject" ><strong style="color:red">${subject}</strong></h1>
                    <p style="color:white;font-weight:bold">Messaggio: </p>
                    <p name="msg"><strong style="color:red">${message}</strong></p>
                    <div class="photo-tags">
                        <ul>
                           
                            <li><button class="btn btn-primary" id="button" type="button">Torna alla pagina precedente</button></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
      	</c:when>
      	<c:otherwise>
      		<section>
        <div class="container">
            <div class="photo-card">
                <div class="photo-background" style="background: url(&quot;resources/img/error.png&quot;) center / contain no-repeat;"></div>
                <div class="photo-details">
                	<form action="riprovaInvio" method="get">
                    <p style="color:white;font-weight:bold">Email destinatario: </p>
                    <h1 name="to"><strong style="color:red">${to}</strong></h1>
                    <p style="color:white;font-weight:bold">Oggetto: </p>
                    <h1 name="subject" ><strong style="color:red">${subject}</strong></h1>
                    <p style="color:white;font-weight:bold">Messaggio: </p>
                   	<p name="msg"><strong style="color:red">${message}</strong></p>
                    <div class="photo-tags">
                        <ul>
                            <li><button class="btn btn-primary" id="button" type="submit">Riprova</button></li>
                            </form>
                            <li><button class="btn btn-primary" id="button" type="button"><a href="dipendenti"></a>Torna alla pagina precedente</a></button></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
      	</c:otherwise>
      </c:choose>
      
      <!-- <p align = "center">
        <% 
            out.println("Result: " + result + "\n");
         %>
      </p>-->
      
   </body>
   <script src="resources/js/jquery.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
</html>