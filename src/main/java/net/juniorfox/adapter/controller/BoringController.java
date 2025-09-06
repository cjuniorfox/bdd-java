package net.juniorfox.adapter.controller;

import net.juniorfox.application.domain.adapter.BoredResponse;
import net.juniorfox.application.domain.Bored;
import net.juniorfox.application.domain.mapper.BoredMapper;
import net.juniorfox.application.service.BoringService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoringController {

    private final BoringService boringService;

    public BoringController(BoringService boringService) {
        this.boringService = boringService;
    }

    @GetMapping("/home")
    public ResponseEntity<BoredResponse> home() {
        Bored bored = boringService.process();
        return ResponseEntity.ok(BoredMapper.toBoredResponse(bored));
    }
}
