package com.projeto.produto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projeto.produto.entity.Produto;
import com.projeto.produto.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@SpringBootTest // Carrega o contexto completo do Spring para testes
@Transactional // Garante que as operações no banco de dados serão revertidas após cada teste
class ProdutoServiceTest {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ProdutoRepository produtoRepository;

	@BeforeEach
	void setUp() {
		produtoRepository.deleteAll(); // Limpa o banco de dados antes de cada teste

	}

	@DisplayName("Testando salvar Produto")
	@Test
	void testSalvarProduto() {
		Produto produto = new Produto(null, "televisao", "boa marca", 800.00);

		Produto resultado = produtoService.salvarProduto(produto);

		assertNotNull(resultado);
		assertEquals("televisao", resultado.getNome());
		assertEquals("boa marca", resultado.getDescricao());
		assertEquals(800.00, resultado.getPreco());
		assertTrue(resultado.getId() > 0);
	}

	@DisplayName("Testando listar os Produtos")
	@Test
	void testListarTodos() {
		Produto produto1 = new Produto(null, "televisao", "boa marca", 800.000);
		Produto produto2 = new Produto(null, "tenis", "bom preco", 1700.00);

		produtoService.salvarProduto(produto1);
		produtoService.salvarProduto(produto2);

		List<Produto> resultado = produtoService.listarTodos();

		assertNotNull(resultado);
		assertEquals(2, resultado.size());
	}

	@DisplayName("Testando buscar Produto por ID")
	@Test
	void testBuscarPorId() {
		Produto produto = new Produto(null, "televisao", "boa marca", 800.000);

		Produto salvo = produtoService.salvarProduto(produto);
		Optional<Produto> resultado = produtoService.buscarPorId(salvo.getId());

		assertTrue(resultado.isPresent());
		assertEquals("televisao", resultado.get().getNome());
		assertEquals("boa marca", resultado.get().getDescricao());
		assertEquals(800.000, resultado.get().getPreco());

	}

	@DisplayName("Testando atualizar Produto por ID")
	@Test
	void testAtualizarProduto() {
		Produto produto = new Produto(null, "televisao", "boa marca", 800.000);
		Produto salvo = produtoService.salvarProduto(produto);

		salvo.setNome("garrafinha");
		salvo.setDescricao("colocar agua");
		salvo.setPreco(8.00);

		Produto atualizado = produtoService.atualizarProduto(salvo);

		assertNotNull(atualizado);
		assertEquals("garrafinha", atualizado.getNome());
		assertEquals("colocar agua", atualizado.getDescricao());
		assertEquals(8.00, atualizado.getPreco());

	}

	@DisplayName("Testando deletar Produto por ID")
	@Test
	void testDeletarProduto() {
		Produto produto = new Produto(null, "televisao", "boa marca", 800.000);

		Produto salvo = produtoService.salvarProduto(produto);
		produtoService.deletarProduto(salvo.getId());

		Optional<Produto> resultado = produtoService.buscarPorId(salvo.getId());

		assertTrue(resultado.isEmpty());
	}

}
