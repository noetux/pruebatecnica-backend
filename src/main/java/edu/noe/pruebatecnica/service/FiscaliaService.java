package edu.noe.pruebatecnica.service;

import java.util.Optional;

import edu.noe.pruebatecnica.entity.Fiscalia;

public interface FiscaliaService {
	public Iterable<Fiscalia> findAll();
	public Optional<Fiscalia> findById(Long id);
	public Fiscalia save(Fiscalia fiscalia);
	public void deleteById(Long id);
}
