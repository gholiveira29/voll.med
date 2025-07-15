package med.voll.api.medico;

import med.voll.api.endereco.Endereco;

public record DadosMedico(String nome,
    String email,
    String telefone,
    String crm,
    Especialidade especialidade,
    Endereco endereco)
    {}