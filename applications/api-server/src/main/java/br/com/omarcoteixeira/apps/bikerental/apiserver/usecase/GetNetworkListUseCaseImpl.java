package br.com.omarcoteixeira.apps.bikerental.apiserver.usecase;

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.NetworkDto;
import br.com.omarcoteixeira.apps.bikerental.apiserver.data.mapper.NetworkMapper;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.network.GetNetworkListRepository;
import java.util.List;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetNetworkListUseCaseImpl implements GetNetworkListUseCase {

  GetNetworkListRepository getNetworkListRepository;
  NetworkMapper networkMapper;

  public GetNetworkListUseCaseImpl(
      GetNetworkListRepository getNetworkListRepository, NetworkMapper networkMapper) {
    this.getNetworkListRepository = getNetworkListRepository;
    this.networkMapper = networkMapper;
  }

  @Override
  public List<NetworkDto> execute() {
    return getNetworkListRepository.execute().parallelStream().map(networkMapper::from).toList();
  }
}
