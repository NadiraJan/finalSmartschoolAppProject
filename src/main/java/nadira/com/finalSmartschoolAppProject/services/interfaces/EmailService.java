package nadira.com.finalSmartschoolAppProject.services.interfaces;


import nadira.com.finalSmartschoolAppProject.entities.EmailMessage;

public interface EmailService {

    String sendEmail(EmailMessage emailMessage);
}
