package br.com.omarcoteixeira.apps.bikerental.apiserver.controller

import br.com.omarcoteixeira.apps.bikerental.apiserver.data.dto.CompanyDto
import br.com.omarcoteixeira.apps.bikerental.apiserver.specification.SpringSpecification
import br.com.omarcoteixeira.apps.bikerental.apiserver.usecase.GetCompanyDetailsUseCase
import org.spockframework.spring.SpringBean
import spock.lang.Shared

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class CompanyControllerTestSpec extends SpringSpecification {

    @SpringBean GetCompanyDetailsUseCase getCompanyDetailsUseCase = Stub()

    @Shared
    CompanyDto expectedCompanyDto = [
            name: "NextBike",
            numberOfNetworks: 10L,
            totalBikes: 20L
    ] as CompanyDto

    def "should return HTTP OK on /company request"() {
        given:
            getCompanyDetailsUseCase.execute(_) >> expectedCompanyDto
        expect:
            def result = mockMvc.perform(
                    get("/company?name=NextBike")
            ).andExpect {
                status().isOk()
            }.andReturn()
        and:
            var response = objectMapper.readValue(
                    result.getResponse().getContentAsString(), CompanyDto);
            with(response) {
                name == expectedCompanyDto.name
                numberOfNetworks == expectedCompanyDto.numberOfNetworks
                totalBikes == expectedCompanyDto.totalBikes
            }
    }

}
