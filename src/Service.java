package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static java.lang.Math.max;

public class Service {
    int lucro;

    private PriorityQueue<Compra> compraList = new PriorityQueue<>();
    private PriorityQueue<Venda> vendaList = new PriorityQueue<>();

    public void addVenda(int qtd, int valor) {
        vendaList.add(new Venda(qtd, valor));

    }

    public void addCompra(int qtd, int valor) {
        compraList.add(new Compra(qtd, valor));
    }

    public List<Venda> naoVendidas(){
        return vendaList.stream().filter(compra -> compra.getQuantidade() > 0).collect(Collectors.toList());
    }

    public List<Compra> naoCompradas(){
        return compraList.stream().filter(compra -> compra.getQuantidade() > 0).collect(Collectors.toList());
    }
    public String operacao(){
        int index = max(compraList.size(), vendaList.size());
        for (int i = 0; i < index; i++){
        int qty =compraList.peek().getQuantidade() - vendaList.peek().getQuantidade();
        if ( qty > 0)
        {
            lucro += vendaList.peek().getQuantidade() * (compraList.peek().getPreco() - vendaList.peek().getPreco());
            compraList.peek().setQuantidade(qty);
            vendaList.peek().setQuantidade(0);

        }
        else if ( qty < 0)
        {
            lucro += -(qty) * (compraList.peek().getPreco() - vendaList.peek().getPreco());
            compraList.peek().setQuantidade(compraList.peek().getQuantidade() + qty);
            vendaList.peek().setQuantidade(vendaList.peek().getQuantidade() + qty);
        }
            return "" + compraList;
        }
       return "";
    }

}
