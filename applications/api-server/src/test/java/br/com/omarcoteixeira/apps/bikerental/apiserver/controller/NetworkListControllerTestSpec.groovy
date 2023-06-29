package br.com.omarcoteixeira.apps.bikerental.apiserver.controller

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.NetworkDto
import br.com.omarcoteixeira.apps.bikerental.apiserver.specification.SpringSpecification
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetNetworkListUseCase
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.RefreshNetworkListUseCase
import org.spockframework.spring.SpringBean
import spock.lang.Shared

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class NetworkListControllerTestSpec extends SpringSpecification {

    @SpringBean GetNetworkListUseCase getNetworkListUseCase = Stub()
    @SpringBean RefreshNetworkListUseCase refreshNetworkListUseCase = Stub()

    @Shared
    var expectedNetworkDto = [
            id: "grad-drnis-drni",
            name: "NextBike",
            href: "/v2/networks/grad-drnis-drnis"
    ] as NetworkDto

    def "should return HTTP OK on /networks request"() {
        given:
            getNetworkListUseCase.execute(_) >> [expectedNetworkDto]
        expect:
            def result = mockMvc.perform(
                    get("/networks?name=NextBike")
            ).andExpect {
                status().isOk()
            }.andReturn()
        and:
            var response = objectMapper.readValue(
                    result.getResponse().getContentAsString(), List<NetworkDto>
            ).first() as NetworkDto;
            with(response) {
                id == expectedNetworkDto.id
                name == expectedNetworkDto.name
                href == expectedNetworkDto.href
                companies.isEmpty()
            }
    }

    def "should return HTTP OK on /networks request and empty list in case of no items found"() {
        given:
            getNetworkListUseCase.execute(_) >> []
        expect:
            def result = mockMvc.perform(
                    get("/networks?name=Temp")
            ).andExpect {
                status().isOk()
            }.andReturn()
        and:
            var response = objectMapper.readValue(
                    result.getResponse().getContentAsString(), List<NetworkDto>
            );
            with(response) {
                it.isEmpty()
            }
    }

    def "should return HTTP OK on /networks/refresh post"() {
        given:
            refreshNetworkListUseCase.execute() >> true
        expect:
            def result = mockMvc.perform(
                    post("/networks/refresh")
            ).andExpect {
                status().isOk()
            }.andReturn()
        and:
            result.getResponse().getContentAsString() == "true"
    }
}
