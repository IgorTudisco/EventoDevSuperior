package com.devsuperior.dsvendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsvendas.DTO.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	/*
	 * Esse repositório vai servir para resolver
	 * um problema de consulta ao banco de
	 * dados. Pois o Jpa faz vários selects
	 * para trazer os dados. Ele faz isso o
	 * quanto for necessário para ter em mãos
	 * os dados buscados.
	 * 
	 * Para resolver esse problema, vamos usar esse
	 * atributo para deixar em memória
	 * todos os dados, assim ele diminui
	 * o tempo de consulta ao banco, pois os dados
	 * já estaram em memória.
	 */
	@Autowired
	private SaleRepository saleRepository;

	/*
	 * Garante que operação seja resolvida no service
	 * e o readOnly é para ele não
	 * fazer looking.
	 */
	@Transactional(readOnly = true)
	/*
	 * Como ao pesquisar queremos que ele nos retorne apenas
	 * uma quantidade de
	 * informações. Usamos o Pageable e passamos que
	 * ele será so tipo Page.
	 */
	public Page<SaleDTO> findAll(Pageable pagable) {

		/*
		 * Ao passar o findAll() ele vai armazenar os
		 * dados em memória. Diminuindo assim
		 * o número de selects.
		 */
		saleRepository.findAll();

		Page<Sale> result = repository.findAll(pagable);

		/*
		 * Para converter uma lista de Seller para uma lista DTO,
		 * vamos usar o map para
		 * que cada elemento da lista seja convertido em DTO.
		 * 
		 * Como o tipo Page já um steam do Spring, não precisamos usar
		 * o steam() e
		 * também não precisamos converte-lo para collect,
		 * assim podemos tirar o
		 * collect(Collectors.toList()).
		 */
		return result.map(x -> new SaleDTO(x));
	}

}
