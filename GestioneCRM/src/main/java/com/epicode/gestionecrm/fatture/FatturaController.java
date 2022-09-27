package com.epicode.gestionecrm.fatture;

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



@RestController
@RequestMapping("/fatture")
public class FatturaController {
	
	private FatturaService fatturaService;
	
	
	
	@GetMapping
	public ResponseEntity<Page<Fattura>>getAll(Pageable pageable)  {
		return ResponseEntity.ok(fatturaService.getAll(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fattura> get(@PathVariable Long id) {
		return ResponseEntity.ok(fatturaService.getById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Fattura> update(@PathVariable Long id, @RequestBody FatturaDto dto ) {
		return ResponseEntity.ok(fatturaService.update(dto, id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return ResponseEntity.ok("Fattura cancellato");
	}
	
	@PostMapping
	public ResponseEntity<Fattura> insert(@RequestBody FatturaDto dto) {
		
		return ResponseEntity.ok( fatturaService.insert(dto) );
		
		
	}
	


}
