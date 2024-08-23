import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(
            ConsumerFactory<String, String> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactoryForValue1(
            ConsumerFactory<String, String> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setRecordFilterStrategy(new RecordFilterStrategy<String, String>() {
            @Override
            public boolean filter(ConsumerRecord<String, String> consumerRecord) {
                String headerValue = new String(consumerRecord.headers().lastHeader("headerKey").value());
                return !"value1".equals(headerValue); // Filter out if header value is not "value1"
            }
        });
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactoryForValue2(
            ConsumerFactory<String, String> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setRecordFilterStrategy(new RecordFilterStrategy<String, String>() {
            @Override
            public boolean filter(ConsumerRecord<String, String> consumerRecord) {
                String headerValue = new String(consumerRecord.headers().lastHeader("headerKey").value());
                return !"value2".equals(headerValue); // Filter out if header value is not "value2"
            }
        });
        return factory;
    }

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
