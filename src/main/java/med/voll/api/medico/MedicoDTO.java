package med.voll.api.medico;

public record MedicoDTO(String nome,String email,String crm,Especialidade especialidade) {

    public MedicoDTO(Medico medico) {
        this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
