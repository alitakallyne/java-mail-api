# Java Mail Example com Gmail - Curso Jdev-Treinamento

Este repositório contém um exemplo prático de envio de e-mails usando a **Java Mail API** com o Gmail. O objetivo deste projeto é demonstrar como configurar e enviar e-mails através do serviço SMTP do Gmail, incluindo a autenticação e o uso de TLS.

Este projeto faz parte do curso **Jdev-Treinamento**, onde estou aprendendo a integrar envio de e-mails em aplicações Java.

## Funcionalidades

- Envio de e-mails simples em formato de texto (plain text)
- Envio de e-mails com corpo HTML
- Configuração de envio de e-mail com servidor SMTP do Gmail

## Pré-requisitos

- **Java 8** ou superior
- **Maven** ou **Gradle** para gerenciar dependências
- Uma conta no Gmail (com senha de app configurada, devido à autenticação segura)

## Dependências

No arquivo `pom.xml` (para projetos Maven), adicione a dependência da Java Mail API:

### Maven:
```xml
<dependency>
    <groupId>javax.mail</groupId>
    <artifactId>javax.mail-api</artifactId>
    <version>1.6.2</version>
</dependency>
