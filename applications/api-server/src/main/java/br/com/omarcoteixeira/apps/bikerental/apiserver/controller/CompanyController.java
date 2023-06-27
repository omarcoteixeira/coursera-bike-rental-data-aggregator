package br.com.omarcoteixeira.apps.bikerental.apiserver.controller;

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.CompanyDto;
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetCompanyDetailsUseCase;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("company")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CompanyController {

  GetCompanyDetailsUseCase getCompanyDetailsUseCase;

  @GetMapping()
  public CompanyDto getCompanyDetails(@RequestParam String name) {
    return getCompanyDetailsUseCase.execute(name);
  }
}
