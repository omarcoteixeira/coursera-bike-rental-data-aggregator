package br.com.omarcoteixeira.apps.bikerental.apiserver.data.mapper;

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.NetworkDto;
import br.com.omarcoteixeira.apps.bikerental.model.Network;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.IGNORE,
    uses = {BaseMapper.class})
public interface NetworkMapper {

  @Mapping(source = "id", target = "id")
  @Mapping(source = "name", target = "name")
  @Mapping(source = "href", target = "href")
  @Mapping(source = "companies", target = "companies")
  NetworkDto from(Network network);
}
