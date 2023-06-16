package br.com.omarcoteixeira.apps.bikerental.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Network {

  @Id
  @Builder.Default
  String id = UUID.randomUUID().toString();

  String name;
  String href;

  @ElementCollection
  @Builder.Default
  List<String> companies = new ArrayList<>();

  @ManyToOne
  Location location;
  @ManyToMany
  List<Station> stations;
}
