package test.java.com.loja.dao;

import main.java.com.loja.dao.Catalogo;
import main.java.com.loja.model.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class CatalogoTest {

    private Catalogo catalogo;

    @BeforeEach
    void setUp() {
        catalogo = new Catalogo();
        catalogo.adicionarProduto(new Produto("Produto A", 50.0f));
        catalogo.adicionarProduto(new Produto("Produto B", 30.0f));
    }

    @Test
    void testAdicionarProduto() {
        Produto produto = new Produto("Produto C", 70.0f);
        catalogo.adicionarProduto(produto);
        List<Produto> produtos = catalogo.getProdutos();
        assertTrue(produtos.contains(produto));
    }

    @Test
    void testBuscarProdutoPorIdExistente() {
        Produto produto = catalogo.buscarProdutoPorId(1);
        assertNotNull(produto);
        assertEquals("Produto A", produto.getNome());
    }

    @Test
    void testBuscarProdutoPorIdInexistente() {
        Produto produto = catalogo.buscarProdutoPorId(99);
        assertNull(produto);
    }
}
