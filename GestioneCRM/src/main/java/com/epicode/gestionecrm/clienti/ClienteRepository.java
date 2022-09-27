package com.epicode.gestionecrm.clienti;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ClienteRepository  extends PagingAndSortingRepository<Cliente, Long> {
	
	public Cliente findByPartitaIva(String partitaIva);
	public boolean existsByPartitaIva(String partitaIva);

}
