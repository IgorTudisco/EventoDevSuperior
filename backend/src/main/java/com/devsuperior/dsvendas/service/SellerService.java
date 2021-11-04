package com.devsuperior.dsvendas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.DTO.SellerDTO;
import com.devsuperior.dsvendas.entities.Seller;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		
		List<Seller> result = repository.findAll();
		
		/* Para converter uma lista de Seller para uma
		 * lista DTO, vamos usar o map para que cada
		 * elemento da lista seja convertido em DTO.
		 * 
		 * Transforme cada x em um xDTO e depois,
		 * transforme essa coleção em uma lista.
		*/		
		return result.stream().map(x ->
		new SellerDTO(x)).collect(Collectors.toList());
	}

}
