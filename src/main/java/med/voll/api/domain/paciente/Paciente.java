package med.voll.api.domain.paciente;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import med.voll.api.domain.endereco.EnderecoModel;

@Table(name = "pacientes")
@Entity(name = "paciente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    @Embedded
    private EnderecoModel endereco;

    private boolean ativo;

    public Paciente(@Valid DadosPaciente dadosPaciente) {
        this.nome = dadosPaciente.nome();
        this.email = dadosPaciente.email();
        this.telefone = dadosPaciente.telefone();
        this.cpf = dadosPaciente.cpf();
        this.endereco = new EnderecoModel(
                dadosPaciente.endereco()
        );
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid AtualizaDadosPacienteDTO dadosPaciente) {
        if (dadosPaciente.name() != null) {
            this.nome = dadosPaciente.name();
        }
        if (dadosPaciente.telefone() != null) {
            this.telefone = dadosPaciente.telefone();
        }
        if (dadosPaciente.endereco() != null) {
            this.endereco.atualizarInformacoes(dadosPaciente.endereco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
