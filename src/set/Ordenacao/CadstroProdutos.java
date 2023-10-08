package set.Ordenacao;

import java.util.*;

public class CadstroProdutos {

    private Set<Produto> produtoSet;

    public CadstroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(long cod, String nome, double preco, int quantidade){
        produtoSet.add(new Produto(cod, nome, preco, quantidade));
    }

    public Set<Produto> exibirProdutosPorNome() {
        Set<Produto> produtosPorNome = new TreeSet<>(produtoSet);
        return produtosPorNome;
    }

    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtoSet.addAll(produtoSet);
        return produtosPorPreco;
    }

    public static void main(String[] args) {
        CadstroProdutos cadstroProdutos = new CadstroProdutos();

        cadstroProdutos.adicionarProduto(1L, "Produto 5", 15d, 5);
        cadstroProdutos.adicionarProduto(2L, "Produto 6", 20d, 10);
        cadstroProdutos.adicionarProduto(1L, "Produto 3", 10d, 2);
        cadstroProdutos.adicionarProduto(9L, "Produto 9", 15d, 5);

        System.out.println(cadstroProdutos.produtoSet);

    }
}



