package br.com.omarcoteixeira.apps.bikerental.apiserver.data.mapper;

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.CompanyDto;
import br.com.omarcoteixeira.apps.bikerental.model.NetworkCompanyMetadata;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {BaseMapper.class})
public interface CompanyMapper {

  @Mapping(source = "id", target = "name")
  @Mapping(source = "numberOfNetworks", target = "numberOfNetworks")
  @Mapping(source = "totalBikes", target = "totalBikes")
  CompanyDto from(NetworkCompanyMetadata networkCompanyMetadata);
}
