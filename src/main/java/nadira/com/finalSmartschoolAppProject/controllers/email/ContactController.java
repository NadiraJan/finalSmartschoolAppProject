package nadira.com.finalSmartschoolAppProject.controllers.email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;


@Controller
public class ContactController {
 /*   @Autowired
    private JavaMailSender mailSender;*/


    @GetMapping("/contact")
    public String showContactForm() {
        return "contact_form";
    }

   /* @PostMapping("/contact")
    public String submitContact(HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String content = request.getParameter("content");

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);


        String mailSubject = fullname + " has a sent a message";
        String mailContent = "<p><b>Sender Name:</b> " + fullname + "</p>";
        mailContent += "<p><b>Sender E-mail:</b> " + email + "</p>";
        mailContent += "<p><b>Subject:</b> " + subject + "</p>";
        mailContent += "<p><b>Content: </b>" + content + "</p>";

        helper.setFrom("lizztrass@gmail.com","Contact");
        helper.setTo("nadirajanbaeva@gmail.com");
        helper.setSubject(mailSubject);
        helper.setText(mailContent,true);

       mailSender.send(message);

        return "message";
    }*/
}