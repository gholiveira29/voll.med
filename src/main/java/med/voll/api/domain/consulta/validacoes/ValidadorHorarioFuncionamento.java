package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;


@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamento {

    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        var dataConsulta = dadosAgendamentoConsulta.data();
        var domingo = dataConsulta.getDayOfWeek().equals(DayOfWeek.SATURDAY);
        var horarioAbertura = dataConsulta.getHour() < 7;
        var horarioFechamento = dataConsulta.getHour() > 18;

        if(domingo || horarioAbertura || horarioFechamento) throw new ValidacaoException("Consulta fora do horario de funcionamento");

    }
}
