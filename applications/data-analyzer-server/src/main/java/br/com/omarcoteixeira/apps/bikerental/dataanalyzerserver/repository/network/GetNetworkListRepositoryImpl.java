package br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.repository.network;

import br.com.omarcoteixeira.apps.bikerental.model.Network;
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
public class GetNetworkListRepositoryImpl implements GetNetworkListRepository {

  MongoTemplate mongoTemplate;

  @Override
  public List<Network> execute() {
    return mongoTemplate.findAll(Network.class);
  }
}
