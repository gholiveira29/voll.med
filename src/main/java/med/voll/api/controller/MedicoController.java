package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosMedico dadosMedico, UriComponentsBuilder uriBuilder) {
        var medico = new Medico(dadosMedico);
        medicoRepository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}")
                .buildAndExpand(medico.getId())
                .toUri();
        return ResponseEntity.created(uri).body(medico);
    }

    @GetMapping
    public ResponseEntity<Page<MedicoDTO>> listar(Pageable paginacao) {
        var page = medicoRepository.findAllByAtivoTrue(paginacao)
                .map(MedicoDTO::new);
        return ResponseEntity.ok(page);

    }


    @PutMapping
    @Transactional
    public ResponseEntity atualiazar(@RequestBody @Valid AtualizaMedicoDTO dadosMedico) {
        var medico = medicoRepository.getReferenceById(dadosMedico.id());
        medico.atualizarInformacoes(dadosMedico);
        return ResponseEntity.ok(new MedicoDTO(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var medicoOpt = medicoRepository.findById(id);
        medicoOpt.get().excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhes(@PathVariable Long id) {
        var medicoOpt = medicoRepository.findById(id);
        return ResponseEntity.ok(medicoOpt);
    }


}
