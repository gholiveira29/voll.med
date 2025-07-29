package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ValidadorPacienteAgendamento implements ValidadorAgendamento {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        var primeiroHorario = dadosAgendamentoConsulta.data().withHour(7);
        var ultimoHorario = dadosAgendamentoConsulta.data().withHour(18);
        var pacienteAgendado = consultaRepository.existsByPacienteIdAndDataBetween(dadosAgendamentoConsulta.idPaciente(),primeiroHorario,ultimoHorario);

        if(pacienteAgendado) throw new ValidacaoException("Paciente já está agendado para o dia selecionado");
    }
}
