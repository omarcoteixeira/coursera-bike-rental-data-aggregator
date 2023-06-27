package br.com.omarcoteixeira.apps.bikerental.apiserver.controller;

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.NetworkDto;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetNetworkListUseCase;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.RefreshNetworkListUseCase;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("networks")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NetworkListController {

  GetNetworkListUseCase getNetworkListUseCase;
  RefreshNetworkListUseCase refreshNetworkListUseCase;

  @GetMapping()
  public List<NetworkDto> getNetworkList(@RequestParam Optional<String> name) {
    return getNetworkListUseCase.execute(name);
  }

  @PostMapping("refresh")
  public boolean refresh() {
    return refreshNetworkListUseCase.execute();
  }
}
