package src;

public class Venda {
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

    public void setPreco(int preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder("Venda: \t");
        msg.append("\nQuantidade -> \t" + getQuantidade());
        msg.append("\nPreço -> \t" + getPreco());
        msg.append("\n");

        return msg.toString();
    }
}
