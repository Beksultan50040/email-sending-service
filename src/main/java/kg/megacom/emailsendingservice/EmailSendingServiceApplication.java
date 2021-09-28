package kg.megacom.emailsendingservice;


import javafx.application.Application;
import kg.megacom.emailsendingservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class EmailSendingServiceApplication     {




    public static void main(String[] args) {
        SpringApplication.run(EmailSendingServiceApplication.class, args);
    }


//    @Override
//    public void run(String... args) throws Exception {
//
//        emailService.sendMail("beksultan.melisov@gmail.com", "Hi");
//
//    }
}
