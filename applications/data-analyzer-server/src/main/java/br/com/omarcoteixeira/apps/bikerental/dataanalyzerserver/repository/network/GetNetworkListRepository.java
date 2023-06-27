package br.com.omarcoteixeira.apps.bikerental.dataanalyzerserver.repository.network;

import br.com.omarcoteixeira.apps.bikerental.model.Network;
import java.util.List;

@FunctionalInterface
public interface GetNetworkListRepository {

  List<Network> execute();
}
