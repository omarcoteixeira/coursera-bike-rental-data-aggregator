package br.com.omarcoteixeira.apps.bikerental.apiserver.configuration;

import br.com.omarcoteixeira.apps.bikerental.apiserver.health.MongoDBHealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HealthIndicatorConfiguration {

  @Bean
  MongoDBHealthIndicator mongoDBHealthIndicator() {
    return new MongoDBHealthIndicator();
  }
}
