package edu.noe.pruebatecnica.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.noe.pruebatecnica.entity.Fiscalia;
import edu.noe.pruebatecnica.repository.FiscaliaRepository;

@Service
public class FiscaliaServiceImpl implements FiscaliaService {
	
	@Autowired
	private FiscaliaRepository fiscaliaRepository;

	@Override
	@Transactional(readOnly = true)
	public Iterable<Fiscalia> findAll() {
		return fiscaliaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Fiscalia> findById(Long id) {
		return fiscaliaRepository.findById(id);
	}

	@Override
	public Fiscalia save(Fiscalia fiscalia) {
		return fiscaliaRepository.save(fiscalia);
	}

	@Override
	public void deleteById(Long id) {
		fiscaliaRepository.deleteById(id);
	}
	
}
