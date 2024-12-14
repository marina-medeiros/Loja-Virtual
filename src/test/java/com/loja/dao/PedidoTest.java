package test.java.com.loja.dao;

import main.java.com.loja.dao.Pedido;
import main.java.com.loja.dao.Catalogo;
import main.java.com.loja.model.Produto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido pedido;

    @BeforeEach
    void setUp() {
        pedido = new Pedido("Cliente Teste");
    }

    @Test
    void testAdicionarProdutoAoPedido() {
        Produto produtoA = new Produto("Produto A", 50.0f);
        Catalogo.adicionarProduto(produtoA);
        pedido.adicionarProduto(produtoA);
        Produto produtoB = new Produto("Produto B", 50.0f);
        Catalogo.adicionarProduto(produtoB);
        pedido.adicionarProduto(produtoB);
        assertTrue(pedido.getProdutos().contains(produtoA));
        assertTrue(pedido.getProdutos().contains(produtoA) && pedido.getProdutos().contains(produtoB));
    }

    @Test
    void testCalcularTotalComDesconto() {
        Produto produtoA = new Produto("Produto A", 100.0f);
        Produto produtoB = new Produto("Produto B", 100.0f);
        Catalogo.adicionarProduto(produtoA);
        Catalogo.adicionarProduto(produtoB);
        pedido.adicionarProduto(produtoA);
        pedido.adicionarProduto(produtoB);
        assertEquals(180.0f, pedido.calcularTotal(), 0.01f);
    }

    @Test
    void testCalcularTotalSemDesconto() {
        Produto produtoA = new Produto("Produto A", 50.0f);
        Catalogo.adicionarProduto(produtoA);
        pedido.adicionarProduto(produtoA);
        assertEquals(50.0f, pedido.calcularTotal());
    }

}