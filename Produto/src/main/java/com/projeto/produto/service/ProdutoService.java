package com.projeto.produto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.produto.entity.Produto;
import com.projeto.produto.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public List<Produto> listarTodos() {
		return produtoRepository.findAll();
	}

	public Optional<Produto> buscarPorId(Long id) {
		return produtoRepository.findById(id);
	}

	public Produto atualizarProduto(Produto produto) {
		if (produtoRepository.existsById(produto.getId())) {
			return produtoRepository.save(produto);
		} else {
			throw new RuntimeException("Produto não encontrado");
		}
	}

	public void deletarProduto(Long id) {
		produtoRepository.deleteById(id);
	}

}
