package src;

public class Venda {
    private String quantidade;
    private String preco;

    public Venda(String quantidade, String preco){
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getQuantidade(){
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getPreco(){
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        StringBuilder msg = new StringBuilder("Venda: \t");
        msg.append("\nQuantidade -> \t" + getQuantidade());
        msg.append("\nCompania Aerea -> \t" + getPreco());
        msg.append("\n");

        return msg.toString();
    }
}
