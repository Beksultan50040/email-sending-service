package kg.megacom.emailsendingservice.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@EnableKafka
@Configuration
public class kafkaConfig {

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("client")
                .partitions(10)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topic2() {
        return TopicBuilder.name("worker")
                .partitions(10)
                .replicas(1)
                .build();
    }
}
