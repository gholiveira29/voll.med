package med.voll.api.domain.medico;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import med.voll.api.domain.endereco.EnderecoModel;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private EnderecoModel endereco;

    private boolean ativo;

    public Medico(DadosMedico dadosMedico) {
        this.nome = dadosMedico.nome();
        this.email = dadosMedico.email();
        this.crm = dadosMedico.crm();
        this.telefone = dadosMedico.telefone();
        this.especialidade = dadosMedico.especialidade();
        this.endereco = new EnderecoModel(
             dadosMedico.endereco()
        );
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid AtualizaMedicoDTO dadosMedico) {
        if (dadosMedico.nome() != null) {
            this.nome = dadosMedico.nome();
        }
        if (dadosMedico.telefone() != null) {
            this.telefone = dadosMedico.telefone();
        }
        if (dadosMedico.email() != null) {
            this.email = dadosMedico.email();
        }
        if (dadosMedico.enderco() != null) {
            this.endereco.atualizarInformacoes(dadosMedico.enderco());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}

