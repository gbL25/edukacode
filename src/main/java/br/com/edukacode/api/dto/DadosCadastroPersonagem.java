package br.com.edukacode.api.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPersonagem(
        @NotBlank
        String nome,
        @NotBlank
        String arquetipo,
        @NotBlank
        String historia,
        @NotBlank
        String personalidade,
        @NotBlank
        String motivacoes,
        @NotBlank
        String aparencia) {

}
