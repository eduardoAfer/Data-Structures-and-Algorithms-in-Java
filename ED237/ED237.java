import java.util.Scanner;

class Process {
    public String name;
    public int time;

    Process(String n, int t) {
        name = n;
        time = t;
    }
}

public class ED237 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyQueue<Process> processFila = new LinkedListQueue<Process>();
        int iteracoes = 1;
        int T = in.nextInt();
        int N = in.nextInt();
        Process protmp;
        int tempo = 0;

        for (int i = 0; i < N; i++) {
            String nomeprocess = in.next();
            int timeprocess = in.nextInt();
            Process aux = new Process(nomeprocess, timeprocess);
            processFila.enqueue(aux);
        }

        while (!(processFila.isEmpty())) {
            if (processFila.first().time - T <= 0) {
                tempo += (processFila.first().time);
                System.out.println(processFila.dequeue().name + " " + tempo + " " + iteracoes);

            } else {
                processFila.first().time = processFila.first().time - T;
                tempo += T;
                protmp = processFila.first();
                processFila.dequeue();
                processFila.enqueue(protmp);
            }
            iteracoes++;
        }
    }
}