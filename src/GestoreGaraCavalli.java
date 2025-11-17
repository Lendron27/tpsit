import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class GestoreGaraCavalli {
    public static void main(String[] args) throws InterruptedException {
        Scanner tastiera= new Scanner(System.in);
        //create a print writer for writing to a file
        System.out.println("Quanto è lungo il percorso?");
        int count= tastiera.nextInt();
        tastiera.nextLine();
        Gara[] cavalli = new Gara[5];
        Random random = new Random();
        int cavAz = random.nextInt(0, 4);
        int dist = random.nextInt(1, count);
        int azzoppa;
        File f = FileChooserUtility.chooseFile();
        for (int i = 0; i < 5; i++) {
            System.out.print("Inserisci nome cavallo: ");
            String nome = tastiera.next();
            if (i == cavAz) {
                azzoppa = dist;
            } else {
                azzoppa = 0;
            }
            cavalli[i] = new Gara(nome, count, azzoppa);
        }

        System.out.println(cavalli[cavAz].getNome() + " diventerà zoppo quando raggiungerà " + dist + "m. Cavalli in partenza:");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + ") " + cavalli[i].getNome());
        }

        for (int i = 0; i < 5; i++) {
            cavalli[i].start();
        }

        for (int i = 0; i < 5; i++) {
            cavalli[i].join();
        }

        ArrayList<String> classifica = Gara.getTabella();
        System.out.println("Classifica:");
        for (int i = 0; i < classifica.size(); i++) {
            System.out.println((i + 1) + ") " + classifica.get(i));
        }
        try (FileWriter writer = new FileWriter(f)) {
            writer.write("Classifica:\n");
            for (int i = 0; i < classifica.size(); i++) {
                writer.write((i + 1) + ") " + classifica.get(i) + "\n");
            }
            System.out.println("Classifica salvata su file:"+ f.getName());
        } catch (IOException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}