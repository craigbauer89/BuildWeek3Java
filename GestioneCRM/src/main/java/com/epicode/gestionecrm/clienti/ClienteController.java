package com.epicode.gestionecrm.clienti;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/clienti")
public class ClienteController {

	private ClienteService  cService;
	
	@GetMapping
	public ResponseEntity<Page<Cliente>> getAll(Pageable pageable) {
		return ResponseEntity.ok(cService.getAll(pageable));
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody ClienteDto dto) {
		return ResponseEntity.ok(cService.insert(dto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cliente>> getById(@PathVariable Long id) {
		return ResponseEntity.ok(cService.getById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id,@RequestBody ClienteDto dto) {
		return ResponseEntity.ok(cService.update(id, dto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return ResponseEntity.ok("Cliente cancellato");
	}
	
}