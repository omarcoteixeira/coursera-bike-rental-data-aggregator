package br.com.omarcoteixeira.apps.bikerental.cronserver.scheduler;

import br.com.omarcoteixeira.apps.bikerental.cronserver.service.BikeNetworkDataIngestionService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BikeNetworkDataIngestionScheduler {

  BikeNetworkDataIngestionService bikeNetworkDataIngestionService;

  public BikeNetworkDataIngestionScheduler(
      BikeNetworkDataIngestionService bikeNetworkDataIngestionService) {
    this.bikeNetworkDataIngestionService = bikeNetworkDataIngestionService;
  }

  @Scheduled(cron = "${data.ingestion.network.scheduler.cron}")
  public void run() {
    bikeNetworkDataIngestionService.process();
  }
}
