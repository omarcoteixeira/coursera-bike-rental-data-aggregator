package br.com.omarcoteixeira.apps.bikerental.cronserver.data.dto;

import br.com.omarcoteixeira.apps.bikerental.cronserver.data.mixin.BikeNetworkDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonDeserialize(using = BikeNetworkDeserializer.class)
public class NetworkDto {

  String id;
  String name;
  String href;

  @Builder.Default List<String> companies = new ArrayList<>();
}
