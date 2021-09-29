package kg.megacom.emailsendingservice.controllers;


import kg.megacom.emailsendingservice.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController  {


    @Autowired
    EmailService emailService;

    @PostMapping("/client-email/")
    public String clientEmail(@RequestParam String email) {

      emailService.sendMail(email,"Your payment was successful");
      return "Ok";
    }

    @PostMapping("/worker-email/")
    public String workerEmail(@RequestParam String id) {

      emailService.sendPreConfiguredMail("Payment has been made by: " + id);
      return "Ok";
    }
}
//    @Autowired
//    private EmailService emailService;
//
//    @GetMapping("/send")
//    public void send (@RequestParam String to, @RequestParam String body){
//        emailService.sendMail(to, body);
//    }
//
//
//    @Override
//    public void run(String... args) throws Exception {
//
//    }
//}
