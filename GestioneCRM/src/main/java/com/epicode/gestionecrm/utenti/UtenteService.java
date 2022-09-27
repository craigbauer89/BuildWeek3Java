package com.epicode.gestionecrm.utenti;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class UtenteService {
	
	
@Autowired UtenteRepository utenteRepository;
	
	public List<UtenteResponse> getAllUsersBasicInformations() {
		return utenteRepository.findAll()
				.stream()
				.map( utente ->  UtenteResponse
								.builder()
								.username(  utente.getUsername()  )
								.utenteRuolo( utente.getUtenteRuoli().stream().findFirst().get().getTipoRuolo().name() )
								.build()   
				).collect(Collectors.toList());
	}
	
	public UtenteResponse getUserBasicInformations(String userName) {
		Utente user = utenteRepository.findByUsername(userName).get();
		
		
		
		return UtenteResponse
		.builder()
		.username(userName)
		.utenteRuolo( user.getUtenteRuoli().stream().findFirst().get().getTipoRuolo().name()).build();
		
	}

}
