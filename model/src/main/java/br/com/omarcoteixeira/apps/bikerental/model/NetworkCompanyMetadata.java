package br.com.omarcoteixeira.apps.bikerental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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
public class NetworkCompanyMetadata {

  @Id @Builder.Default String id = UUID.randomUUID().toString();
  @Builder.Default Long numberOfNetworks = 0L;
  @Builder.Default Long totalBikes = 0L;

  LocalDateTime createdOn;
  LocalDateTime updatedOn;

  @PrePersist
  public void prePersist() {
    this.createdOn = this.updatedOn = LocalDateTime.now(ZoneOffset.UTC);
  }

  @PreUpdate
  public void preUpdate() {
    this.updatedOn = LocalDateTime.now(ZoneOffset.UTC);
  }
}
