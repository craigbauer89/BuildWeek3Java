package com.epicode.gestionecrm.clienti;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {
	
	
	

	
	private String ragioneSociale;
	private String partitaIva;

	private String email;

	private LocalDate dataInserimento;
	private LocalDate dataUltimoContatto;
	
//	@NotBlank(message = "devi inseriri qualcosa")
	private Long fatturatoAnnuale;
//
//	@Size(min = 3, max = 40, message = "cosa fai?")
	private String pec;
	private String telefono;
	private String emailContatto;
	private String nomeContatto;
	private String cognomeContatto;
	private String telefonoContatto;
	
}
