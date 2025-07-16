package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.EnderecoMed;

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
    private EnderecoMed endereco;

    public Medico(DadosMedico dadosMedico) {
        this.nome = dadosMedico.nome();
        this.email = dadosMedico.email();
        this.crm = dadosMedico.crm();
        this.telefone = dadosMedico.telefone();
        this.especialidade = dadosMedico.especialidade();
        this.endereco = new EnderecoMed(
             dadosMedico.endereco()
        );
    }
}

