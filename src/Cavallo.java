import java.util.ArrayList;

class Gara extends Thread {
    //variabile privata
    private int percorso = 0;
    private final int lungh;
    private final String nome;
    private final int azzoppa;
    private static ArrayList<String> tabella = new ArrayList<>();
    //costruttore
    public Gara(String nome, int num, int azzoppa){
        super();
        this.azzoppa = azzoppa;
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
                if (azzoppa > 0 && percorso > azzoppa) {
                    Thread.sleep(3000);
                } else {
                    Thread.sleep(2000);
                }
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