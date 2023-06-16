package br.com.omarcoteixeira.apps.bikerental.apiserver.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "data.ingestion.database")
public class DatabaseDataIngestionProperties {
  String collectionName;
  String connectionString;
}
