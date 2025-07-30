package med.voll.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pacientes")
@SecurityRequirement(name = "bearer-key")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<PacienteDTO> cadastrar(@RequestBody @Valid DadosPaciente dadosPaciente,
            UriComponentsBuilder uriBuilder) {
        var paciente = new Paciente(dadosPaciente);
        pacienteRepository.save(paciente);
        var uri = uriBuilder.path("/pacientes/{id}")
                .buildAndExpand(paciente.getId())
                .toUri();
        return ResponseEntity.created(uri).body(new PacienteDTO(paciente));
    }

    @GetMapping
    public ResponseEntity<Page<PacienteDTO>> listar(Pageable paginacao) {
        var page = pacienteRepository.findAll(paginacao)
                .map(PacienteDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<PacienteDTO> atualiazar(@RequestBody @Valid AtualizaDadosPacienteDTO dadosPaciente) {
        var paciente = pacienteRepository.getReferenceById(dadosPaciente.id());
        paciente.atualizarInformacoes(dadosPaciente);
        return ResponseEntity.ok(new PacienteDTO(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> excluir(@PathVariable Long id) {
        var paciente = pacienteRepository.findById(id);
        paciente.get().excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhe(@PathVariable Long id) {
        var paciente = pacienteRepository.findById(id);
        return ResponseEntity.ok(paciente);
    }
}
