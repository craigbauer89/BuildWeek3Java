package com.epicode.gestionecrm.fatture;

import java.math.BigDecimal;
import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.epicode.gestionecrm.clienti.Cliente;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Fattura {
	
	
	private Integer anno; 
	private LocalDate data;
	private BigDecimal importo;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer numero;
	@OneToOne
	private TipoStato stato;
	
	@ManyToOne
	private Cliente cliente;
	

}
