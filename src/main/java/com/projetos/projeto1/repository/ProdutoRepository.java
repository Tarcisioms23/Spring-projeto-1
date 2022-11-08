package com.projetos.projeto1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetos.projeto1.models.Produto;

// JPA ja possui varios methods de buscar e outros methods de banco
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
 
	Produto findById(long id);
}
