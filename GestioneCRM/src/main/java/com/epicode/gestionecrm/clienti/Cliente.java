package com.epicode.gestionecrm.clienti;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.epicode.gestionecrm.fatture.Fattura;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String ragioneSociale;
	private String partitaIva;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private LocalDate dataInserimento;
	private LocalDate dataUltimoContatto;
	private Long fatturatoAnnuale;
//	@Column(length = 40)
	private String pec;
	private String telefono;
	private String emailContatto;
	private String nomeContatto;
	private String cognomeContatto;
	private String telefonoContatto;
	
	@Enumerated(EnumType.STRING)
	private TipoAzienda TipoAzienda;
	@OneToOne
	private Indirizzo indirizzoLegale;
	@OneToOne
	private Indirizzo indirizzoSede;
	
	@OneToMany(mappedBy = "cliente")
	private	List<Fattura> fatturi;

}
