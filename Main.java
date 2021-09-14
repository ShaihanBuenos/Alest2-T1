package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

        Service service = new Service();
        String path = "C:\\Users\\laura_ribeiro\\IdeaProjects\\Alest2-T1\\casosDeTeste\\trinta.txt";
        Map<Integer, Integer> compras = new HashMap<>();
        Map<Integer, Integer> vendas = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int value1, value2;
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(" ");

                if (fields[0].equalsIgnoreCase("C")) {
                    value1 = Integer.parseInt(fields[1]);
                    value2 = Integer.parseInt(fields[2]);
                    service.addCompra(value1, value2);
                    compras.put(value1, value2);
                } else if (fields[0].equalsIgnoreCase("V")) {
                    value1 = Integer.parseInt(fields[1]);
                    value2 = Integer.parseInt(fields[2]);
                    service.addVenda(value1, value2);
                    vendas.put(value1, value2);
                } else {
                    System.out.println("Padrão não aceito!");
                }

                line = br.readLine();
            }
            System.out.println(compras);
            System.out.println(vendas);

        } catch (IOException e) {
            System.out.println("Nem ideia do que isto significa! " + e.getMessage());
        }

    }

}