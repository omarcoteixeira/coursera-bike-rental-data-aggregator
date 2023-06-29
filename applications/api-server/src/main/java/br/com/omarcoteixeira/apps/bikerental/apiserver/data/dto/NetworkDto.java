package br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NetworkDto {

  String id;
  String name;
  String href;

  @Builder.Default List<String> companies = new ArrayList<>();
}
