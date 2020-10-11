package de.currency.exchanger.klt.rest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * RestServiceTest
 */
class RestServiceTest {

    private RestService restService = new RestService();

    @MockBean
    private ConverterServiceImpl converterService;

    @Test
    @DisplayName("runTest")
    void runTest() {
        Map<String, String> result = restService.test();
        assertThat(result).isNotEmpty();
    }
}

