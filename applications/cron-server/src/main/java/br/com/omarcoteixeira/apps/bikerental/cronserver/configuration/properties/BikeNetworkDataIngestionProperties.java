package br.com.omarcoteixeira.apps.bikerental.cronserver.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "data.ingestion.network")
public class BikeNetworkDataIngestionProperties {

  String url;
  String[] fields;
  BikeNetworkDataIngestionSchedulerProperties scheduler;
}
