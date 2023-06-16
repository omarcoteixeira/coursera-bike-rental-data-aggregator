package br.com.omarcoteixeira.apps.bikerental.apiserver.configuration;

import br.com.omarcoteixeira.apps.bikerental.apiserver.configuration.properties.DatabaseDataIngestionProperties;
import org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableScheduling
@Import({
  TaskSchedulingAutoConfiguration.class,
  ServletWebServerFactoryAutoConfiguration.class,
  DispatcherServletAutoConfiguration.class,
  MapperConfiguration.class,
  UseCaseConfiguration.class,
  RepositoryConfiguration.class,
})
@EnableConfigurationProperties({DatabaseDataIngestionProperties.class})
@ComponentScan(basePackages = {"br.com.omarcoteixeira.apps.bikerental.apiserver.controller"})
public class ApplicationConfiguration {}
