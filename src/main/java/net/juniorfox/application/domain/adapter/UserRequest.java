package net.juniorfox.application.domain.adapter;

import jakarta.validation.constraints.NotEmpty;

public record UserRequest(
        @NotEmpty String nome,
        @NotEmpty String email
) {
}
