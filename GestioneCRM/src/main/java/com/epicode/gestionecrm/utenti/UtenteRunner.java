package com.epicode.gestionecrm.utenti;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;



import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@AllArgsConstructor
@Slf4j
public class UtenteRunner  implements ApplicationRunner{
	
	
	UtenteRepository userRepository;
	RuoloRepository roleRepository;
	PasswordEncoder encoder;
	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		
		
			UtenteRuolo admin = new UtenteRuolo();
			admin.setTipoRuolo( TipoRuolo.ADMIN);
			roleRepository.save(admin);
			
			UtenteRuolo user = new UtenteRuolo();
			user.setTipoRuolo( TipoRuolo.USER);
			roleRepository.save(user);
			
			Set<UtenteRuolo> ruoliAdministrator = new HashSet<UtenteRuolo>();
			ruoliAdministrator.add(admin);
			
			Utente userAdmin  = new Utente();
			userAdmin.setUsername("Timoty43");
			userAdmin.setPassword(encoder.encode("aaaaa"));
			userAdmin.setNome("Timmy");
			userAdmin.setEmail("timmyv@gmail.com");
			userAdmin.setCognome("Verde");
			userAdmin.setUtenteRuoli(ruoliAdministrator);
			userRepository.save(userAdmin);
			
			Set<UtenteRuolo> ruoliUtente = new HashSet<UtenteRuolo>();
			ruoliUtente.add(user);
			
			Utente simpleUser = new Utente();
			simpleUser.setUsername("gianluigi67");
			simpleUser.setNome("gianluigi");
			simpleUser.setEmail("gianluigi@gmail.com");
			simpleUser.setCognome("Marrone");
			simpleUser.setPassword( encoder.encode("bbbbb"));
	
			simpleUser.setUtenteRuoli(ruoliUtente);
			userRepository.save(simpleUser);
			
			Utente simpleUser2 = new Utente();
			simpleUser2.setUsername("dobby67");
			simpleUser2.setNome("Dennis");
			simpleUser2.setEmail("dobby1@gmail.com");
			simpleUser2.setCognome("OBrien");
			simpleUser2.setPassword( encoder.encode("ccccc"));
			
			simpleUser2.setUtenteRuoli(ruoliUtente);
			userRepository.save(simpleUser);
		
	}

}
