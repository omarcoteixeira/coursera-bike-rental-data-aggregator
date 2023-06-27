package br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.controller;

import br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.health.MongoDBHealthIndicator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.actuate.health.Status;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
class HealthController {

  MongoDBHealthIndicator mongoDBHealthIndicator;

  @GetMapping()
  public boolean getStatus() {
    return mongoDBHealthIndicator.health().getStatus().equals(Status.UP);
  }
}
