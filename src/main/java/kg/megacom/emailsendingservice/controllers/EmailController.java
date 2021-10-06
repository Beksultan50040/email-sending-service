package kg.megacom.emailsendingservice.controllers;


import kg.megacom.emailsendingservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController  {

    @Autowired
    KafkaTemplate<String, String> template;

    @Autowired
    EmailService emailService;

    @PostMapping("/client-email/")
    public String clientEmail(@RequestParam String email) {

        template.send("client",email);
        return "Ok";
    }

    @PostMapping("/worker-email/")
    public String workerEmail(@RequestParam String id) {

        template.send("worker", "Принята новая оплата. Номер квитанции: " + id);
        return "Ok";
    }
}

