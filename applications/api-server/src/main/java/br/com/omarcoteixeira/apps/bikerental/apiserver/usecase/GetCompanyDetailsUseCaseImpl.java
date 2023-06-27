package br.com.omarcoteixeira.apps.bikerental.apiserver.usecase;

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.CompanyDto;
import br.com.omarcoteixeira.apps.bikerental.apiserver.data.mapper.CompanyMapper;
import br.com.omarcoteixeira.apps.bikerental.apiserver.repository.company.GetCompanyDetailsRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GetCompanyDetailsUseCaseImpl implements GetCompanyDetailsUseCase {

  CompanyMapper companyMapper;
  GetCompanyDetailsRepository getCompanyDetailsRepository;

  @Override
  public CompanyDto execute(String name) {
    return companyMapper.from(getCompanyDetailsRepository.execute(name));
  }
}
