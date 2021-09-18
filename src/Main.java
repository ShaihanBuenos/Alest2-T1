package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) {

        Service service = new Service();
        //String path = "C:\\Users\\laura_ribeiro\\IdeaProjects\\Alest2-T1\\casosDeTeste\\trinta_enunciado.txt";
        String path = "C:\\Users\\Shaihan\\Desktop\\Alest2-T1\\casosDeTeste\\trinta_enunciado.txt";
        long start = System.currentTimeMillis();


        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int value1, value2;
            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(" ");

                if (fields[0].equalsIgnoreCase("C")) {
                    value1 = Integer.parseInt(fields[1]);
                    value2 = Integer.parseInt(fields[2]);
                    service.addCompra(value1, value2);

                } else if (fields[0].equalsIgnoreCase("V")) {
                    value1 = Integer.parseInt(fields[1]);
                    value2 = Integer.parseInt(fields[2]);
                    service.addVenda(value1, value2);

                }

                line = br.readLine();
            }
            long end = System.currentTimeMillis();
            System.out.println("Lucro: " + service.getLucro() + "\nAções Negociadas: " + service.getTransacoes()
                    + "\nCompras Restantes: " + service.naoCompradas() + "\nVendas Restantes: " + service.naoVendidas()
                    + "\nTempo em milissegundos: " + (end-start));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
