package net.juniorfox.application.service.impl;

import net.juniorfox.adapter.client.BoredApi;
import net.juniorfox.application.domain.adapter.BoredApiResponse;
import net.juniorfox.application.domain.Bored;
import net.juniorfox.application.domain.mapper.BoredMapper;
import net.juniorfox.application.service.BoringService;
import org.springframework.stereotype.Service;

@Service
public class BoringServiceImpl implements BoringService {

    private final BoredApi boredApi;

    public BoringServiceImpl(BoredApi boredApi) {
        this.boredApi = boredApi;
    }

    @Override
    public Bored process() {
        BoredApiResponse response = boredApi.process().getBody();
        assert response != null;
        return BoredMapper.toBored(response);
    }
}
