package br.com.omarcoteixeira.apps.bikerental.apiserver.usecase;

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.NetworkDto;
import br.com.omarcoteixeira.apps.bikerental.apiserver.data.mapper.NetworkMapper;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.network.GetNetworksByNameRepository;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetNetworksByNameUseCaseImpl implements GetNetworksByNameUseCase {

  GetNetworksByNameRepository getNetworksByNameRepository;
  NetworkMapper networkMapper;

  @Override
  public List<NetworkDto> execute(String name) {
    return getNetworksByNameRepository.execute(name).parallelStream()
        .map(networkMapper::from)
        .toList();
  }
}
