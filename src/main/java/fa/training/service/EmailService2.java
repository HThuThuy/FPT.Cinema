//package fa.training.service;
//
//import java.util.Properties;
//import java.util.Random;
//import javax.mail.Message;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.servlet.http.HttpSession;
//import javax.mail.Session;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Authenticator;
//import org.springframework.stereotype.Service;
//
//@Service("emailservice")
//public class EmailService {
//
//	private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
//	private static final int OTP_LENGTH = 6;
//
//	// Lưu OTP vào session
//	public boolean sendOtpEmail(String to, HttpSession session) {
//		String subject = "Your OTP";
//		String otp = generateOtp();
//		String message = "Your OTP is: " + otp;
//
//		// Save the OTP in the session
//		session.setAttribute("OTP", otp);
//
//		return sendEmail(subject, message, to);
//	}
//
//	private String generateOtp() {
//		Random random = new Random();
//		StringBuilder otp = new StringBuilder(OTP_LENGTH);
//		for (int i = 0; i < OTP_LENGTH; i++) {
//			int index = random.nextInt(CHAR_LIST.length());
//			otp.append(CHAR_LIST.charAt(index));
//		}
//		return otp.toString();
//	}
//
//	public boolean sendEmail(String subject, String message, String to) {
//		boolean check = false;
//
//		Properties properties = new Properties();
//		properties.put("mail.smtp.auth", "false");
//		properties.put("mail.transport.protocol", "smtp");
//		properties.put("mail.smtp.starttls.enable", "true");
//		properties.put("mail.smtp.host", "smtp.mailgun.org");
//		properties.put("mail.smtp.port", "587");
//		String myAccountEmail = "postmaster@sandbox02d36876b0214e65ab40c66172162a7f.mailgun.org";
//		String appPassword = "bd288843f144e35445e568b077f8607e-4b98b89f-b6b5924f";
//		Session session = Session.getInstance(properties, new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(myAccountEmail, appPassword);
//			}
//		});
//
//		session.setDebug(true);
//
//		MimeMessage m = new MimeMessage(session);
//
//		try {
//			m.setFrom(myAccountEmail);
//			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			m.setSubject(subject);
//			m.setText(message);
//
//			Transport.send(m);
//			System.out.println("Message Sent successfully");
//			check = true;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return check;
//	}
//
//	// việc lưu OTP vào session như thế này chỉ hoạt động nếu bạn đang tạo OTP và
//	// xác thực nó trong cùng một phiên hoạt động. Nếu người dùng đóng trình duyệt,
//	// hoặc nếu session hết hạn trước khi họ xác thực OTP, thì OTP sẽ bị mất.
//	public boolean verifyOtp(String userOtp, HttpSession session) {
//		String sessionOtp = (String) session.getAttribute("OTP");
//
//		// Make sure to remove the OTP from the session
//		session.removeAttribute("OTP");
//
//		return userOtp.equals(sessionOtp);
//	}
//}