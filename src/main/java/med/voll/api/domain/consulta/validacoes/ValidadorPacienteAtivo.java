package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamento {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        var pacienteAtivo = pacienteRepository.findAtivoById(dadosAgendamentoConsulta.idPaciente());

        if(!pacienteAtivo) throw new ValidacaoException("Paciente inativo");
    }
}
