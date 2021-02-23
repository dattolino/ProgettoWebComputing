package utility;

import java.util.Properties;

/*<%@ page import = "java.io.*,java.util.*,javax.mail.*"%>
<%@ page import = "javax.mail.internet.*,javax.activation.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ page import = "it.javaboss.controller.*" %>*/

import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SyntheticMailSender {

	public static String sendEmail(String to,String subject,String msg) {
		
			String result;
		  
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
		   } catch (MessagingException mex) {
		      mex.printStackTrace();
		      result = "Error: unable to send message....";
		   }
		return result;
		
	}
	
	public static String botSendsEmail(String subject, String msg) {
		String result;
		  
		   // Sender's email ID needs to be mentioned
		   String from = "unicaldelivery@gmail.com";

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
		                               new InternetAddress("unicaldeliveryspa@gmail.com"));
		      // Set Subject: header field
		      message.setSubject(subject);
		      
		      // Now set the actual message
		      message.setText(msg);
		      
		      // Send message
		      Transport transport = mailSession.getTransport("smtp");
		      transport.connect(from,"defaultpassword1!");
		      transport.sendMessage(message,message.getAllRecipients());
		      result = "Sent message successfully....";
		   } catch (MessagingException mex) {
		      mex.printStackTrace();
		      result = "Error: unable to send message....";
		   }
		return result;
	}
}
