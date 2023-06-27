package br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyDto {

  String name;
  long numberOfNetworks;
  long totalBikes;
}
