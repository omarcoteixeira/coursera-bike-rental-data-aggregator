package br.com.omarcoteixeira.apps.bikerental.apiserver.configuration;

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.mapper.CompanyMapper;
import br.com.omarcoteixeira.apps.bikerental.apiserver.data.mapper.NetworkMapper;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.company.GetCompanyDetailsRepository;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.network.GetNetworkListRepository;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.network.GetNetworksByNameRepository;
import br.com.omarcoteixeira.apps.bikerental.apiserver.service.KafkaProducer;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetCompanyDetailsUseCase;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetCompanyDetailsUseCaseImpl;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetNetworkListUseCase;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetNetworkListUseCaseImpl;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetNetworksByNameUseCase;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetNetworksByNameUseCaseImpl;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.RefreshNetworkListUseCase;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.RefreshNetworkListUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

  @Bean
  GetNetworkListUseCase getNetworkListUseCase(
      GetNetworkListRepository getNetworkListRepository,
      GetNetworksByNameRepository getNetworksByNameRepository,
      NetworkMapper networkMapper) {
    return new GetNetworkListUseCaseImpl(
        getNetworkListRepository, getNetworksByNameRepository, networkMapper);
  }

  @Bean
  RefreshNetworkListUseCase refreshNetworkListUseCase(KafkaProducer kafkaProducer) {
    return new RefreshNetworkListUseCaseImpl(kafkaProducer);
  }

  @Bean
  GetNetworksByNameUseCase getNetworksByNameUseCase(
      GetNetworksByNameRepository getNetworksByNameRepository, NetworkMapper networkMapper) {
    return new GetNetworksByNameUseCaseImpl(getNetworksByNameRepository, networkMapper);
  }

  @Bean
  GetCompanyDetailsUseCase getCompanyDetailsUseCase(
      CompanyMapper companyMapper, GetCompanyDetailsRepository getCompanyDetailsRepository) {
    return new GetCompanyDetailsUseCaseImpl(companyMapper, getCompanyDetailsRepository);
  }
}
