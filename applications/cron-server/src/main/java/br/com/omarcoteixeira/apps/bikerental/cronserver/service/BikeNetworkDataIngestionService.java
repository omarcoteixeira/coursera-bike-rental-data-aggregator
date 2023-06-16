package br.com.omarcoteixeira.apps.bikerental.cronserver.service;

import br.com.omarcoteixeira.apps.bikerental.cronserver.configuration.properties.BikeNetworkDataIngestionProperties;
import br.com.omarcoteixeira.apps.bikerental.cronserver.data.dto.NetworkListDto;
import br.com.omarcoteixeira.apps.bikerental.cronserver.data.mapper.NetworkMapper;
import br.com.omarcoteixeira.apps.bikerental.cronserver.repository.network.UpdateBikeNetworkRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BikeNetworkDataIngestionService {

  NetworkMapper networkMapper;
  ObjectMapper objectMapper;
  UpdateBikeNetworkRepositoryImpl updateBikeNetworkRepository;
  BikeNetworkDataIngestionProperties bikeNetworkDataIngestionProperties;

  public BikeNetworkDataIngestionService(
      NetworkMapper networkMapper,
      ObjectMapper objectMapper,
      UpdateBikeNetworkRepositoryImpl updateBikeNetworkRepository,
      BikeNetworkDataIngestionProperties bikeNetworkDataIngestionProperties) {
    this.networkMapper = networkMapper;
    this.objectMapper = objectMapper;
    this.updateBikeNetworkRepository = updateBikeNetworkRepository;
    this.bikeNetworkDataIngestionProperties = bikeNetworkDataIngestionProperties;
  }

  public void process() {
    var data = this.read().getNetworks().stream().map(item -> networkMapper.to(item)).toList();
    updateBikeNetworkRepository.execute(data);
  }

  @SneakyThrows
  private NetworkListDto read() {
    log.info("Reading data from the webserver");
    String data =
        new RestTemplate().getForObject(bikeNetworkDataIngestionProperties.getUrl(), String.class);
    // TODO: Improve it later to use mapstruct
    var networks = new ObjectMapper().readValue(data, NetworkListDto.class);
    log.info("Networks Found: {}", networks.getNetworks().size());
    log.info("Reading data from the webserver done.");
    return networks;
  }
}
