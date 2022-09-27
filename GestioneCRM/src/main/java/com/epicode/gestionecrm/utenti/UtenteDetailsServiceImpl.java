package com.epicode.gestionecrm.utenti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UtenteDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UtenteRepository utenteRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("[loadUserByUsername] username " + username);
		Utente utente = utenteRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));

		return UtenteDetailsImpl.build(utente);
	}

}
