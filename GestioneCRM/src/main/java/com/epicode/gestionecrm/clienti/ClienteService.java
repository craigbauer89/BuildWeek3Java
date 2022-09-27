package com.epicode.gestionecrm.clienti;

import java.util.Optional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;



import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
@Validated
public class ClienteService {

	private ClienteRepository  clienteRepository;
	
	private ObjectProvider<Cliente> clienteProvider;
	
	private ObjectProvider<ClienteDto> clienteDtoProvider;

	public Page<Cliente> getAll(Pageable pageable) {
		return clienteRepository.findAll(pageable);
	}
	
	public Optional<Cliente> getById(Long id) {
		Optional<Cliente>  cliente = clienteRepository.findById(id);
		if (cliente.isPresent()) return cliente;
		
		throw new EntityNotFoundException("Cliente non trovato");
				
	}
	
	public Cliente getById2(Long id) {
		if(clienteRepository.existsById(id)) {
			return clienteRepository.findById(id).get();
		}
		throw new EntityNotFoundException("Cliente non trovato");
	}
	
	public Cliente insert(@Valid ClienteDto dto) {
		if(clienteRepository.existsByPartitaIva(dto.getPartitaIva())) {
			throw new EntityExistsException("Cliente gia inserito");
		}
		
		Cliente cliente = clienteProvider.getObject();
		BeanUtils.copyProperties(dto, cliente);
		
		return clienteRepository.save(cliente);
		
	}
	
	public Cliente update(Long id, @Valid ClienteDto dto) {
		
		Optional<Cliente> clienteOpt = clienteRepository.findById(id);
		if (!clienteOpt.isPresent()) {
			throw new EntityNotFoundException();	
		}
		
		Cliente t = clienteOpt.get();
		BeanUtils.copyProperties(dto, t);
		
		return clienteRepository.save(t);
		
	}

}


