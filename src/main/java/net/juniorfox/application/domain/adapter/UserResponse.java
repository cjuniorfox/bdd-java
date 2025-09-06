package net.juniorfox.application.domain.adapter;

public record UserResponse(
        long id,
        String nome,
        String email
) {
}
