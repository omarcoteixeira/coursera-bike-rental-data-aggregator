package br.com.omarcoteixeira.apps.bikerental.model

import spock.lang.Specification

class KafkaMessagesModelTestSpec extends Specification {

    Void "KafkaMessages have #MESSAGE"() {
        expect:
            Objects.equals(MESSAGE.getValue(), VALUE) == EXPECTED
        where:
            MESSAGE                    | VALUE          | EXPECTED
            KafkaMessages.REFRESH_DATA | "refresh_data" | true
    }
}
