package br.com.enviando_mail;




/**
 * Unit test for simple App.
 */
public class AppTest {
    
	
	@org.junit.Test
	public void testeEmail () throws Exception {
		
		StringBuilder stringBuilderTextoEmail = new StringBuilder();
		stringBuilderTextoEmail.append("Olá, <br/><br/>");
		stringBuilderTextoEmail.append("Você esta recebendo acesso ao curso de Java.<br/><br/>");
		stringBuilderTextoEmail.append("Para ter acesso clique no botão abaixo.<br/><br/>");
		stringBuilderTextoEmail.append("<a target=\"_blank\" href = \"https://auth.dio.me/realms/master/protocol/openid-connect/auth?client_id=spa-core-client&redirect_uri=https%3A%2F%2Fweb.dio.me%2Fcourse%2F092d0a8e-e17c-49a5-95f4-99f971e7478b%2Flearning%2F131bfee1-a60c-4fb7-8712-dac3d90e9d86%3Fback%3D%2Ftrack%2Fmicrosoft-azure-essentials%26tab%3Dundefined%26moduleId%3Dundefined&state=5341ac49-31e7-460b-a00b-b9f27b989638&response_mode=fragment&response_type=code&scope=openid&nonce=62869899-11bb-4a7c-83be-b6cf1535b7e0\" style =\"color:#2525a7; padding: 14px 25px; text-align:center; text-decoration: none; display:inline-block;border-radius:30px;font-size:20px;font-family:courier;border:3 px solid green;background-color:#99DA39;\" > Acessar Portal </a>");
		
		
		ObjetoEnviaEmail enviaEmail = new ObjetoEnviaEmail("alitakallyne@gmail.com",
				"Curso JDev-Treinamento", 
				"Testando envio de email com java",
				stringBuilderTextoEmail.toString());
	    
		enviaEmail.enviarEmail(true);
	  
	}
	
	 
}
