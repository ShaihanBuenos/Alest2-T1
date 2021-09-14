package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {

        String path = "C:\\Users\\Shaihan\\Desktop\\Alest2-T1\\casosDeTeste\\trinta.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            Map<String,String> compras = new HashMap<>();
            Map<String,String> vendas = new HashMap<>();


            String line = br.readLine();
            while(line != null) {
                String [] fields = line.split(" ");

                if(fields[0].equalsIgnoreCase("C")) {
                    compras.put(fields[1],fields[2]);
                }
                else if(fields[0].equalsIgnoreCase("V")) {
                    vendas.put(fields[1],fields[2]);
                }
                else{
                    System.out.println("Padrão não aceito!");
                }

                line = br.readLine();
            }

            System.out.println(compras);
            System.out.println(vendas);
        }
        catch (IOException e) {
            System.out.println("Nem ideia do que isto significa! " + e.getMessage());
        }

    }

}
