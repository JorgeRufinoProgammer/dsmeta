package com.devsuperior.dsmeta.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service				//registra o SaleService como componente do sistema
public class SaleService {
	
	@Autowired		//Anotaçao do Spring para Injeçao de Dependencia
	private SaleRepository repository;
	
	public List<Sale> findSales() {
		return repository.findAll();		//Busca no banco de dados todas as vendas e retorna
		
	}
}
