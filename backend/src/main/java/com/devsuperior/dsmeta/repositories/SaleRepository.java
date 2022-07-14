package com.devsuperior.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dsmeta.entities.Sale;

//Somente com isso o Spring já cria um componente para fazer o CRUD

public interface SaleRepository extends JpaRepository<Sale, Long>{

}
