package net.juniorfox.application.domain.mapper;

import net.juniorfox.application.domain.adapter.BoredApiResponse;
import net.juniorfox.application.domain.adapter.BoredResponse;
import net.juniorfox.application.domain.entity.Bored;

public class BoredMapper {

    private BoredMapper() { }

    public static Bored toBored(BoredApiResponse boredApiResponse) {
        return new Bored(
                boredApiResponse.activity(),
                boredApiResponse.accessibility(),
                boredApiResponse.type(),
                boredApiResponse.participants(),
                boredApiResponse.price(),
                boredApiResponse.link(),
                boredApiResponse.key()
        );
    }

    /**
     * Maps a Home entity to a HomeResponse record.
     *
     * @param bored The Home entity to map.
     * @return The corresponding HomeResponse.
     */
    public static BoredResponse toBoredResponse(Bored bored) {
        return new BoredResponse(
                bored.activity(),
                bored.accessibility(),
                bored.type(),
                bored.participants(),
                bored.price(),
                bored.link(),
                bored.key()
        );
    }
}
