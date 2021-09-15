package src;

import static java.lang.Math.max;

public class Venda implements Comparable<Venda>{
    private int quantidade;
    private int preco;

    public Venda(int quantidade, int preco){

        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getPreco(){
        return preco;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder("V");
        msg.append(" " + getQuantidade());
        msg.append(" " + getPreco());
        msg.append("\n");

        return msg.toString();
    }

    @Override
    public int compareTo(Venda o) {
        if(o.getQuantidade() > 0 && this.getPreco() < o.getPreco()){
            return -1;}
        else if(this.getPreco() > o.getPreco()){
            return 1;
        }
        else {
            return 0;
        }
    }
}
