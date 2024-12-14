package test.java.com.loja.model;

import main.java.com.loja.model.Produto;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ProdutoTest {

    @Test
    void testProdutoCriacao() {
        Produto produto = new Produto("Produto A", 50.0f);
        assertEquals(1, produto.getId());
        assertEquals("Produto A", produto.getNome());
        assertEquals(50.0f, produto.getPreco());
    }

    @Test
    void testDetalharProduto() {
        Produto produto = new Produto("Produto B", 30.0f);
        assertDoesNotThrow(() -> produto.detalharProduto());
    }
}