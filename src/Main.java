import entities.Produtos;
import service.CalculationService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Produtos> list = new ArrayList<>();

        String path = "C\\in.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){

            String line = br.readLine();
            while (line != null){
                String[] fieldes = line.split(",s");
                list.add((new Produtos(fieldes[0], Double.parseDouble(fieldes[1]))));
                line = br.readLine();
            }

            Produtos x = CalculationService.max(list);
            System.out.println("Most expansive: ");
            System.out.println(x);


        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}