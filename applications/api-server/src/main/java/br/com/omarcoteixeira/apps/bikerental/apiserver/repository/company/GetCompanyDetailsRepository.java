package br.com.omarcoteixeira.apps.bikerental.apiserver.repository.company;

import br.com.omarcoteixeira.apps.bikerental.model.NetworkCompanyMetadata;

@FunctionalInterface
public interface GetCompanyDetailsRepository {

  NetworkCompanyMetadata execute(String name);
}
