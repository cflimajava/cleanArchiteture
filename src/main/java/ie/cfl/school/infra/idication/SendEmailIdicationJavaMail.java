package ie.cfl.school.infra.idication;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import ie.cfl.school.application.interfaces.SendIndicatorEmail;
import ie.cfl.school.domain.student.Student;
import ie.cfl.school.domain.student.StudentBuilder;
import ie.cfl.school.infra.MenageProperties;

public class SendEmailIdicationJavaMail implements SendIndicatorEmail {

	@Override
	public void sendTo(Student student) {
		Properties prop = new Properties();

		/** Parâmetros de conexão com servidor Gmail */
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");

		String sender = MenageProperties.getString("email.sender");
		String emailPassword = MenageProperties.getString("email.password");

		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sender, emailPassword);
			}
		});

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(sender));
			// Remetente

			Address[] toUser = InternetAddress.parse(student.getEmail().getAddress());

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("School Indication");// Assunto
			message.setText("Mr(s). " + student.getName() + ", you was indicated to be a winner.");

			/** Método para enviar a mensagem criada */
			Transport.send(message);

			System.out.println("Feito!!!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		Student student = new StudentBuilder()
				.withNameCPFEmail("Cristiano indicado", "060.346.506-40", "criferlim@yahoo.com.br").build();

		SendEmailIdicationJavaMail sender = new SendEmailIdicationJavaMail();
		sender.sendTo(student);
	}

}
