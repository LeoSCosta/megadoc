package com.br.leoscosta.megadoc.dto.devedor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record DevedorResponse(
        Long id,
        Boolean excluido,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao,
        String nome,
        String documento
) {}
