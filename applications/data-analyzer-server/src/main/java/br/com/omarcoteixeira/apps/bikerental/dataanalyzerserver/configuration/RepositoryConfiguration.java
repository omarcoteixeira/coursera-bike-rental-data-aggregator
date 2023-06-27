package br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.configuration;

import br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.configuration.properties.DatabaseDataAnalyzerProperties;
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
  public MongoClient mongoClient(DatabaseDataAnalyzerProperties databaseDataAnalyzerProperties) {
    MongoClientSettings mongoClientSettings =
        MongoClientSettings.builder()
            .applyConnectionString(
                new ConnectionString(databaseDataAnalyzerProperties.getConnectionString()))
            .build();

    return MongoClients.create(mongoClientSettings);
  }

  @Bean
  public MongoTemplate mongoTemplate(
      MongoClient mongoClient, DatabaseDataAnalyzerProperties databaseDataAnalyzerProperties) {
    return new MongoTemplate(mongoClient, databaseDataAnalyzerProperties.getCollectionName());
  }
}
