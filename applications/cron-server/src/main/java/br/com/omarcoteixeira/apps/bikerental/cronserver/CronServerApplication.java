package br.com.omarcoteixeira.apps.bikerental.cronserver;

import br.com.omarcoteixeira.apps.bikerental.cronserver.configuration.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ApplicationConfiguration.class})
public class CronServerApplication {
  public static void main(String[] args) {
    SpringApplication.run(CronServerApplication.class, args);
  }
}
