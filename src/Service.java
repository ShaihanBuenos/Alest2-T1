package src;

import java.util.PriorityQueue;

public class Service {
    private int lucro;
    private int transacoes;

    private PriorityQueue<Compra> compraList = new PriorityQueue<>();
    private PriorityQueue<Venda> vendaList = new PriorityQueue<>();

    public void addVenda(int qtd, int valor) {
        vendaList.add(new Venda(qtd, valor));
        operacao();
    }

    public void addCompra(int qtd, int valor) {
        compraList.add(new Compra(qtd, valor));
        operacao();
    }

    public void setLucro(int valor) {
        this.lucro += valor;
    }

    public int getLucro() {
        return lucro;
    }

    public int naoVendidas() {
        return vendaList.size();
    }

    public int naoCompradas() {
        return compraList.size();
    }

    public int getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(int acoes) {
        this.transacoes += acoes;
    }

    public void operacao() {
        if (compraList.peek() != null && vendaList.peek() != null && compraList.peek().getPreco() > vendaList.peek().getPreco()) {

            while (compraList.peek().getPreco() > vendaList.peek().getPreco() && compraList.peek() != null && vendaList.peek() != null) {
                if (compraList.peek().getQuantidade() > vendaList.peek().getQuantidade()) {

                    setLucro(vendaList.peek().getQuantidade() * (compraList.peek().getPreco() - vendaList.peek().getPreco()));
                    setTransacoes(vendaList.peek().getQuantidade());
                    compraList.peek().setQuantidade(compraList.peek().getQuantidade() - vendaList.peek().getQuantidade());
                    vendaList.poll();

                } else if (vendaList.peek().getQuantidade() > compraList.peek().getQuantidade()) {
                    setLucro(compraList.peek().getQuantidade() * (compraList.peek().getPreco() - vendaList.peek().getPreco()));
                    setTransacoes(compraList.peek().getQuantidade());
                    vendaList.peek().setQuantidade(vendaList.peek().getQuantidade() - compraList.peek().getQuantidade());
                    compraList.poll();
                }
                else if (vendaList.peek().getQuantidade() == compraList.peek().getQuantidade()) {
                    setLucro(compraList.peek().getQuantidade() * (compraList.peek().getPreco() - vendaList.peek().getPreco()));
                    setTransacoes(compraList.peek().getQuantidade());
                    vendaList.poll();
                    compraList.poll();
                }
            }

        }

    }

}
