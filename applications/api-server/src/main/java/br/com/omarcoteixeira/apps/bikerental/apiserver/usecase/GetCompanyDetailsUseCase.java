package br.com.omarcoteixeira.apps.bikerental.apiserver.usecase;

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.CompanyDto;

@FunctionalInterface
public interface GetCompanyDetailsUseCase {

  CompanyDto execute(String name);
}
