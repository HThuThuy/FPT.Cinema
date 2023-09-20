package fa.training.service;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	private static final int OTP_LENGTH = 6;

// Lưu OTP vào session
	public boolean sendOtpEmail(String to, HttpSession session) {
		String subject = "Your OTP";
		String otp = generateOtp();
		String message = "Your OTP is: " + otp;

		// Save the OTP in the session
		session.setAttribute("OTP", otp);

		return sendEmail(subject, message, to);
	}

	private String generateOtp() {
		Random random = new Random();
		StringBuilder otp = new StringBuilder(OTP_LENGTH);
		for (int i = 0; i < OTP_LENGTH; i++) {
			int index = random.nextInt(CHAR_LIST.length());
			otp.append(CHAR_LIST.charAt(index));
		}
		return otp.toString();
	}

	public boolean sendEmail(String subject, String message, String to) {
		boolean f = false;
		String from = "fptcinema@gmail.com";
		String host = "smtp.gmail.com";
		// get the system properties
		Properties properties = System.getProperties();
		System.out.println("PROPERTIES " + properties);

		// setting important information to properties object

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "false");

		// Step 1: to get the session object..
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("fptcinema@gmail.com", "diuwgnqlxnmhqnnt");
			}

		});

		session.setDebug(true);

		// Step 2 : compose the message [text,multi media]
		MimeMessage m = new MimeMessage(session);

		try {

			// from email
			m.setFrom(from);

			// adding recipient to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// adding subject to message
			m.setSubject(subject);

			// adding text to message
			m.setText(message);

			// send

			// Step 3 : send the message using Transport class
			Transport.send(m);

			System.out.println("Sent success...................");
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

// việc lưu OTP vào session như thế này chỉ hoạt động nếu bạn đang tạo OTP và
// xác thực nó trong cùng một phiên hoạt động. Nếu người dùng đóng trình duyệt,
// hoặc nếu session hết hạn trước khi họ xác thực OTP, thì OTP sẽ bị mất.
	public boolean verifyOtp(String userOtp, HttpSession session) {
		String sessionOtp = (String) session.getAttribute("OTP");

		// Make sure to remove the OTP from the session
		session.removeAttribute("OTP");

		return userOtp.equals(sessionOtp);
	}
}