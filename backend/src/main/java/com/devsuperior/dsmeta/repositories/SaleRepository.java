package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.entities.Sale;

//É responsavel por acessar o Banco de Dados
//Somente com isso o Spring já cria um componente para fazer o CRUD no banco

//Os parametros a serem passados para o JPA são: a entidade/classe (Sale) e o tipo do Id (Long)
public interface SaleRepository extends JpaRepository<Sale, Long>{
	
	//Metodo para buscar por data (Linguagem JPQL)
	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
}
