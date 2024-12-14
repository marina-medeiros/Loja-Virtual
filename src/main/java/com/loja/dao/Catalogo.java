package main.java.com.loja.dao;

import main.java.com.loja.model.Produto;
import main.java.com.loja.dao.Pedido;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Catalogo {
    private static List<Produto> produtos = new ArrayList<Produto>();
    private static final Logger logger = Logger.getLogger(Pedido.class.getName()) ;

    public Catalogo(List<Produto> produtosIniciais) {
        produtos.addAll(produtosIniciais);
    }

    public Catalogo() {}

    public List<Produto> getProdutos() {
        return produtos;
    }

    public static void adicionarProduto(Produto produto) {
        produtos.add(produto);
        if(produtos.contains(produto)) {
            logger.info("Produto " + produto.getNome() + " adicionado com sucesso!");
        }

    }

    public static Produto buscarProdutoPorId(int id) throws ArrayStoreException {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                logger.info("O produto com o id " + id + " é "  + produto.getNome());
                return produto;
            }
        }
        logger.info("Produto com id " + id + " inexistente");
        return null;
    }

    public static void listarProdutos() {
        for (Produto produto : produtos) {
            produto.detalharProduto();
        }
    }
}
