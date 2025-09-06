package net.juniorfox.bdd.steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import net.juniorfox.adapter.client.BoredApi;
import net.juniorfox.application.domain.adapter.BoredApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpMethod.GET;

public class BoringSteps {

    @LocalServerPort
    String port;

    @Autowired
    BoredApi boredApi;

    ResponseEntity<String> lastResponse;

    HttpClientErrorException lastHttpException;

    @Quando("consultar o endpoint {string}")
    public void quando_consultar_o_endpoint_(String endpoint) {
        when(boredApi.process()).thenReturn(ResponseEntity.ok(mock(BoredApiResponse.class)));
        try {
            lastResponse = new RestTemplate().exchange(
                    "http://localhost:" + port + endpoint,
                    GET,
                    null,
                    String.class
            );
        } catch (HttpClientErrorException e) {
            lastHttpException = e;
        }

    }

    @Entao("o código de retorno será {int}")
    public void o_codigo_de_retorno_sera_(int codigo) {
        if (lastResponse != null) {
            assert lastResponse.getStatusCode().value() == codigo;
        } else if (lastHttpException != null) {
            assert lastHttpException.getStatusCode().value() == codigo;
        } else {
            assert false;
        }
    }
}
