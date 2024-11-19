package com.projeto.produto.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProdutoTest {

	private Produto produto;

	@BeforeEach
	void setUp() {
		// Arrange
		produto = new Produto(1L, "Celular", "barato", 120.00);
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		// Act
		produto.setId(2L);
		// Assert
		assertEquals(2L, produto.getId());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo nome")
	void testNome() {
		// Act
		produto.setNome("mouse");
		// Assert
		assertEquals("mouse", produto.getNome());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo descrição")
	void testDescricao() {
		// Act
		produto.setDescricao("boa marca");
		// Assert
		assertEquals("boa marca", produto.getDescricao());
	}

	@Test
	@DisplayName("Testando o getter e setter do campo preço")
	void testPreco() {
		// Act
		produto.setPreco(80.00);
		// Assert
		assertEquals(80.000,produto.getPreco());
	}

	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstructorAll() {
		// Act
		Produto novoProduto = new Produto(3L, "notebook", "bom preco",2000.00);
		// Assertion
		assertAll("novoHospede", () -> assertEquals(3L, novoProduto.getId()),
				() -> assertEquals("notebook", novoProduto.getNome()),
				() -> assertEquals("bom preco", novoProduto.getDescricao()),
				() -> assertEquals(2000.00, novoProduto.getPreco()));

	}
}

