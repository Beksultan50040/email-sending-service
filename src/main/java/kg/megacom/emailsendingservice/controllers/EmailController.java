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

    @PostMapping("/simple-email/")
    public String sendSimpleEmail(@RequestParam String email) {

      emailService.sendMail(email,"Welcome");
      return "Ok";
    }

    @PostMapping("/simple-email")
    public String sendEmail() {

      emailService.sendPreConfiguredMail("Hi");
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
