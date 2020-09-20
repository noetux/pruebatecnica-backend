package edu.noe.pruebatecnica.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.noe.pruebatecnica.entity.Fiscalia;
import edu.noe.pruebatecnica.service.FiscaliaService;

@RestController
@RequestMapping("mp/fiscalias")
public class FiscaliaController {
	
	@Autowired
	private FiscaliaService fiscaliaService;
	
	//Create
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Fiscalia fiscalia) {
		return ResponseEntity.status(HttpStatus.CREATED).body(fiscaliaService.save(fiscalia));
	}
	
	//Read
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable Long id) {
		Optional<Fiscalia> fiscalia = fiscaliaService.findById(id);
		if (!fiscalia.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(fiscalia.get());
	}
	
	//Update
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Fiscalia fiscaliaDetalle, @PathVariable Long id) {
		Optional<Fiscalia> fiscalia = fiscaliaService.findById(id);
		if (!fiscalia.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		fiscalia.get().setNombre(fiscaliaDetalle.getNombre());
		fiscalia.get().setTelefono(fiscaliaDetalle.getTelefono());
		fiscalia.get().setDireccion(fiscaliaDetalle.getDireccion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(fiscaliaService.save(fiscalia.get()));
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable Long id) {
		if (!fiscaliaService.findById(id).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		fiscaliaService.deleteById(id);
		
		return ResponseEntity.ok().build();
	}
	
	//Read all
	@GetMapping
	public List<Fiscalia> readAll () {
		List<Fiscalia> fiscalias = StreamSupport
				.stream(fiscaliaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return fiscalias;
	}
	
}
