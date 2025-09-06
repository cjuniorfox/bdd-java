package net.juniorfox.adapter.client.impl;

import net.juniorfox.adapter.client.BoredApi;
import net.juniorfox.application.domain.adapter.BoredApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.GET;


@Component
public class BoredApiImpl implements BoredApi {

    private static final String BORED_API_URL = "https://bored-api.appbrewery.com/random";

    @Override
    public ResponseEntity<BoredApiResponse> process(){
        return new RestTemplate().exchange(BORED_API_URL, GET,null,BoredApiResponse.class);
    }

}
