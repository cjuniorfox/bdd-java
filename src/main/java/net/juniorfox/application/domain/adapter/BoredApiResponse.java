package net.juniorfox.application.domain.adapter;

public record BoredApiResponse(
        String activity,
        String accessibility,
        String type,
        int participants,
        double price,
        String link,
        String key
) {
}
