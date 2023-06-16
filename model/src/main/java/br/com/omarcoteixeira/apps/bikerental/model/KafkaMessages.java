package br.com.omarcoteixeira.apps.bikerental.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum KafkaMessages {
  REFRESH_DATA("refresh_data");
  String value;
}
