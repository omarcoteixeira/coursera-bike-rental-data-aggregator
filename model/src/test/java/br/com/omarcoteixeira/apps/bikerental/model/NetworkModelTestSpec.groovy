package br.com.omarcoteixeira.apps.bikerental.model

import spock.lang.Specification

class NetworkModelTestSpec extends Specification{

    Void "A network object is being build"() {
        when: "properties are not filled"
        var data = Network.builder().build()

        then: "it should be created with a valid random UUID"
        !data.id.isBlank() && UUID.fromString(data.id).toString() == data.id

        and: "and null name"
        data.name == null

        and: "and a empty list of companies"
        data.companies.isEmpty()
    }
}
