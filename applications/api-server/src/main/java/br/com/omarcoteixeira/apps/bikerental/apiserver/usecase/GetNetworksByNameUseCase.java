package br.com.omarcoteixeira.apps.bikerental.apiserver.usecase;

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.NetworkDto;
import java.util.List;

@FunctionalInterface
public interface GetNetworksByNameUseCase {

  List<NetworkDto> execute(String name);
}
