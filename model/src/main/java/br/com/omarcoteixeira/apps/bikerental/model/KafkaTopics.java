package br.com.omarcoteixeira.apps.bikerental.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum KafkaTopics {
  REFRESH_DATA_TOPIC("refresh_data");

  String name;
}
