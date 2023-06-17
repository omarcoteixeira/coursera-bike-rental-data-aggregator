package br.com.omarcoteixeira.apps.bikerental.apiserver.controller;

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.NetworkDto;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetNetworkListUseCase;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetNetworksByNameUseCase;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.RefreshNetworkListUseCase;
import java.util.List;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("networks")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class NetworksController {

  GetNetworkListUseCase getNetworkListUseCase;
  GetNetworksByNameUseCase getNetworksByNameUseCase;
  RefreshNetworkListUseCase refreshNetworkListUseCase;

  public NetworksController(
      GetNetworkListUseCase getNetworkListUseCase,
      GetNetworksByNameUseCase getNetworksByNameUseCase, RefreshNetworkListUseCase refreshNetworkListUseCase) {
    this.getNetworkListUseCase = getNetworkListUseCase;
    this.getNetworksByNameUseCase = getNetworksByNameUseCase;
    this.refreshNetworkListUseCase = refreshNetworkListUseCase;
  }

  @GetMapping()
  public List<NetworkDto> getNetworkList() {
    return getNetworkListUseCase.execute();
  }

  @GetMapping("find")
  public List<NetworkDto> findNetworks(@RequestParam String name) {
    return getNetworksByNameUseCase.execute(name);
  }

  @PostMapping("refresh")
  public boolean refresh() {
    return refreshNetworkListUseCase.execute();
  }
}
