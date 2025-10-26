import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner tastiera= new Scanner(System.in);
        System.out.println("Quanto è lungo il percorso?");
        int count= tastiera.nextInt(); //.nextLine() per leggere la riga
        // crea e avvia 5  Cavallo
        Gara[] cavalli = new Gara[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Inserisci nome cavallo: ");
            String nome = tastiera.next();
            cavalli[i] = new Gara(nome, count);
        }

        System.out.println("Cavalli in partenza:");
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
    }
}

class Gara extends Thread {
    //variabile privata
    private int percorso = 0;
    private final int lungh;
    private final String nome;
    private static ArrayList<String> tabella = new ArrayList<>();
    //costruttore
    public Gara(String nome, int num){
        super();
        this.nome = nome;
        lungh=num;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void run() {
        while (percorso < lungh) {
            percorso += 5;
            System.out.println(percorso + "m percorsi da " + nome);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        synchronized (tabella) {
            tabella.add(nome);
        }
    }

    public static ArrayList<String> getTabella() {
        return tabella;
    }
}