package br.com.omarcoteixeira.apps.bikerental.apiserver.repository.company;

import br.com.omarcoteixeira.apps.bikerental.model.NetworkCompanyMetadata;
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
public class GetCompanyDetailsRepositoryImpl implements GetCompanyDetailsRepository {

  MongoTemplate mongoTemplate;

  @Override
  public NetworkCompanyMetadata execute(String name) {
    return mongoTemplate.findById(name, NetworkCompanyMetadata.class);
  }
}
