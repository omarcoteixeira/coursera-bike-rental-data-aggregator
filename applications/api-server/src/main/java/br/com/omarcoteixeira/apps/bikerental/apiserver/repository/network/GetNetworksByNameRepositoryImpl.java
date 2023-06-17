package br.com.omarcoteixeira.apps.bikerental.apiserver.repository.network;

import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetNetworksByNameUseCase;
import br.com.omarcoteixeira.apps.bikerental.model.Network;
import java.util.List;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetNetworksByNameRepositoryImpl implements GetNetworksByNameRepository {

  MongoTemplate mongoTemplate;

  public GetNetworksByNameRepositoryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  public List<Network> execute(String name) {
    Query query = new Query();
    query.addCriteria(Criteria.where("name").is(name));
    return mongoTemplate.find(query, Network.class);
  }
}
