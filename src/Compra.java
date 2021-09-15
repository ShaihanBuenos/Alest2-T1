package src;

public class Compra implements Comparable<Compra> {
    private int quantidade;
    private int preco;

    public Compra(int quantidade, int preco) {
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPreco() {
        return preco;
    }

    @Override
    public int compareTo(Compra o) {
        if (o.getQuantidade() > 0 && this.getPreco() > o.getPreco()) {
            return -1;
        } else if (this.getPreco() < o.getPreco()) {
            return 1;
        } else {
            return 0;
        }

    }
}
