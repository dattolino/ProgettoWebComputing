package it.unicaldelivery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import persistence.configuration.PostgresDAOFactory;
/******************************************************************************
 * 																			  *
 * @author Pierpaolo Sestito, Chiara D'Amico, Francesco Dattolo, Adriano Cozza*
 *		Unical Delivery - Progetto di WebComputing 20/21					  *
 ******************************************************************************
 */
@SpringBootApplication
public class MainApp {
   public static void main(String[] args) {
	   PostgresDAOFactory.initDB();
      SpringApplication.run(MainApp.class, args);
      
      
   }
}