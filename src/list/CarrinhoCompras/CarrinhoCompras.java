package list.CarrinhoCompras;

import list.OperacoesBasicas.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private List<Item> taskList;

    public CarrinhoCompras(){
       this.taskList = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        taskList.add(new Item(nome, preco, quantidade));
    }

    public void removerItem(String nome){
        List<Item> newTaskRemoved = new ArrayList<>();

        for(Item i : taskList){
            if(i.getNome().equalsIgnoreCase(nome)){
                newTaskRemoved.add(i);
            }
        }
        taskList.removeAll(newTaskRemoved);
    }

    public double calcularValorTotal(){
        double valorTotal = 0d;
        if (!taskList.isEmpty()) {
            for (Item item : taskList) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem; //valorTotal = valorTotal + valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirItens(){
        System.out.println(taskList);
    }

    public static void main(String[] args) {
        CarrinhoCompras tarefa = new CarrinhoCompras();

        tarefa.adicionarItem("Arroz", 5.90, 2);
        tarefa.adicionarItem("Feijão", 8.90, 5);
        tarefa.adicionarItem("Salada", 16.90, 4);
        tarefa.adicionarItem("Carne", 10.50, 9);

        tarefa.exibirItens();

        tarefa.removerItem("Arroz");

        System.out.println("o valor total das suas compras é "+ tarefa.calcularValorTotal());

    }
}
