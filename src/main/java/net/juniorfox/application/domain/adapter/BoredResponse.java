package net.juniorfox.application.domain.adapter;

public record BoredResponse(
        String atividade,
        String acessibilidade,
        String tipo,
        int participantes,
        double preco,
        String link,
        String chave
) {
}
