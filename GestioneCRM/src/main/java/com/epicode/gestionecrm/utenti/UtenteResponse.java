package com.epicode.gestionecrm.utenti;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UtenteResponse {
	
	private String username;
	private String utenteRuolo;

}
