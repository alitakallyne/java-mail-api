package br.com.enviando_mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.imageio.stream.FileImageInputStream;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

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
	
	

	public void enviarEmailAnexo(boolean envioHTML)  throws Exception{
				
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
		    
		    /* PARTE 1 DO EMAIL QUE É TEXTO E DESCRIÇÃO*/
		    MimeBodyPart corpoEmail = new  MimeBodyPart ();
		    
		    if(envioHTML) {
		    	corpoEmail.setContent(textoEmail, "text/html; charset=utf-8");
		    }else {
		    	corpoEmail.setText(textoEmail);
		    }
		    
		    
		    List<FileInputStream> arquivos = new ArrayList<FileInputStream>();
		    arquivos.add(simuladorDePDF());
		    arquivos.add(simuladorDePDF());
		    arquivos.add(simuladorDePDF());
		    arquivos.add(simuladorDePDF());
		    
		    Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(corpoEmail);
		    
		    int index = 0;
		    for (FileInputStream fileInputStream : arquivos) {
				
			    /* PARTE 2 DO EMAIL QUE SÃO O ANEXOS EM PDF */
			    MimeBodyPart anexoEmail = new  MimeBodyPart ();
			    
			    
			    /*ONDE É PASSADO O SIMULADORDEPDF VOCÊ PASSA SEU ARQUIVO GRAVADO NO BANCO DE DADOS*/
			    anexoEmail.setDataHandler(new DataHandler(new ByteArrayDataSource(fileInputStream,"aplication/pdf")));
			    anexoEmail.setFileName("anexoemail"+index+".pdf");
			    
				multipart.addBodyPart(anexoEmail);
				
				index++;
		    }
			message.setContent(multipart);
		    
		    Transport.send(message);
		    
		    
		    System.out.println("E-mail enviado com sucesso!");
		    
	}
	
	
	//ESSE METODO SIMULA O PDF OU QUALQUER ARQUIVO QUE POSSA SER ENVIADO POR ANEXO NO MEAIL.
	//VODE PODE PEGAR O ARQUIVO NO SEU BANCO DE DADOS BASE64,BYTE[],STREAM DE ARQUIVOS.
	// PODE ESTAR E UM BANCO DE DADOS , OU EM UMA PASTA
	//RETORN UM PDF EM BRANCO COM O TEXTO DO PARAGRAFO DE EXEMPLO.
	private FileInputStream simuladorDePDF() throws Exception {
		
		Document  document = new Document();
		File file = new File("fileanexo.pdf");
		file.createNewFile();
		PdfWriter.getInstance(document, new FileOutputStream(file));
		document.open();
		document.add(new Paragraph("Conteudo do PDF anexo com Java Mail, esse texto é do PDF"));
		document.close();
		
		return new FileInputStream(file);
		
	}

}
