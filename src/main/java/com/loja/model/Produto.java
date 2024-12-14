package main.java.com.loja.model;

public class Produto {
    private int id;
    private String nome;
    private float preco;
    private static int contador = 1;

    public Produto(String nome, float preco) {
        this.id = contador;
        contador++;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {return id;}
    public String getNome() {return nome;}
    public float getPreco() {return preco;}

    public void detalharProduto() {
        System.out.println("Id: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Preco: " + preco);
    }
}
