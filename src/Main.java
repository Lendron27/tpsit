import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner tastiera= new Scanner(System.in);
        System.out.println("Quanto è lungo il percorso?");
        int count= tastiera.nextInt(); //.nextLine() per leggere la riga
        //singolo thread
        Gara thr1 = new Gara(count);
        Gara thr2 = new Gara(count);
        Gara thr3 = new Gara(count);
        Gara thr4 = new Gara(count);
        Gara thr5 = new Gara(count);
        thr1.start();
        thr2.start();
        thr3.start();
        thr4.start();
        thr5.start();
    }
}

class Gara extends Thread {
    //variabile privata
    private final int lungh;
    //costruttore
    public Gara(int num){
        super();
        lungh=num;
    }
    @Override
    public void run() {
        Scanner tastiera= new Scanner(System.in);
        System.out.println("Come si chiama il cavallo?");
        setName(tastiera.nextLine());
        for (int i = 0; i < lungh; i+=5) {
            System.out.println((i + 1) + " metri fatti da " + Thread.currentThread().getName());
        }
    }
}