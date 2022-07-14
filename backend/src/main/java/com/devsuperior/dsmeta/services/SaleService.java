package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

//Serviço responsavel por buscar as vendas

@Service				//registra o SaleService como componente do sistema
public class SaleService {
	
	//Anotaçao do Spring para Injeçao de Dependencia, assim nao precisa criar o construtor recebendo um SaleRepository
	@Autowired		
	private SaleRepository repository;	//Objeto repository para poder acessar o banco
	
	//Page/Pageable faz a paginaçao buscando de 20 em 20 linhas na tabela
	public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		//Se minDate for vazio, recebe variavel "today" menos 1 ano, se nao converte a string
		//Se maxDate for vazio, recebe variavel "today", se nao converte a string
		
		LocalDate min = minDate.equals("") ? today.minusYears(1) : LocalDate.parse(minDate);		
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
				
		return repository.findSales(min, max, pageable);		//Busca no banco de dados todas as vendas e retorna de 20 em 20		
	}
}
