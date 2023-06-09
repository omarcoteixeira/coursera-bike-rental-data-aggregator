package br.com.omarcoteixeira.apps.bikerental.apiserver.configuration;

import br.com.omarcoteixeira.apps.bikerental.apiserver.configuration.properties.DatabaseDataIngestionProperties;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.company.GetCompanyDetailsRepository;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.company.GetCompanyDetailsRepositoryImpl;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.network.GetNetworkListRepository;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.network.GetNetworkListRepositoryImpl;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.network.GetNetworksByNameRepository;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.network.GetNetworksByNameRepositoryImpl;
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
  GetNetworkListRepository getNetworkListRepository(MongoTemplate mongoTemplate) {
    return new GetNetworkListRepositoryImpl(mongoTemplate);
  }

  @Bean
  GetNetworksByNameRepository getNetworksByNameRepository(MongoTemplate mongoTemplate) {
    return new GetNetworksByNameRepositoryImpl(mongoTemplate);
  }

  @Bean
  GetCompanyDetailsRepository getCompanyDetailsRepository(MongoTemplate mongoTemplate) {
    return new GetCompanyDetailsRepositoryImpl(mongoTemplate);
  }
}
