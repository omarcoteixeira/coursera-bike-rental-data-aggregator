package br.com.omarcoteixeira.apps.bikerental.apiserver.repository.network;

import br.com.omarcoteixeira.apps.bikerental.model.Network;
import java.util.List;

@FunctionalInterface
public interface GetNetworksByNameRepository {

  List<Network> execute(String name);
}
