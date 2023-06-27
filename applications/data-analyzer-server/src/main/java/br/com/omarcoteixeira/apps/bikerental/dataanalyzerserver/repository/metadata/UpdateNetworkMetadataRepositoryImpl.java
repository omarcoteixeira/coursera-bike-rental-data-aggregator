package br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.repository.metadata;

import br.com.omarcoteixeira.apps.bikerental.model.NetworkCompanyMetadata;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateNetworkMetadataRepositoryImpl implements UpdateNetworkMetadataRepository {

  MongoTemplate mongoTemplate;

  @Override
  public void execute(List<NetworkCompanyMetadata> companyMetadataList) {
    log.info("Updating companies metadata");
    companyMetadataList.parallelStream().forEach(mongoTemplate::save);
    log.info("Update companies metadata finished");
  }
}
