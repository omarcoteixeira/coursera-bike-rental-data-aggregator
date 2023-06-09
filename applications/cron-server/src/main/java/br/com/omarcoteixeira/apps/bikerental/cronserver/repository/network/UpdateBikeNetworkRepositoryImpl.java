package br.com.omarcoteixeira.apps.bikerental.cronserver.repository.network;

import br.com.omarcoteixeira.apps.bikerental.model.Network;
import java.util.List;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UpdateBikeNetworkRepositoryImpl implements UpdateBikeNetworkRepository {

  MongoTemplate mongoTemplate;

  public UpdateBikeNetworkRepositoryImpl(MongoTemplate mongoTemplate) {
    this.mongoTemplate = mongoTemplate;
  }

  public void execute(List<Network> networks) {
    log.info("Updating bike network list.");
    networks.parallelStream().forEach(mongoTemplate::save);
    log.info("Updated bike network list finished.");
  }
}
