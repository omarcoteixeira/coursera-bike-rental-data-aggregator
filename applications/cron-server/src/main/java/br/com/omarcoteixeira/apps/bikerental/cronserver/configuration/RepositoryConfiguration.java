package br.com.omarcoteixeira.apps.bikerental.cronserver.configuration;

import br.com.omarcoteixeira.apps.bikerental.cronserver.configuration.properties.DatabaseDataIngestionProperties;
import br.com.omarcoteixeira.apps.bikerental.cronserver.repository.network.UpdateBikeNetworkRepository;
import br.com.omarcoteixeira.apps.bikerental.cronserver.repository.network.UpdateBikeNetworkRepositoryImpl;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class RepositoryConfiguration {

  @Bean
  public MongoClient mongoClient(DatabaseDataIngestionProperties databaseDataIngestionProperties) {
    MongoClientSettings mongoClientSettings =
        MongoClientSettings.builder()
            .applyConnectionString(
                new ConnectionString(databaseDataIngestionProperties.getConnectionString()))
            .build();

    return MongoClients.create(mongoClientSettings);
  }

  @Bean
  public MongoTemplate mongoTemplate(
      MongoClient mongoClient, DatabaseDataIngestionProperties databaseDataIngestionProperties) {
    return new MongoTemplate(mongoClient, databaseDataIngestionProperties.getCollectionName());
  }

  @Bean
  UpdateBikeNetworkRepository getUpdateBikeNetworkRepository(MongoTemplate mongoTemplate) {
    return new UpdateBikeNetworkRepositoryImpl(mongoTemplate);
  }
}
