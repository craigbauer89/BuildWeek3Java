package com.epicode.gestionecrm.fatture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FatturaRepository extends JpaRepository<Fattura, Long> {

}
