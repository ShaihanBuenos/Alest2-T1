package src;


import java.util.Collection;

public class Compra implements Comparable<Compra>{
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

    public void setPreco(int preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder("C");
        msg.append(" " + getQuantidade());
        msg.append( " " + getPreco());
        msg.append("\n");

        return msg.toString();
    }

    @Override
    public int compareTo(Compra o) {
        if(this.getPreco() < o.getPreco()){
            return 1;}
        else if(this.getPreco() == o.getPreco()){
            return 0;
        }
        else {
            return -1;
        }

    }
}
