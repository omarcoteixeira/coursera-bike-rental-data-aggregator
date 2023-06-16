package br.com.omarcoteixeira.apps.bikerental.apiserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("networks")
public class NetworksController {
  @GetMapping()
  public boolean getNetworkList() {
    return true;
  }
}
