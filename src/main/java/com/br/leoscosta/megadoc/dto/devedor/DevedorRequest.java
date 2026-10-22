package com.br.leoscosta.megadoc.dto.devedor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DevedorRequest(
        @NotBlank(message = "O nome é obrigatório")
        @Size(max = 150, message = "O nome deve ter no máximo 150 caracteres")
        String nome,

        @NotBlank(message = "O documento é obrigatório")
        String documento
) {
}
