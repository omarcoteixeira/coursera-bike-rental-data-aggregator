package br.com.omarcoteixeira.apps.bikerental.cronserver.data.mapper;

import br.com.omarcoteixeira.apps.bikerental.cronserver.data.dto.NetworkDto;
import br.com.omarcoteixeira.apps.bikerental.model.Network;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {BaseMapper.class})
public interface NetworkMapper {

  @InheritInverseConfiguration
  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "href", target = "href")
  @Mapping(source = "companies", target = "companies")
  Network to(NetworkDto networkDto);
}
