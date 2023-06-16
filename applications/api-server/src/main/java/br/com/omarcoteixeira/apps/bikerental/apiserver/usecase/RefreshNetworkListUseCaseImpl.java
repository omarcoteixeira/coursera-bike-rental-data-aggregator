package br.com.omarcoteixeira.apps.bikerental.apiserver.usecase;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RefreshNetworkListUseCaseImpl implements RefreshNetworkListUseCase {

  @Override
  public boolean execute() {
    return true;
  }
}
