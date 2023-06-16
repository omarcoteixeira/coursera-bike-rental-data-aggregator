package br.com.omarcoteixeira.apps.bikerental.apiserver.configuration;

import br.com.omarcoteixeira.apps.bikerental.apiserver.configuration.properties.DatabaseDataIngestionProperties;
import br.com.omarcoteixeira.apps.bikerental.apiserver.configuration.properties.KafkaServerProperties;
import org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

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
  RepositoryConfiguration.class,
})
@EnableConfigurationProperties({KafkaServerProperties.class, DatabaseDataIngestionProperties.class})
@ComponentScan(basePackages = {"br.com.omarcoteixeira.apps.bikerental.apiserver.controller"})
public class ApplicationConfiguration {}
