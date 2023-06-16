package br.com.omarcoteixeira.apps.bikerental.cronserver.repository.network;

import br.com.omarcoteixeira.apps.bikerental.model.Network;
import java.util.List;

@FunctionalInterface
public interface UpdateBikeNetworkRepository {

  void execute(List<Network> networkListDto);
}
