package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoOcupado implements ValidadorAgendamento {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dadosAgendamentoConsulta) {
        var medicoOcupado = consultaRepository.existsByMedicoIdAndData(dadosAgendamentoConsulta.idMedico(), dadosAgendamentoConsulta.data());

       if(medicoOcupado) throw new ValidacaoException("Médico já possiu consulta agendada nesse horario");
    }
}
