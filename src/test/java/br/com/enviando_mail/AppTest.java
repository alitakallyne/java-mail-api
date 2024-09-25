package br.com.enviando_mail;

import java.util.Properties;


/**
 * Unit test for simple App.
 */
public class AppTest {
    

	@org.junit.Test
	public void testeEmail () {
		
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.port", "587");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	}
	
	 
}
