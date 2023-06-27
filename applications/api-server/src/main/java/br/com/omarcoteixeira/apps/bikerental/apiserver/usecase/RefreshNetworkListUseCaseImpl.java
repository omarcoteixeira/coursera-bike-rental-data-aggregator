package br.com.omarcoteixeira.apps.bikerental.apiserver.usecase;

import br.com.omarcoteixeira.apps.bikerental.apiserver.service.KafkaProducer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RefreshNetworkListUseCaseImpl implements RefreshNetworkListUseCase {

  KafkaProducer kafkaProducer;

  @Override
  public boolean execute() {
    log.info("Requesting data refresh.");
    return kafkaProducer.sendRefreshMessage();
  }
}
