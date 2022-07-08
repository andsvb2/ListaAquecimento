package metodos;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Mensageiro {

	public static void enviarProgramacaoDeHoje(String email) {

		Properties props = new Properties();
		props.put("mail.smtp.user", "projetopoo2022.1@gmail.com");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.debug", "false");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("projetopoo2022.1@gmail.com", "projeto2022");
			}
		});
		/** Ativa Debug para sessão */
		session.setDebug(false);
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("projetopoo2022.1@gmail.com"));
			Address[] toUser = InternetAddress
					.parse("mariabitargino123@gmail.com, svieira.anderson@gmail.com");
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Testando JavaMail");
			message.setText("Enviando email");
			Transport.send(message);
		} catch (MessagingException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu alguma falha no envio!",
					"falha no envio",
					JOptionPane.ERROR_MESSAGE);
			throw new RuntimeException(e);
		}
	}

}

