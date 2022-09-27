package com.epicode.gestionecrm.clienti;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;




@Configuration
public class ClienteConfig {


	@Bean
	@Scope("prototype")
	public Cliente newCliente() {
		Cliente  cliente =new Cliente();
		
		return  cliente;
	}
	
	@Bean
	@Scope("prototype")
	public ClienteDto newClienteDto() {
		ClienteDto  cliente = new ClienteDto();
		
		return  cliente;
	}

}

