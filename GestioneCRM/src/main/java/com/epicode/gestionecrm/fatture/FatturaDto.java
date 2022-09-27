package com.epicode.gestionecrm.fatture;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.epicode.gestionecrm.clienti.Cliente;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FatturaDto {
	
	
	
	private Integer anno; 
	private LocalDate data;
	private BigDecimal importo;

//	private TipoStato stato;
	
	private Long cliente_id;

}
