import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "your-topic-name", groupId = "group1", containerFactory = "kafkaListenerContainerFactoryForValue1")
    public void listener1(String message) {
        // Process messages with headerKey == "value1"
        System.out.println("Listener 1 received: " + message);
    }

    @KafkaListener(topics = "your-topic-name", groupId = "group2", containerFactory = "kafkaListenerContainerFactoryForValue2")
    public void listener2(String message) {
        // Process messages with headerKey == "value2"
        System.out.println("Listener 2 received: " + message);
    }
}
