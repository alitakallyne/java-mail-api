package br.com.enviando_mail;




/**
 * Unit test for simple App.
 */
public class AppTest {
    
	
	@org.junit.Test
	public void testeEmail () throws Exception {
		
		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("alitakallyne@gmail.com",
				"Curso JDev-Treinamento", 
				"Testando envio de email com java",
				"Esse texto é a descrição do meu email.");
	    
		enviaEmail.enviarEmail();
	  
	}
	
	 
}
