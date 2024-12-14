package main.java.com.loja.dao;

import main.java.com.loja.model.Produto;
import main.java.com.loja.dao.Catalogo;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Pedido {
    private List<Produto> produtos = new ArrayList<Produto>();
    private String nome;
    private static final Logger logger = Logger.getLogger(Pedido.class.getName()) ;

    public Pedido(String nome) {
        this.nome = nome;
        logger.info("Pedido de " + nome + " criado");
    }

    public List<Produto> getProdutos() {return produtos;}

    public void adicionarProduto(Produto produto) {
        Produto produtoCatalogo = Catalogo.buscarProdutoPorId(produto.getId());
        if (produtoCatalogo != null) {
            produtos.add(produto);
        } else {
            System.err.println("Erro: O produto com ID " + produto.getId() + " não existe no catálogo.");
            produto.detalharProduto();
        }
    }

    public float calcularTotal() {
        float total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        if (total > 100) {
            total *= 0.9f;
            logger.info("Desconto de 10% aplicado");
        }
        logger.info("Total R$:" + total);
        return total;
    }

    public void detalharPedido() {
        System.out.println("----------Pedido----------");
        for (Produto produto : produtos) {
            produto.detalharProduto();
        }
        System.out.println("Total: " + calcularTotal());
    }
}

