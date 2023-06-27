package br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver;

import br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.configuration.ApplicationConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ApplicationConfiguration.class})
public class DataAnalyzerServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(DataAnalyzerServerApplication.class, args);
  }
}
