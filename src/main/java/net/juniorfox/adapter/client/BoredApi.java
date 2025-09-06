package net.juniorfox.adapter.client;


import net.juniorfox.application.domain.adapter.BoredApiResponse;
import org.springframework.http.ResponseEntity;


public interface BoredApi {
    ResponseEntity<BoredApiResponse> process();
}
