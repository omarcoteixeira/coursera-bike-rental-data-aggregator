package br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.configuration.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "data.analyzer.database")
public class DatabaseDataAnalyzerProperties {
  String collectionName;
  String connectionString;
}
