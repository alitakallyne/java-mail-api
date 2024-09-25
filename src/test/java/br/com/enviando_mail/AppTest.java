package br.com.enviando_mail;


import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * Unit test for simple App.
 */
public class AppTest {
    

	private String userName = "email@gmail.com ";
	
	private String senha = "senha_teste"; //Feito no geradpr de Senha De APPS do Google
	

	
	@org.junit.Test
	public void testeEmail () {
		
		try {
		
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com"); //SERVIDOR GEMAIL GOOGLE
	    props.put("mail.smtp.port", "465");// PORTA DO SERVIDOR
	    props.put("mail.smtp.auth", "true"); //AUTORIZAÇÃO
	    props.put("mail.smtp.starttls.enable", "true"); //AUTENTICAÇÃO
	    props.put("mail.smtp.starttls.enable", "true"); //AUTENTICAÇÃO
	    props.put("mail.smtp.socketFactory.port", "465"); //ESPECIFICA A PORTA A SER CONECTADA PELO SOCKET
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); //CLASSE SOCKET DE CONEXÃO AO SMTP
	    
	    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
           
	    	@Override
	    	protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	    		
	    		return new javax.mail.PasswordAuthentication(userName, senha);
	    	}
        });
	    
	    System.out.println(session);
	    
	    Address [] toUser = InternetAddress.parse("alytakallyne@gmail.com,alitakallyne@gmail.com");
	    
	    Message message = new MimeMessage(session);
	    message.setFrom(new InternetAddress(userName)); //QUEM ESTA ENVIANDO O EMAIL
	    message.addRecipients(Message.RecipientType.TO, toUser); //EMAIL DE DESTINO
	    message.setSubject("CHEGOU EMAIL ENVIADO COM JAVA"); //ASSUNTO DO EMAIL
	    message.setText("Olá programador, vc acabou de receber um email enviado com Java do curso Formação Java Web do Alex!");
	    
	    Transport.send(message);
	    
	    
	    System.out.println("E-mail enviado com sucesso!");
	    
		}catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	
	 
}
