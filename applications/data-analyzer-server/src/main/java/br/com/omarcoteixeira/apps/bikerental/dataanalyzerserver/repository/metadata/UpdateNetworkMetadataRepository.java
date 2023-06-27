package br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.repository.metadata;

import br.com.omarcoteixeira.apps.bikerental.model.NetworkCompanyMetadata;
import java.util.List;

@FunctionalInterface
public interface UpdateNetworkMetadataRepository {

  void execute(List<NetworkCompanyMetadata> companyMetadataList);
}
