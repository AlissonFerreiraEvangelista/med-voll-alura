package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.domain.medico.*;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("medicos")
public class MedicoController {

	@Autowired
	MedicoRepository medicoRepository;

	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid DtoCadastroMedico dto, UriComponentsBuilder uriBuilder) {
		var medico = new Medico(dto);
		medicoRepository.save(medico);	
		var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
		return ResponseEntity.created(uri).body(new DtoDetalhamentoMedico(medico));

	}

	@GetMapping()
	public ResponseEntity<Page<DtoListaMedico>> listar(@PageableDefault(size = 10, sort = "nome") 	Pageable paginacao) {
		return ResponseEntity.status(HttpStatus.OK).body(medicoRepository.findAll(paginacao).map(DtoListaMedico::new));
	}

	@PutMapping()
	@Transactional
	public ResponseEntity<DtoDetalhamentoMedico> alterar(@RequestBody @Valid DtoAlteraMedico dto) {
		var medico = medicoRepository.getReferenceById(dto.id());
		medico.atualizaInformacao(dto);
		return ResponseEntity.status(HttpStatus.OK).body(new DtoDetalhamentoMedico(medico));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?>delete(@PathVariable(value = "id") UUID id) {
		var med = medicoRepository.getReferenceById(id);
		if (med == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			med.inativo();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<?> detalhar(@PathVariable(value = "id") UUID id) {
		var med = medicoRepository.getReferenceById(id);
		return ResponseEntity.status(HttpStatus.OK).body(new DtoDetalhamentoMedico(med));
		

	}

}
