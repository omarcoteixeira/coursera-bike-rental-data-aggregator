package br.com.omarcoteixeira.apps.bikerental.apiserver.service;

import br.com.omarcoteixeira.apps.bikerental.model.KafkaMessages;
import br.com.omarcoteixeira.apps.bikerental.model.KafkaTopics;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class KafkaProducer {

  KafkaTemplate<String, String> kafkaTemplate;

  public boolean sendRefreshMessage() {
    kafkaTemplate.send(
        KafkaTopics.REFRESH_DATA_TOPIC.getName(), KafkaMessages.REFRESH_DATA.getValue());
    return true;
  }
}
