package br.com.omarcoteixeira.apps.bikerental.cronserver.service;

import br.com.omarcoteixeira.apps.bikerental.model.KafkaMessages;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BikeNetworkDataRefreshConsumerService {
  BikeNetworkDataIngestionService bikeNetworkDataIngestionService;

  public BikeNetworkDataRefreshConsumerService(
      BikeNetworkDataIngestionService bikeNetworkDataIngestionService) {
    this.bikeNetworkDataIngestionService = bikeNetworkDataIngestionService;
  }

  @KafkaListener(
      topics = "refresh_data",
      containerFactory = "refreshDataKafkaListenerContainerFactory")
  public void execute(String message) {
    log.info("New message received: {}", message);
    if (KafkaMessages.REFRESH_DATA.getValue().equals(message)) {
      bikeNetworkDataIngestionService.process();
    }
  }
}
