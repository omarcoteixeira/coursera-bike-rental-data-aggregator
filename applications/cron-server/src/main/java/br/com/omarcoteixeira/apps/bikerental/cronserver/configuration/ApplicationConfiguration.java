package br.com.omarcoteixeira.apps.bikerental.cronserver.configuration;

import br.com.omarcoteixeira.apps.bikerental.cronserver.configuration.properties.BikeNetworkDataIngestionProperties;
import br.com.omarcoteixeira.apps.bikerental.cronserver.configuration.properties.BikeNetworkDataIngestionSchedulerProperties;
import br.com.omarcoteixeira.apps.bikerental.cronserver.configuration.properties.DatabaseDataIngestionProperties;
import org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@Import({
  TaskSchedulingAutoConfiguration.class,
  ServletWebServerFactoryAutoConfiguration.class,
  DispatcherServletAutoConfiguration.class,
  MapperConfiguration.class,
  RepositoryConfiguration.class,
})
@EnableConfigurationProperties({
  DatabaseDataIngestionProperties.class,
  BikeNetworkDataIngestionProperties.class,
  BikeNetworkDataIngestionSchedulerProperties.class
})
@ComponentScan(
    basePackages = {
      "br.com.omarcoteixeira.apps.bikerental.cronserver.scheduler",
      "br.com.omarcoteixeira.apps.bikerental.cronserver.data.mapper"
    })
public class ApplicationConfiguration {}
