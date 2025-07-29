package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamento {

    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        var horario = dadosAgendamentoConsulta.data();
        var horaAtual = LocalDateTime.now();
        var horaValida = Duration.between(horaAtual,horario).toMinutes();

        if(horaValida < 30) throw new ValidacaoException("Horario minimo de antecedência é de 30min");

    }
}
