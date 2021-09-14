package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class Service {

    public PriorityQueue<Compra> getCompraList() {
        return compraList;
    }

    public PriorityQueue<Venda> getVendaList() {
        return vendaList;
    }

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



}
