package br.com.omarcoteixeira.apps.bikerental.apiserver.usecase;

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.NetworkDto;
import br.com.omarcoteixeira.apps.bikerental.apiserver.data.mapper.NetworkMapper;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.network.GetNetworkListRepository;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.network.GetNetworksByNameRepository;
import java.util.List;
import java.util.Optional;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetNetworkListUseCaseImpl implements GetNetworkListUseCase {

  GetNetworkListRepository getNetworkListRepository;
  GetNetworksByNameRepository getNetworksByNameRepository;

  NetworkMapper networkMapper;

  @Override
  public List<NetworkDto> execute(Optional<String> name) {
    return name
        .map(getNetworksByNameRepository::execute)
        .orElse(getNetworkListRepository.execute())
        .parallelStream()
        .map(networkMapper::from)
        .toList();
  }
}
