package net.juniorfox.bdd.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import net.juniorfox.application.domain.adapter.UserRequest;
import net.juniorfox.application.domain.adapter.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;

public class UserSteps {

    @LocalServerPort
    String port;

    @Autowired
    ObjectMapper objectMapper;

    ResponseEntity<String> lastResponse;

    HttpClientErrorException lastHttpException;

    @Quando("inserir um usuário com nome {string} e email {string} no endpoint {string}")
    public void quando_inserir_um_usuario_com_nome_e_email_no_endpoint(String nome, String email, String endpoint){

        var entity = new UserRequest(nome,email);

        try {
            lastResponse = new RestTemplate().postForEntity(
                    "http://localhost:" + port + endpoint,
                    entity,
                    String.class
            );
        } catch (HttpClientErrorException e) {
            lastHttpException = e;
        }
    }

    @Então("o código de retorno para usuário será {int}")
    public void o_codigo_de_retorno_para_usuario_sera_(int expected){
        if (lastResponse != null) {
            assert lastResponse.getStatusCode().value() == expected;
        } else if (lastHttpException != null) {
            assert lastHttpException.getStatusCode().value() == expected;
        } else {
            assert false;
        }
    }

    @E("ao consultar o usuário no endpoint {string}")
    public void e_ao_consultar_o_usuario_no_endpoint_(String endpoint){
        try {

            var response = objectMapper.readValue(lastResponse.getBody(), UserResponse.class);

            lastResponse = new RestTemplate().exchange(
                    "http://localhost:" + port + endpoint + "/" + response.id(),
                    GET,
                    null,
                    String.class
            );
        } catch (HttpClientErrorException e) {
            lastHttpException = e;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
