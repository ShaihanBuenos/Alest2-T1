package src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {

    private List<Compra> compraList = new ArrayList<>();
    private List<Venda> vendaList = new ArrayList<>();

    public void addVenda(int qtd, int valor) {
        vendaList.add(new Venda(qtd, valor));
    }

    public void addCompra(int qtd, int valor) {
        compraList.add(new Compra(qtd, valor));
    }

    public void comprei(Venda venda) {
        //compraList.stream().findFirst().ifPresent(compra -> compra.setVendidas(true));
    }

    public List<Compra> naoVendidas(){
        return compraList.stream().filter(compra -> compra.getQuantidade() > 0).collect(Collectors.toList());
    }

}
