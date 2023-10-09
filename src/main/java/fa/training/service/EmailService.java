/**
 * CustomerController
 *
 * Version 1.0
 *
 * Date: 09-10-2023
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE                 AUTHOR            DESCRIPTION
 * -----------------------------------------------------------------------
 * 09-10-2023           TraNLC            Chức năng gởi OTP về email (đang hoàn thiện)
 */

package fa.training.service;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.mail.MailSendException;
import org.springframework.stereotype.Service;

import jakarta.mail.Address;
import jakarta.mail.SendFailedException;

@Service
public class EmailService {

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    private static final int OTP_LENGTH = 6;

    /**
     * Gửi mã OTP qua email.
     * @param to Địa chỉ email cần gửi.
     * @param session Phiên làm việc hiện tại.
     * @return true nếu email được gửi thành công, false nếu không.
     */
    public boolean sendOtpEmail(String to, HttpSession session) {
        String subject = "Your OTP";
        String otp = generateOtp();
        String message = "Your OTP is: " + otp;
        // Save the OTP in the session
        session.setAttribute("OTP", otp);
        try {
            return sendEmail(subject, message, to);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Tạo ra mã OTP ngẫu nhiên.
     * @return Mã OTP.
     */
    private String generateOtp() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder(OTP_LENGTH);
        for (int i = 0; i < OTP_LENGTH; i++) {
            int index = random.nextInt(CHAR_LIST.length());
            otp.append(CHAR_LIST.charAt(index));
        }
        return otp.toString();
    }

    /**
     * Gửi email.
     * @param subject Tiêu đề email.
     * @param message Nội dung email.
     * @param to Địa chỉ email cần gửi.
     * @return true nếu email được gửi thành công, false nếu không.
     * @throws MessagingException Nếu có lỗi trong quá trình gửi email.
     */
    public boolean sendEmail(String subject, String message, String to) throws MessagingException {
        boolean f = false;
        String from = "fptcinema@gmail.com";
        String host = "smtp.gmail.com";
        // get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES " + properties);
        // setting important information to properties object
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("fptcinema@gmail.com", "diuwgnqlxnmhqnnt");
            }
        });
        session.setDebug(true);
        MimeMessage m = new MimeMessage(session);
        try {
            m.setFrom(from);
            m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            m.setSubject(subject);
            m.setText(message);
            Transport.send(m);
            System.out.println("Sent success...................");
            f = true;
        } catch (MailSendException me){
            detectInvalidAddress(me);
        }
        return f;
    }

    /**
     * Kiểm tra địa chỉ email không hợp lệ khi gửi thất bại.
     * @param me Đối tượng MailSendException.
     */
    private void detectInvalidAddress(MailSendException me) {
        Exception[] messageExceptions = me.getMessageExceptions();
        if (messageExceptions.length > 0) {
            Exception messageException = messageExceptions[0];
            if (messageException instanceof SendFailedException) {
                SendFailedException sfe = (SendFailedException) messageException;
                Address[] invalidAddresses = sfe.getInvalidAddresses();
                StringBuilder addressStr = new StringBuilder();
                for (Address address : invalidAddresses) {
                    addressStr.append(address.toString()).append("; ");
                }
System.err.printf("invalid address(es)：{}", addressStr);
                return;
            }
        }
        System.err.printf("exception while sending mail.", me);
    }

    /**
     * Xác minh mã OTP người dùng nhập có khớp với mã OTP trong phiên làm việc hay không.
     * @param userOtp Mã OTP người dùng nhập.
     * @param session Phiên làm việc hiện tại.
     * @return true nếu mã OTP người dùng nhập khớp, false nếu không.
     */
    public boolean verifyOtp(String userOtp, HttpSession session) {
        String sessionOtp = (String) session.getAttribute("OTP");
        session.removeAttribute("OTP");
        return userOtp.equals(sessionOtp);
    }
}