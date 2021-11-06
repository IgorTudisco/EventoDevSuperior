package com.devsuperior.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsvendas.DTO.SaleDTO;
import com.devsuperior.dsvendas.DTO.SaleSuccessDTO;
import com.devsuperior.dsvendas.DTO.SaleSumDTO;
import com.devsuperior.dsvendas.service.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	/*
	 * Como o meu serviço vai retornar uma quantidade de dados
	 * determinados, eu também precisa passar no meu controlador o
	 * tipo Page e o Pageable, para que ele entenda quantos dados
	 * ele deve retornar.
	 */
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {

		Page<SaleDTO> list = service.findAll(pageable);

		return ResponseEntity.ok(list);

	}
	
	/*
	 * Caminho dos vendedores e a quantidade de venda de
	 * cada uma.
	 */
	@GetMapping(value = "/amout-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amoutGroupedBySeller() {

		List<SaleSumDTO> list = service.amoutGroupedBySeller();

		return ResponseEntity.ok(list);

	}

	/*
	 * Caminho dos vendedores e a quantidade de venda de
	 * cada uma.
	 */
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller() {

		List<SaleSuccessDTO> list = service.successGroupedBySeller();

		return ResponseEntity.ok(list);

	}
	
}
