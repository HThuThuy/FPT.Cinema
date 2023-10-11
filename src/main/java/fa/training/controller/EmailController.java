package fa.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.service.EmailService;

@Controller
public class EmailController {

    @Autowired
    private EmailService emailService; // You need to create this service to generate and validate OTPs
    
    @GetMapping(value = {"/sendOTP"})
    public ResponseEntity<String> sendOTP(@RequestParam String emailForgot) {
        try {
            System.out.println("emailForgot"+emailForgot); // Debug: print message when method is called
            String otp = EmailService.generateOTP();
            System.out.println("Generated OTP: " + otp); // Debug: print the generated OTP
            emailService.sendSimpleEmail(emailForgot, "Your OTP", "OTP to reset your password is: " + otp);
            System.out.println("OTP has been sent to the email: " + emailForgot); // Debug: print message after send email
            return ResponseEntity.ok("OTP has been sent to the email: " + emailForgot);
        } catch (Exception e) {
            // Log the exception...
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
    
}