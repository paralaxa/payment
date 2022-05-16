package sk.stopangin.payment;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import sk.stopangin.payment.common.EventSerde;
import sk.stopangin.payment.event.Event;

@SpringBootApplication
public class SagacamelpaymentApplication {

  public static void main(String[] args) {
    SpringApplication.run(SagacamelpaymentApplication.class, args);
  }


  @Bean
  public ProducerFactory<String, Event> producerFactory() {
    final Map<String, Object> config = new HashMap<>();
    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, EventSerde.class);
    config.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);
    config.put(ProducerConfig.RETRIES_CONFIG, Integer.MAX_VALUE);
    config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
    config.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "payment-service");
    final DefaultKafkaProducerFactory<String, Event> factory =
        new DefaultKafkaProducerFactory<>(config);
    factory.setTransactionIdPrefix("payment-service");
    return factory;
  }

  @Bean
  public KafkaTemplate<String, Event> kafkaTemplate(
      @Autowired ProducerFactory<String, Event> factory) {
    return new KafkaTemplate<>(factory);
  }

}
