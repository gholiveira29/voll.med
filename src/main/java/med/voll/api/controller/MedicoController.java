package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoDTO;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosMedico dadosMedico) {
        medicoRepository.save(new Medico(dadosMedico));
    }

    @GetMapping
    public Page<MedicoDTO> listar(Pageable paginacao) {
        return medicoRepository.findAll(paginacao)
                .map(MedicoDTO::new);
    }


    @GetMapping("/{id}")
    public MedicoDTO detalhar(@PathVariable Long id) {
        Optional<Medico> medico = medicoRepository.findById(id);
        if (medico.isPresent()) {
            return new MedicoDTO(medico.get());
        } else {
            throw new RuntimeException("Médico não encontrado");
        }
    }

}
