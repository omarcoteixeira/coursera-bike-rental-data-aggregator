package br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.scheduler.scheduler;

import br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.service.BikeNetworkDataAnalyzerService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BikeNetworkDataAnalyzerScheduler {

  BikeNetworkDataAnalyzerService bikeNetworkDataAnalyzerService;

  @Scheduled(cron = "${data.analyzer.network.scheduler.cron}")
  public void run() {
    bikeNetworkDataAnalyzerService.process();
  }
}
