package src;


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
