package src;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private int lucro;

    private List<Compra> compraList = new ArrayList<>();
    private List<Venda> vendaList = new ArrayList<>();

    public void addVenda(int qtd, int valor) {
        vendaList.add(new Venda(qtd, valor));
    }

    public void addCompra(int qtd, int valor) {
        compraList.add(new Compra(qtd, valor));
    }

    public List<Venda> naoVendidas() {
        return vendaList.stream().filter(compra -> compra.getQuantidade() > 0).collect(Collectors.toList());
    }

    public List<Compra> naoCompradas() {
        return compraList.stream().filter(compra -> compra.getQuantidade() > 0).collect(Collectors.toList());
    }

    public String operacao() {
        compraList.sort(Compra::compareTo);
        vendaList.sort(Venda::compareTo);
        int x = 0;
        int y = 0;
        while (compraList.get(y).getPreco() > vendaList.get(x).getPreco()) {


            if (compraList.get(y).getQuantidade() > vendaList.get(x).getQuantidade() && compraList.get(y).getPreco() > vendaList.get(x).getPreco()) {
                lucro += vendaList.get(x).getQuantidade() * (compraList.get(y).getPreco() - vendaList.get(x).getPreco());
                compraList.get(y).setQuantidade(vendaList.get(x).getQuantidade());
                vendaList.get(x).setQuantidade(0);
                if (compraList.get(y).getQuantidade() == 0) {
                    y++;
                } else if (vendaList.get(x).getQuantidade() == 0) {
                    x++;
                }

            } else if (vendaList.get(x).getQuantidade() > compraList.get(y).getQuantidade() && compraList.get(y).getPreco() > vendaList.get(x).getPreco()) {
                lucro += compraList.get(y).getQuantidade() * (compraList.get(y).getPreco() - vendaList.get(x).getPreco());
                vendaList.get(x).setQuantidade(compraList.get(y).getQuantidade());
                compraList.get(y).setQuantidade(0);

                if (compraList.get(y).getQuantidade() == 0) {
                    y++;
                }
                if (vendaList.get(y).getQuantidade() == 0) {
                    x++;
                }
            } else if (vendaList.get(x).getQuantidade() == compraList.get(y).getQuantidade() && compraList.get(y).getPreco() > vendaList.get(x).getPreco()) {
                lucro += compraList.get(y).getQuantidade() * (compraList.get(y).getPreco() - vendaList.get(x).getPreco());
                vendaList.get(x).setQuantidade(0);
                compraList.get(y).setQuantidade(0);
                if (compraList.get(y).getQuantidade() == 0) {
                    y++;
                }
                if (vendaList.get(x).getQuantidade() == 0) {
                    x++;
                }
            }
        }
        return "" + compraList + vendaList;
    }

}
