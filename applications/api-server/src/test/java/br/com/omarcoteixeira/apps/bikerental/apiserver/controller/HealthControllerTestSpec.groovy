package br.com.omarcoteixeira.apps.bikerental.apiserver.controller

import br.com.omarcoteixeira.apps.bikerental.apiserver.specification.SpringSpecification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class HealthControllerTestSpec extends SpringSpecification {

    def "should return HTTP OK on /health request"() {
        expect:
        def result = mockMvc.perform(
                get("/health")
        ).andExpect {
            status().isOk()
        }.andReturn()
        and:
        result.getResponse().getContentAsString() == "true"
    }

}
