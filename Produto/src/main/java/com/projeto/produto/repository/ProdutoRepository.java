package com.projeto.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.produto.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {

}
