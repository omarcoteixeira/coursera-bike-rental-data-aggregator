package br.com.omarcoteixeira.apps.bikerental.apiserver.configuration;

import br.com.omarcoteixeira.apps.bikerental.apiserver.configuration.properties.DatabaseDataIngestionProperties;
import br.com.omarcoteixeira.apps.bikerental.apiserver.configuration.properties.KafkaServerProperties;
import org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@EnableKafka
@Import({
  TaskSchedulingAutoConfiguration.class,
  ServletWebServerFactoryAutoConfiguration.class,
  DispatcherServletAutoConfiguration.class,
  MapperConfiguration.class,
  KafkaConfiguration.class,
  UseCaseConfiguration.class,
  RepositoryConfiguration.class
})
@EnableConfigurationProperties({KafkaServerProperties.class, DatabaseDataIngestionProperties.class})
@ComponentScan(
    basePackages = {
      "br.com.omarcoteixeira.apps.bikerental.apiserver.controller",
      "br.com.omarcoteixeira.apps.bikerental.apiserver.service",
      "br.com.omarcoteixeira.apps.bikerental.apiserver.health",
      "br.com.omarcoteixeira.apps.bikerental.apiserver.data.mapper"
    })
public class ApplicationConfiguration {
  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedOrigins("https://bike-rental-aggregator-web.herokuapp.com");
        ;
      }
    };
  }
}
