package com.devsuperior.dsmeta.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.services.SaleService;
import com.devsuperior.dsmeta.services.SmsService;

@RestController		//Informa que é um componente "Controlador"
@RequestMapping(value = "/sales")		//O caminho para acessar o backend (http://localhost:8080/sales)
public class SaleController {
	
	//Implementa a API
	//Classe responsavel por disponibilizar os "endpoints" para o frontend acessar o backend
	
	@Autowired
	private SaleService service;		//Usa o SaleService que acessar o banco para poder pegar os dados
	
	@Autowired
	private SmsService smsService;
	
	//Recebe as datas como String e depois converte
	
	@GetMapping			//Obter os dados - disponibilizar as vendas para o frontend
	public Page<Sale> findSales(
			@RequestParam(value = "minDate", defaultValue = "") String minDate, //Se usuario nao preencher data, vai usar o valor default
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate,  
			Pageable pageable){		 
		return service.findSales(minDate,maxDate,pageable);
	}
	
	@GetMapping("/{id}/notification")
	public void notifySms(@PathVariable Long id) {
		smsService.sendSms(id);
	}
}
