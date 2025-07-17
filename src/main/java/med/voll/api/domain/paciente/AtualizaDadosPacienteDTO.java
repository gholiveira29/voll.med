package med.voll.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.endereco.EnderecoModel;

public record AtualizaDadosPacienteDTO(
        @NotNull
        Long id,
        String name,
        String telefone,
        EnderecoModel endereco
) {
}
