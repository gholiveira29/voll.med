package med.voll.api.domain.medico;

public record MedicoDTO(String nome,String email,String crm,Especialidade especialidade, Long id,String telefone) {

    public MedicoDTO(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade(), medico.getId(), medico.getTelefone());
    }
}
