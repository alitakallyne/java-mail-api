package br.com.enviando_mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ObjetoEnviaEmail {
	
	
    private String userName = "alitakallyne@gmail.com ";
	
	private String senha = "gsmz cbeq fsgu rjnn"; //Feito no geradpr de Senha De APPS do Google
	//private String senha = "#kalitah97";

	private String listaDestinatarios = "";
	private String nomeRemetente = "";
	private String assunto = "";
	private String textoEmail = "";
	
	
	
	public ObjetoEnviaEmail(String listaDestinatarios, String nomeRemetente, String assunto, String textoEmail) {
		this.listaDestinatarios = listaDestinatarios;
		this.nomeRemetente = nomeRemetente;
		this.assunto = assunto;
		this.textoEmail = textoEmail;
	}



	public void enviarEmail(boolean envioHTML)  throws Exception{
				
			Properties props = new Properties();
		    props.put("mail.smtp.ssl.trust", "*");
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
		    
		    Address [] toUser = InternetAddress.parse(listaDestinatarios);
		    
		    Message message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(userName,nomeRemetente)); //QUEM ESTA ENVIANDO O EMAIL
		    message.addRecipients(Message.RecipientType.TO, toUser); //EMAIL DE DESTINO
		    message.setSubject(assunto); //ASSUNTO DO EMAIL
		    
		    if(envioHTML) {
		    	 message.setContent(textoEmail, "text/html; charset=utf-8");
		    }else {
		    	 message.setText(textoEmail);
		    }
		   
		    
		    Transport.send(message);
		    
		    
		    System.out.println("E-mail enviado com sucesso!");
		    
	}

}
