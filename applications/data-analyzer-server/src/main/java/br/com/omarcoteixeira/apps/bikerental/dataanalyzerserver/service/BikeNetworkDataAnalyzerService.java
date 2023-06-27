package br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.service;

import br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.repository.metadata.UpdateNetworkMetadataRepository;
import br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.repository.network.GetNetworkListRepository;
import br.com.omarcoteixeira.apps.bikerental.model.Network;
import br.com.omarcoteixeira.apps.bikerental.model.NetworkCompanyMetadata;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BikeNetworkDataAnalyzerService {

  GetNetworkListRepository getNetworkListRepository;
  UpdateNetworkMetadataRepository updateNetworkMetadataRepository;

  public void process() {
    log.info("Starting data analyzer...");
    var networks = getNetworkListRepository.execute();
    var data =
        networks.stream()
            .map(Network::getCompanies)
            .flatMap(List::stream)
            .collect(Collectors.toCollection(HashSet::new))
            .stream()
            .map(company -> mapNetworkCompanyMetadata(company, networks))
            .toList();
    updateNetworkMetadataRepository.execute(data);
    log.info("Data analyzer finished and metadata saved successfully...");
  }

  private NetworkCompanyMetadata mapNetworkCompanyMetadata(String company, List<Network> networks) {
    var companyNetworks =
        networks.stream().filter(network -> network.getCompanies().contains(company)).count();
    log.debug("Company {} contains {} networks", company, companyNetworks);
    return NetworkCompanyMetadata.builder()
        .id(company)
        .numberOfNetworks(companyNetworks)
        .totalBikes(0L)
        .build();
  }
}
