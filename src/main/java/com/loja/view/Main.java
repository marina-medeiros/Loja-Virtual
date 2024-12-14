package com.loja.view;

import main.java.com.loja.model.Produto;
import main.java.com.loja.dao.Catalogo;
import main.java.com.loja.dao.Pedido;

public class Main{
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();

        Produto geladeira = new Produto("Geladeira", 1000.0f);
        Produto cama = new Produto("Cama", 800);
        Produto cadeira = new Produto("Cadeira", 100.0f);
        Produto garrafa = new Produto("Garrafa", 12);
        Produto copo = new Produto("Copo", 8);

        Pedido pedido01 = new Pedido("Marina");
        Pedido pedido02 = new Pedido("Nanda");

        try{
            Catalogo.adicionarProduto(geladeira);
            Catalogo.adicionarProduto(cadeira);
            Catalogo.adicionarProduto(cama);
            Catalogo.adicionarProduto(copo);
            Catalogo.adicionarProduto(garrafa);
        } catch (ArrayStoreException e) {
            e.getCause();
        }

        Catalogo.buscarProdutoPorId(12);
        Catalogo.buscarProdutoPorId(1);

        try{
            Catalogo.listarProdutos();
            pedido01.adicionarProduto(geladeira);
            pedido01.adicionarProduto(cama);
            pedido01.adicionarProduto(cadeira);
            pedido02.adicionarProduto(garrafa);
            pedido02.adicionarProduto(copo);
        }catch (ArrayStoreException e) {
            e.getCause();
        }

        pedido01.detalharPedido();
        pedido02.detalharPedido();
    }
}
