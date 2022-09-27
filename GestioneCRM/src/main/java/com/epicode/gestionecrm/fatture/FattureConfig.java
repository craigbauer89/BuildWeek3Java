package com.epicode.gestionecrm.fatture;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class FattureConfig {
	
	
	@Bean
	@Scope("prototype")
	public Fattura  newFattura() {
		return new Fattura();
	}

}
