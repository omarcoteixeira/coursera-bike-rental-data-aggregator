package br.com.omarcoteixeira.apps.bikerental.model

import spock.lang.Specification

class KafkaTopicsModelTestSpec extends Specification {

    Void "KafkaTopics have #TOPIC"() {
        expect:
            Objects.equals(TOPIC.getName(), VALUE) == EXPECTED
        where:
            TOPIC                          | VALUE          | EXPECTED
            KafkaTopics.REFRESH_DATA_TOPIC | "refresh_data" | true
    }
}
