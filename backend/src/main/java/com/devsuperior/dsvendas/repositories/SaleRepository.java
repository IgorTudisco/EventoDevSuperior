package com.devsuperior.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsvendas.DTO.SaleSuccessDTO;
import com.devsuperior.dsvendas.DTO.SaleSumDTO;
import com.devsuperior.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

	/*
	 * Essa anotação nos permite passar comandos SQL ou JPQL
	 * que é uma anotação do java para o SQL.
	 * 
	 * No caso o que vai ser usado vai ser o JPQL.
	 * 
	 * Após o select temos que passar todo o caminha da class que estamos
	 * querendo pesquisar. Usando o construto desse obj, passamos os seus
	 * parâmetros.
	 * 
	 * Os parâmetros são os atributos do Sale e o seu apelido é obj.
	 */
	@Query("SELECT new com.devsuperior.dsvendas.DTO.SaleSumDTO(obj.seller, SUM(obj.amount)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	/*
	 * Método que vai fazer a soma das vendas dos vendedores e
	 * vai agrupar por vendedor.
	 */
	List<SaleSumDTO> amoutGroupedBySeller();
	
	@Query("SELECT new com.devsuperior.dsvendas.DTO.SaleSuccessDTO(obj.seller, SUM(obj.visited), SUM(obj.deals)) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();
	
}
