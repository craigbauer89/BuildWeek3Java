package com.epicode.gestionecrm.fatture;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.epicode.gestionecrm.clienti.Cliente;
import com.epicode.gestionecrm.clienti.ClienteRepository;


import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Validated
public class FatturaService {
	
	
	private FatturaRepository fatturaRepository;
	
	private ObjectProvider<Fattura>  fatturaObjectProvider;
	
	private ClienteRepository clienteRepository;
	
	public Fattura insert(@Valid FatturaDto dto) {
		if(!clienteRepository.existsById(dto.getCliente_id())) {
			throw new EntityNotFoundException("Cliente inesistente");
		}
		
		Cliente  cliente = clienteRepository.findById(dto.getCliente_id()).get();
		Fattura fattura = fatturaObjectProvider.getObject();
		BeanUtils.copyProperties(dto, fattura);
		fattura.setCliente(cliente);	

		
		return fatturaRepository.save(fattura);
		
	}
	
	public Page<Fattura> getAll(Pageable pageable) {
		return fatturaRepository.findAll(pageable);
		
	}
	
		
	
	public Fattura getById(Long id) {
		if(!fatturaRepository.existsById(id)) {
			throw new EntityNotFoundException();
		}
		return fatturaRepository.findById(id).get();
		
	}
	
	public void delete(Long id) {
		if(!fatturaRepository.existsById(id)) {
			throw new EntityNotFoundException();
		}
		fatturaRepository.deleteById(id);
		
	}
	
	public Fattura update(@Valid FatturaDto dto, Long id) {
		if(!fatturaRepository.existsById(id)) {
			throw new EntityNotFoundException();
		}
		
		Fattura r = fatturaRepository.findById(id).get();
		BeanUtils.copyProperties(dto, r);
		return fatturaRepository.save(r);
		
	}

	

}
