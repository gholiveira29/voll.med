package med.voll.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record Endereco(

        @NotBlank
        String logradouro,

        @NotBlank
        String numero,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        String uf,

        String complemento,
        @Pattern(regexp = "\\d{8}")
        String cep) {


}
