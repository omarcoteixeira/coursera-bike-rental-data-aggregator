package br.com.omarcoteixeira.apps.bikerental.apiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class ApiServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ApiServerApplication.class, args);
  }
}
