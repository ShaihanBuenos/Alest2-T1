package src;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Service {
    private int lucro;
    private int transacoes;
    int x = 0;
    int y = 0;

    private PriorityQueue<Compra> compraList = new PriorityQueue<>();
    private PriorityQueue<Venda> vendaList = new PriorityQueue<>();

    public void addVenda(int qtd, int valor) {
        vendaList.add(new Venda(qtd, valor));
        operacaoCompra();
    }

    public void addCompra(int qtd, int valor) {
        compraList.add(new Compra(qtd, valor));
        operacaoCompra();
    }

    public void setLucro(int valor){
        this.lucro += valor;
    }

    public int getLucro(){
        return lucro;
    }

    public List<Venda> naoVendidas() {
        return vendaList.stream().collect(Collectors.toList());
    }

    public List<Compra> naoCompradas() {
        return compraList.stream().collect(Collectors.toList());
    }

    public void operacaoCompra() {
        if (compraList.peek()!= null && vendaList.peek() != null){
            System.out.println("Quero vender " + vendaList.peek().getQuantidade() + " por " + vendaList.peek().getPreco());
            System.out.println("Quero comprar " + compraList.peek().getQuantidade() + " por " +compraList.peek().getPreco() );
        if (compraList.peek().getQuantidade() > vendaList.peek().getQuantidade() && compraList.peek().getPreco() > vendaList.peek().getPreco()) {

            setLucro(vendaList.peek().getQuantidade() * (compraList.peek().getPreco() - vendaList.peek().getPreco()));
            setTransacoes(vendaList.peek().getQuantidade());
            System.out.println("Vendendo: " + vendaList.peek().getQuantidade());
            System.out.println("Lucro por ação: " + (compraList.peek().getPreco() - vendaList.peek().getPreco()));
            System.out.println("Lucro total: " + (vendaList.peek().getQuantidade() * (compraList.peek().getPreco() - vendaList.peek().getPreco())) + "\n");
            compraList.peek().setQuantidade(compraList.peek().getQuantidade() - vendaList.peek().getQuantidade());
            vendaList.poll();
        } else if (vendaList.peek().getQuantidade() > compraList.peek().getQuantidade() && compraList.peek().getPreco() > vendaList.peek().getPreco()) {
            System.out.println("Vendendo: " + compraList.peek().getQuantidade());
            System.out.println("Lucro por ação: " + (compraList.peek().getPreco() - vendaList.peek().getPreco()));
            System.out.println("Lucro total: " + (compraList.peek().getQuantidade() * (compraList.peek().getPreco() - vendaList.peek().getPreco())) + "\n");
            setLucro(compraList.peek().getQuantidade() * (compraList.peek().getPreco() - vendaList.peek().getPreco()));
            setTransacoes(compraList.peek().getQuantidade());
            vendaList.peek().setQuantidade(vendaList.peek().getQuantidade() - compraList.peek().getQuantidade());
            compraList.poll();
        }
        else{
            System.out.println("*** Nada a fazer\n");
        }

        }
        else {
            System.out.println("Um é nulo");
        }

    }

    public int getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(int acoes) {
        this.transacoes += acoes;
    }
}
