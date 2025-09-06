package net.juniorfox.application.domain;

public record Bored(
        String activity,
        String accessibility,
        String type,
        int participants,
        double price,
        String link,
        String key
) {
}
