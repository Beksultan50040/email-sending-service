package kg.megacom.emailsendingservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService
{
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SimpleMailMessage preConfiguredMessage;

    /**
     * This method will send compose and send the message
     * */

    @KafkaListener(id="client", topics = "client")
    public void sendMail(String to, String body)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setText("Ваш платеж успешно принят");
        message.setSubject("Квитанция");
        mailSender.send(message);
    }

    /**
     * This method will send a pre-configured message
     * */
    @KafkaListener(id="worker", topics = "worker")
    public void sendPreConfiguredMail(String message)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage(preConfiguredMessage);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}