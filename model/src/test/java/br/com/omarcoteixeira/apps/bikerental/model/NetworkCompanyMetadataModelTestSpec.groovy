package br.com.omarcoteixeira.apps.bikerental.model

import spock.lang.Specification

class NetworkCompanyMetadataModelTestSpec extends Specification{

    Void "A network object is being build"() {
        when: "properties are not filled"
        var data = NetworkCompanyMetadata.builder().build()

        then: "it should be created with a valid random UUID"
        !data.id.isBlank() && UUID.fromString(data.id).toString() == data.id

        and: "and number of netwotks"
        data.numberOfNetworks == 0L

        and: "and total bike are zeroed"
        data.totalBikes == 0L
    }
}
